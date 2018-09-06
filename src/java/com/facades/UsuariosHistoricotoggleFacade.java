package com.facades;

import com.entidades.Historicotoggle;
import com.entidades.Usuarios;
import com.entidades.UsuariosHistoricotoggle;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Nahuel Rullo <nahuelrullo at gmail.com>
 */
@Stateless
public class UsuariosHistoricotoggleFacade extends AbstractFacade<UsuariosHistoricotoggle> {

	@PersistenceContext(unitName = "ubuntu_PU")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public UsuariosHistoricotoggleFacade() {
		super(UsuariosHistoricotoggle.class);
	}

	public List<UsuariosHistoricotoggle> findByIdUsuario(Usuarios idUsuario) {
		String isql = "";
		isql += "SELECT uht ";
		isql += "FROM UsuariosHistoricotoggle uht ";
		isql += "WHERE ";
		isql += "uht.idUsuario = :idUsuario ";
		isql += "ORDER BY uht.idToggle ASC ";
		Query qry = em.createQuery(isql, UsuariosHistoricotoggle.class);
		qry.setParameter("idUsuario", idUsuario);
		return qry.getResultList();
	}

	public UsuariosHistoricotoggle findByIdUsuarioAndIdToggle(Usuarios idUsuario, Historicotoggle idToggle) {
		String isql = "";
		isql += "SELECT uht ";
		isql += "FROM UsuariosHistoricotoggle uht ";
		isql += "WHERE ";
		isql += "uht.idUsuario = :idUsuario ";
		isql += "AND ";
		isql += "uht.idToggle = :idToggle ";
		Query qry = em.createQuery(isql, UsuariosHistoricotoggle.class);
		qry.setParameter("idUsuario", idUsuario);
		qry.setParameter("idToggle", idToggle);
		List<UsuariosHistoricotoggle> tmp = qry.getResultList();
		if (tmp.isEmpty()) return null;
		return tmp.get(0);
	}

}
