package com.facades;

import com.entidades.Materialesestados;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author jsturla
 */
@Stateless
public class MaterialesestadosFacade extends AbstractFacade<Materialesestados> {
  @PersistenceContext(unitName = "ubuntu_PU")
  private EntityManager em;

  @Override
  protected EntityManager getEntityManager() {
    return em;
  }

  public MaterialesestadosFacade() {
    super(Materialesestados.class);
  }
  
}
