package com.facades;

import com.entidades.Usuarios;
import com.utils.Consts;
import com.utils.Utils;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


@Stateless
public class UsuariosFacade extends AbstractFacade<Usuarios> {

	@PersistenceContext(unitName = "ubuntu_PU")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public UsuariosFacade() {
		super(Usuarios.class);
	}
        
        public Usuarios findById(Integer id){
            Query qry = em.createNamedQuery("Usuarios.findByIdUsuario", Usuarios.class);
            if(id!=null)
                qry.setParameter("idUsuario", id);
            return (Usuarios)qry.getSingleResult();
        }
        
      public List<Usuarios> findHabilitados() {
        String isql = "";
        isql += "SELECT m FROM Usuarios m ";
        isql += "WHERE m.habilitado = 0 ";
        Query qry = em.createQuery(isql);
        List<Usuarios> rval = qry.getResultList();

        return rval;
    }

	public Usuarios validateByUsername(String username, String password) {

		Usuarios usuario = null;

		String isql = "";
		isql += "SELECT u ";
		isql += "FROM Usuarios u ";
		isql += "WHERE ";
		isql += "u.user = :username ";
		isql += "AND ";
		isql += "u.habilitado = :habilitado ";

		Query qry = em.createQuery(isql, Usuarios.class);
		qry.setParameter("username", username);
		qry.setParameter("habilitado", Consts.REGISTRO_HABILITADO);

		List<Usuarios> tmp = qry.getResultList();

		if (!tmp.isEmpty()) {
			usuario = tmp.get(0);
			if (usuario.getPassword().equals(Utils.createPasswdHash(password)) ) {
				return usuario;
			}
		}
		return null;
	}

	public Usuarios validateByIdUsuario(Integer idUsuario, String encriptedPasswd) {

		Usuarios usuario = null;

		String isql = "";
		isql += "SELECT u ";
		isql += "FROM Usuarios u ";
		isql += "WHERE ";
		isql += "u.idUsuario = :idUsuario ";
		isql += "AND ";
		isql += "u.habilitado = :habilitado ";

		Query qry = em.createQuery(isql, Usuarios.class);
		qry.setParameter("idUsuario", idUsuario);
		qry.setParameter("habilitado", Consts.REGISTRO_HABILITADO);

		List<Usuarios> tmp = qry.getResultList();

		if (!tmp.isEmpty()) {
			usuario = tmp.get(0);

			if (usuario.getPassword().equals(encriptedPasswd)) {
				return usuario;
			}

		}

		return null;
	}

}
