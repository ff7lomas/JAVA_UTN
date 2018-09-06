package com.facades;

import com.entidades.Materiales;
import com.entidades.Materialesbitacora;
import com.entidades.Materialesestados;
import com.utils.Consts;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Nahuel Rullo <nahuelrullo at gmail.com>
 */
@Stateless
public class MaterialesbitacoraFacade extends AbstractFacade<Materialesbitacora> {

  @PersistenceContext(unitName = "ubuntu_PU")
  private EntityManager em;

  @EJB
  private com.facades.MaterialesestadosFacade materialesestadosFacade;

  @Override
  protected EntityManager getEntityManager() {
    return em;
  }

  public MaterialesbitacoraFacade() {
    super(Materialesbitacora.class);
  }

  public List<Materialesbitacora> findLastProcesos(Materiales idMaterial) {
    Materialesestados idEstMaterial = materialesestadosFacade.find(Consts.ESTADO_MATERIAL_NO_DISPONIBLE);

    String isql = "SELECT mb ";
    isql += "FROM Materialesbitacora mb ";
    isql += "WHERE mb.fechayhora >= (";
    isql += "SELECT MAX(mbb.fechayhora) ";
    isql += "FROM Materialesbitacora mbb ";
    isql += "WHERE mbb.idEstMaterial = :idEstMaterial ";
    isql += "AND mbb.idMaterial = :idMaterial";
    isql += ")";
    isql += "AND mb.idMaterial = :idMaterial ";

    Query qry = em.createQuery(isql, Materialesbitacora.class);
    qry.setParameter("idEstMaterial", idEstMaterial);
    qry.setParameter("idMaterial", idMaterial);

    List<Materialesbitacora> rval = qry.getResultList();

    return rval;
  }

}
