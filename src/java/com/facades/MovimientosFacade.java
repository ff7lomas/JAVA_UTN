package com.facades;

//import com.entidades.Equipos;
import com.entidades.Movimiento;
//import com.entidades.Esterilizacionestados;
import com.entidades.Materiales;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author jsturla
 */
@Stateless
public class MovimientosFacade extends AbstractFacade<Movimiento> {

  @PersistenceContext(unitName = "ubuntu_PU")
  private EntityManager em;

  @Override
  protected EntityManager getEntityManager() {
    return em;
  }

  public MovimientosFacade() {
    super(Movimiento.class);
  }

  public Movimiento findByIdMaterial(Integer idMaterial) {
    Movimiento rval = null;

    String isql = "SELECT e ";
    isql += "FROM Movimiento e ";
//    isql += "JOIN e.idEstadoEst ee";
//    isql += "JOIN e.paquetesCollection p ";
    isql += "JOIN p.materialesCollection m ";
//    isql += "WHERE (e.idEstadoEst = :idEstadoEst1 OR e.idEstadoEst = :idEstadoEst2) AND ";
    isql += "WHERE (m.idMaterial = :idMaterial)";

    Query qry = em.createQuery(isql, Movimiento.class);
//    qry.setParameter("idEstadoEst1", new Esterilizacionestados(1));
//    qry.setParameter("idEstadoEst2", new Esterilizacionestados(2));
    qry.setParameter("idMaterial", idMaterial);

    List<Movimiento> tmp = qry.getResultList();

    if (!tmp.isEmpty()) {
      rval = tmp.get(0);
    }

    return rval;
  }

  public Integer getNextId() {
    String isql = "";
    isql += "SELECT MAX(e.idmovimientos) ";
    isql += "FROM Movimiento e ";

    Query qry = em.createQuery(isql, Integer.class);

    try {
      return (Integer) qry.getSingleResult() + 1;
    } catch (NoResultException e) {
      return 0;
    }
  }

}
