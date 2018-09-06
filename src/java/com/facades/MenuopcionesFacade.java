package com.facades;

import com.entidades.Menuopciones;
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
public class MenuopcionesFacade extends AbstractFacade<Menuopciones> {

  @PersistenceContext(unitName = "ubuntu_PU")
  private EntityManager em;

  @Override
  protected EntityManager getEntityManager() {
    return em;
  }

  public MenuopcionesFacade() {
    super(Menuopciones.class);
  }

  public List<Menuopciones> findAll(String orderBy, boolean withUri) {
    List<Menuopciones> rval = null;

    String isql = "SELECT mo FROM Menuopciones mo ";
    if (!withUri) {
      isql += "WHERE mo.uri IS NOT NULL ";
    }
    isql += "ORDER BY mo." + orderBy;

    Query qry = em.createQuery(isql, Menuopciones.class);
    rval = qry.getResultList();

    return rval;
  }

  public List<Menuopciones> findByTpoOpcion(Integer tpoOpcion) {
    String isql = "";
    isql += "SELECT mo ";
    isql += "FROM Menuopciones mo ";
    isql += "WHERE ";
    isql += "mo.idOpcion IS NOT NULL ";
    if (tpoOpcion != null) {
      isql += "AND ";
      isql += "mo.tpoOpcion = :tpoOpcion ";
    }
    isql += "ORDER BY mo.idOpcion ";

    Query qry = em.createQuery(isql, Menuopciones.class);
    if (tpoOpcion != null) {
      qry.setParameter("tpoOpcion", tpoOpcion);
    }
    
    return qry.getResultList();
  }
  
}
