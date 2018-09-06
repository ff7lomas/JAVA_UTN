/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.facades;

import com.entidades.Sistparam;
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
public class SistparamFacade extends AbstractFacade<Sistparam> {

  @PersistenceContext(unitName = "ubuntu_PU")
  private EntityManager em;

  @Override
  protected EntityManager getEntityManager() {
    return em;
  }

  public SistparamFacade() {
    super(Sistparam.class);
  }

  public Sistparam findByValorParametro(String valorParametro) {
    Query qry = em.createNamedQuery("Sistparam.findByValorParametro", Sistparam.class);
    if(valorParametro!=null)
        qry.setParameter("valorParametro", valorParametro);
    return (Sistparam)qry.getSingleResult();
  }
  
  public Sistparam findByClaveParametro(String claveParametro) {
    Query qry = em.createNamedQuery("Sistparam.findByClaveParametro", Sistparam.class);
    if(claveParametro!=null)
        qry.setParameter("claveParametro", claveParametro);
    return (Sistparam)qry.getSingleResult();
  }
  
  public Sistparam findById(Integer idSistparam) {
    Query qry = em.createNamedQuery("Sistparam.findById", Sistparam.class);
    if(idSistparam!=null)
        qry.setParameter("idSistparam", idSistparam);
    return (Sistparam)qry.getSingleResult();
  }

}
