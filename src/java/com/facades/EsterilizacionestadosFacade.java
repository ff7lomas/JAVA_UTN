package com.facades;

import com.entidades.Esterilizacionestados;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Nahuel Rullo <nahuelrullo at gmail.com>
 */
@Stateless
public class EsterilizacionestadosFacade extends AbstractFacade<Esterilizacionestados> {
  @PersistenceContext(unitName = "ubuntu_PU")
  private EntityManager em;

  @Override
  protected EntityManager getEntityManager() {
    return em;
  }

  public EsterilizacionestadosFacade() {
    super(Esterilizacionestados.class);
  }
  
}
