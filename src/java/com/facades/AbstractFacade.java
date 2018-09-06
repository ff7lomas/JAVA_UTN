package com.facades;

import com.entidades.Materiales;
import com.entidades.Materialesbitacora;
import com.entidades.Usuarios;
import com.utils.JsfUtil;
import com.views.LoginView;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.validation.ConstraintViolation;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;

import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import javax.validation.Validator;
/**
 *
 * @author Nahuel Rullo <nahuelrullo at gmail.com>
 */
public abstract class AbstractFacade<T> {

//	private static final Logger logger = LogManager.
						//		getLogger(AbstractFacade.class);

	private Class<T> entityClass;

	@Inject
	private LoginView loginView;

	public AbstractFacade(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

	protected abstract EntityManager getEntityManager();

	public void create(T entity) {
            ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
            Validator validator = factory.getValidator();
            Set<ConstraintViolation<T>> constraintViolations = validator.validate(entity);
            if(constraintViolations.size() > 0){
                Iterator<ConstraintViolation<T>> iterator = constraintViolations.iterator();
                while(iterator.hasNext()){
                    ConstraintViolation<T> cv = iterator.next();
                    System.err.println(cv.getRootBeanClass().getName()+"."+cv.getPropertyPath() + " " +cv.getMessage());

                    JsfUtil.addErrorMessage(cv.getRootBeanClass().getSimpleName()+"."+cv.getPropertyPath() + " " +cv.getMessage());
                }
            }else{
                getEntityManager().persist(entity);
            }
	}

	public void edit(T entity) {
		edit(entity, null);
	}

	public void edit(T entity, Usuarios usuario) {
		try {
			getEntityManager().merge(entity);

			// Si es un Material, logeo el cambio de estado en la bitacora de materiales
			if (entity instanceof Materiales) {
				Materialesbitacora materialbitacora = new Materialesbitacora();
				materialbitacora.setFechayhora(new Date());
				materialbitacora.setIdMaterial((Materiales) entity);
				materialbitacora.setIdEstMaterial(((Materiales) entity).getIdEstMaterial());
				if (usuario == null) {
					materialbitacora.setIdUsuario(loginView.getUsuario());
				} else {
					materialbitacora.setIdUsuario(usuario);
				}
				getEntityManager().merge(materialbitacora);
			}
		} catch (Exception e) {
		//	logger.error("Error al editar entidad. Excepción: " + e.getMessage());
		}
	}

	public void remove(T entity) {
		getEntityManager().remove(getEntityManager().merge(entity));
	}

	public T find(Object id) {
		return getEntityManager().find(entityClass, id);
	}

	public List<T> findAll() {
		return findAll(null);
	}

	public List<T> findAll(String colOrd) {
		return findAll(colOrd, null);
	}

	public List<T> findAll(String colOrd, Integer habilitado) {
		javax.persistence.criteria.CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery cq = cb.createQuery();
		javax.persistence.criteria.Root c = cq.from(entityClass);
		cq.select(c);
		if (colOrd != null) {
			cq.orderBy(cb.asc(c.get(colOrd)));
		}
		if (habilitado != null) {
			cq.where(cb.equal(c.get("habilitado"), habilitado));
		}
		return getEntityManager().createQuery(cq).getResultList();
	}

	public List<T> findRange(int[] range) {
		javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
		cq.select(cq.from(entityClass));
		javax.persistence.Query q = getEntityManager().createQuery(cq);
		q.setMaxResults(range[1] - range[0] + 1);
		q.setFirstResult(range[0]);
		return q.getResultList();
	}

	public int count() {
		javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
		javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
		cq.select(getEntityManager().getCriteriaBuilder().count(rt));
		javax.persistence.Query q = getEntityManager().createQuery(cq);
		return ((Long) q.getSingleResult()).intValue();
	}

}
