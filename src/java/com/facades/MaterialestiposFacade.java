package com.facades;

import com.entidades.Materialestipos;
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
public class MaterialestiposFacade extends AbstractFacade<Materialestipos> {
  @PersistenceContext(unitName = "ubuntu_PU")
  private EntityManager em;

  @Override
  protected EntityManager getEntityManager() {
    return em;
  }

  public MaterialestiposFacade() {
    super(Materialestipos.class);
  }
  
  public Integer nextId() {
	  String isql = "";
	  isql += "SELECT MAX(mt.idTipoMaterial) ";
	  isql += "FROM Materialestipos mt ";
	  
	  Query qry = em.createQuery(isql, Materialestipos.class);
	  
	  List<Integer> tmp = qry.getResultList();
	  if (tmp != null && !tmp.isEmpty()) {
		  return tmp.get(0) + 1;
	  }
	  return 1;
  }
  
}
