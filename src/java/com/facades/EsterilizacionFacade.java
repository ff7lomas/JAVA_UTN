package com.facades;

//import com.entidades.Equipos;
import com.entidades.Esterilizacion;
import com.entidades.Esterilizacionestados;
import com.entidades.Materiales;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Nahuel Rullo <nahuelrullo at gmail.com>
 */
@Stateless
public class EsterilizacionFacade extends AbstractFacade<Esterilizacion> {

  @PersistenceContext(unitName = "ubuntu_PU")
  private EntityManager em;

  @Override
  protected EntityManager getEntityManager() {
    return em;
  }

  public EsterilizacionFacade() {
    super(Esterilizacion.class);
  }

  public Esterilizacion findById(int idEsterilizacion) {
    List<Esterilizacion> tmp = em.createNamedQuery(
            "Esterilizacion.findByIdEsterilizacion", Esterilizacion.class)
            .setParameter("idEsterilizacion", idEsterilizacion)
            .getResultList();
    Esterilizacion rval = null;
    if (!tmp.isEmpty()) {
      rval = tmp.get(0);
    }
    return rval;
  }

  public Esterilizacion findByIdMaterial(Integer idMaterial) {
    Esterilizacion rval = null;

    String isql = "SELECT e ";
    isql += "FROM Esterilizacion e ";
//    isql += "JOIN e.idEstadoEst ee";
    isql += "JOIN e.paquetesCollection p ";
    isql += "JOIN p.materialesCollection m ";
    isql += "WHERE (e.idEstadoEst = :idEstadoEst1 OR e.idEstadoEst = :idEstadoEst2) AND ";
    isql += "(m.idMaterial = :idMaterial)";

    Query qry = em.createQuery(isql, Esterilizacion.class);
    qry.setParameter("idEstadoEst1", new Esterilizacionestados(1));
    qry.setParameter("idEstadoEst2", new Esterilizacionestados(2));
    qry.setParameter("idMaterial", idMaterial);

    List<Esterilizacion> tmp = qry.getResultList();

    if (!tmp.isEmpty()) {
      rval = tmp.get(0);
    }

    return rval;
  }

  public List<Esterilizacion> findByIdEquipo(String idEquipo) {
    List<Esterilizacion> rval = null;

    String isql = "SELECT e ";
    isql += "FROM Esterilizacion e ";
    isql += "WHERE e.idEquipo = :idEquipo ";

    Query qry = em.createQuery(isql, Esterilizacion.class);
    qry.setParameter("idEquipo", idEquipo);

    rval = qry.getResultList();

    return rval;
  }

  public int getCantIndicadores(Esterilizacion idEsterilizacion) {
    Query qry = em.createQuery(
            "SELECT COUNT(c) FROM Indicadores c WHERE c.idEsterilizacion = :idEsterilizacion",
            Integer.class
    )
            .setParameter("idEsterilizacion", idEsterilizacion);

    try {
      return (int) qry.getSingleResult();
    } catch (NoResultException e) {
      return 0;
    }
  }

  public int getPaquetes(Esterilizacion idEsterilizacion) {
    Query qry = em.createQuery(
            "SELECT COUNT(ep) FROM EsterilizacionPaquetes ep WHERE ep.idEsterilizacion = :idEsterilizacion",
            Integer.class
    )
            .setParameter("idEsterilizacion", idEsterilizacion);

    try {
      return (int) qry.getSingleResult();
    } catch (NoResultException e) {
      return 0;
    }
  }

  public Integer ultimoCiclo(String idEquipo) {
    Query qry = em.createQuery(
            "SELECT e.ciclo FROM Esterilizacion e WHERE e.idEsterilizacion = "
            + "(SELECT MAX(ee.idEsterilizacion) FROM Esterilizacion ee "
            + "WHERE ee.idEquipo = :idEquipo)",
            Integer.class
    )
            .setParameter("idEquipo", idEquipo);

    try {
      return (Integer) qry.getSingleResult();
    } catch (NoResultException e) {
      return 0;
    }
  }

  public Integer getNextId() {
    String isql = "";
    isql += "SELECT MAX(e.idEsterilizacion) ";
    isql += "FROM Esterilizacion e ";

    Query qry = em.createQuery(isql, Integer.class);

    try {
      return (Integer) qry.getSingleResult() + 1;
    } catch (NoResultException e) {
      return 0;
    }
  }

}
