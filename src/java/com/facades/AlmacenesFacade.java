/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.facades;

import com.entidades.Almacenes;
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
public class AlmacenesFacade extends AbstractFacade<Almacenes> {

  @PersistenceContext(unitName = "ubuntu_PU")
  private EntityManager em;

  @Override
  protected EntityManager getEntityManager() {
    return em;
  }

  public AlmacenesFacade() {
    super(Almacenes.class);
  }

  public Almacenes findByNomAlmacen(String nomAlmacen) {
    Query qry = em.createNamedQuery("Almacenes.findByNombre", Almacenes.class);
    qry.setParameter("nombre", nomAlmacen);
    List<Almacenes> tmp = qry.getResultList();
    if (tmp != null && !tmp.isEmpty()) {
      return tmp.get(0);
    }
    return null;
  }
  
  public Almacenes findById(Integer idAlmacen) {
    Query qry = em.createNamedQuery("Almacenes.findByIdAlmacen", Almacenes.class);
    if(idAlmacen!=null)
        qry.setParameter("idAlmacen", idAlmacen);
    return (Almacenes)qry.getSingleResult();
  }

}
