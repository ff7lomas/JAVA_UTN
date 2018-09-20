package com.facades;

import com.entidades.Paquetes;
//import com.Paquetesestados;
import com.utils.Consts;
import com.utils.Utils;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author jsturla
 */
@Stateless
public class PaquetesFacade extends AbstractFacade<Paquetes> {

	@PersistenceContext(unitName = "ubuntu_PU")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public PaquetesFacade() {
		super(Paquetes.class);
	}

//	public Paquetes findPreparadoByMaterial(Integer idMaterial) {
//		Paquetes rval = null;
//
//		Paquetesestados idEstPaquete = new Paquetesestados(Consts.ESTADO_PAQUETE_PREPARADO);
//
//		String isql = "";
//		isql += "SELECT p ";
//		isql += "FROM Paquetes p ";
//		isql += "LEFT OUTER JOIN p.materialesCollection i ";
//		isql += "WHERE i.idMaterial = :idMaterial ";
//		isql += "AND p.idEstPaquete = :idEstPaquete ";
//
//		Query qry = em.createQuery(isql, Paquetes.class);
//		qry.setParameter("idMaterial", idMaterial);
//		qry.setParameter("idEstPaquete", idEstPaquete);
//
//		List<Paquetes> tmp = qry.getResultList();
//
//		if (!tmp.isEmpty()) {
//			rval = tmp.get(0);
//		}
//
//		return rval;
//	}

//	public List<Paquetes> findByEstPaqueteAndMaterial(List<String> lsEstados, boolean pertenece, Integer idMaterial, Integer habilitado) {
//		List<Paquetes> rval = null;
//
//		String isql = "";
//		isql += "SELECT p ";
//		isql += "FROM Paquetes p ";
//		isql += "LEFT OUTER JOIN p.materialesCollection m ";
//		isql += "WHERE ";
//		isql += "m.idMaterial = :idMaterial ";
//		isql += "AND ";
//		isql += "p.idPaquete IS NOT NULL ";
//		if (lsEstados != null) {
//			if (pertenece) {
//				isql += "AND p.idEstPaquete.idEstPaquete IN " + Utils.list2jpqlList(lsEstados);
//			} else {
//				isql += "AND p.idEstPaquete.idEstPaquete NOT IN " + Utils.list2jpqlList(lsEstados);
//			}
//		}
//		if (habilitado != null) {
//			isql += "AND p.habilitado = :habilitado ";
//		}
//
//		Query qry = em.createQuery(isql, Paquetes.class);
//		qry.setParameter("idMaterial", idMaterial);
//		if (habilitado != null) {
//			qry.setParameter("habilitado", habilitado);
//		}
//
//		rval = qry.getResultList();
//
//		return rval;
//	}

//	public List<Paquetes> findByEstPaquete(Paquetesestados idEstPaquete) {
//		return findByEstPaquete(idEstPaquete, null);
//	}
//
	public List<Paquetes> findHabilitados() {
		List<Paquetes> rval = null;

		String isql = "SELECT p ";
		isql += "FROM Paquetes p ";
			isql += "AND p.habilitado = :habilitado ";
		

		Query qry = em.createQuery(isql, Paquetes.class);
		qry.setParameter("habilitado", Consts.REGISTRO_HABILITADO);

		rval = qry.getResultList();

		return rval;
	}

//	public List<Paquetes> findByEstPaquete(List<String> lsEstados, boolean pertenece, Integer habilitado) {
//		List<Paquetes> rval = null;
//
//		String isql = "";
//		isql += "SELECT p ";
//		isql += "FROM Paquetes p ";
//		isql += "WHERE p.idPaquete IS NOT NULL ";
//		if (lsEstados != null) {
//			if (pertenece) {
//				isql += "AND p.idEstPaquete.idEstPaquete IN " + Utils.list2jpqlList(lsEstados);
//			} else {
//				isql += "AND p.idEstPaquete.idEstPaquete NOT IN " + Utils.list2jpqlList(lsEstados);
//			}
//		}
//		if (habilitado != null) {
//			isql += "AND p.habilitado = :habilitado ";
//		}
//
//		Query qry = em.createQuery(isql, Paquetes.class);
//		qry.setParameter("habilitado", habilitado);
//
//		rval = qry.getResultList();
//
//		return rval;
//	}

}
