package com.facades;

import com.entidades.Almacenes;
//import com.entidades.Equipossubtipos;
//import com.entidades.Kits;
import com.entidades.Materiales;
import com.entidades.Materialesestados;
import com.entidades.Materialestipos;
import com.entidades.Paquetesestados;
//import com.entidades.Remitos;
import com.utils.Consts;
//import com.utils.Utils;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;

/**
 *
 * @author Nahuel Rullo <nahuelrullo at gmail.com>
 */
@Stateless
public class MaterialesFacade extends AbstractFacade<Materiales> {

//  private static final Logger logger = LogManager.getLogger(MaterialesFacade.class);

  @PersistenceContext(unitName = "ubuntu_PU")
  private EntityManager em;

  @Override
  protected EntityManager getEntityManager() {
    return em;
  }

  public MaterialesFacade() {
    super(Materiales.class);
  }

//  public List<Object[]> getAmountsByIdEstMaterial() {
//    List<Object[]> rval = em.createQuery("SELECT ie.dscEstadoMaterial AS estado, "
//            + "COUNT(ie.idEstMaterial) AS amount "
//            + "FROM Materiales i "
//            + "LEFT OUTER JOIN i.idEstMaterial ie "
//            + "WHERE i.idEstMaterial.idEstMaterial IS NULL OR "
//            + "i.idEstMaterial.idEstMaterial != " + Consts.ESTADO_MATERIAL_NO_DISPONIBLE + " "
//            + "GROUP BY i.idEstMaterial "
//            + "ORDER BY i.idEstMaterial")
//            .getResultList();
//    return rval;
//  }
  public List<Object[]> getAmountsByIdEstMaterial() {
    List<Object[]> rval = em.createNativeQuery("SELECT \n"
            + "me.dscEstadoMaterial AS estado, \n"
            + "count(m.idMaterial) AS amount \n"
            + "FROM materialesestados AS me \n"
            + "LEFT OUTER JOIN materiales AS m ON me.idEstMaterial=m.idEstMaterial \n"
            + "WHERE \n"
            + "me.idEstMaterial != 10 \n"
            + "AND \n"
            + "me.habilitado = 0 \n"
            + "GROUP BY me.idEstMaterial \n"
            + "ORDER BY me.idEstMaterial;")
            .getResultList();
    return rval;
  }

  public Materiales getByGtinAndLoteAndNroSerie(String gtin, String nroLote, int nroSerie) {
    String qry = "SELECT i ";
    qry += "FROM Materiales i ";
    qry += "WHERE i.gtin = :gtin ";
    qry += "AND i.nroLote = :nroLote ";
    if (nroSerie >= 0) {
      qry += "AND i.nroSerie = :nroSerie ";
    } else {
      qry += "AND i.nroSerie IS NULL AND :nroSerie = -1 ";
    }
    List<Materiales> tmp = em.createQuery(qry)
            .setParameter("gtin", gtin)
            .setParameter("nroLote", nroLote)
            .setParameter("nroSerie", nroSerie)
            .getResultList();
    Materiales rval = null;
    if (!tmp.isEmpty()) {
      rval = tmp.get(0);
    }
    return rval;
  }

  public Materiales findByGtinAndLoteAndNroSerie(String gtin, String nroLote, Integer nroSerie, Materialesestados idEstMaterial) {
    Materiales rval = null;

    String isql = "SELECT i ";
    isql += "FROM Materiales i ";
    isql += "WHERE i.gtin = :gtin ";
    isql += "AND i.nroLote = :nroLote ";
    isql += "AND i.nroSerie = :nroSerie ";
    isql += "AND i.idEstMaterial = :idEstMaterial";

    Query qry = em.createQuery(isql);
    qry.setParameter("gtin", gtin);
    qry.setParameter("nroLote", nroLote);
    qry.setParameter("nroSerie", nroSerie);
    qry.setParameter("idEstMaterial", idEstMaterial);

    List<Materiales> tmp = qry.getResultList();

    if (!tmp.isEmpty()) {
      rval = tmp.get(0);
    }
    return rval;
  }

  public List<Materiales> findNotInPaquetes() {
    String qry = "SELECT DISTINCT m ";
    qry += "FROM Materiales m ";
    qry += "WHERE m.paquetesCollection IS EMPTY ";
    List<Materiales> rval = em.createQuery(qry).getResultList();
    return rval;
  }

  public Materiales findByIdMaterialAndIdKit(Integer idMaterial, Integer idKit) {
    String isql = "";
    isql += "SELECT m ";
    isql += "FROM Materiales m ";
    isql += "WHERE m.idMaterial = :idMaterial ";
    if (idKit == null) {
      isql += "AND m.idKit IS NULL ";
    } else {
      isql += "AND m.idKit = :idKit ";
    }

    Query qry = em.createQuery(isql, Materiales.class);
    qry.setParameter("idMaterial", idMaterial);
    if (idKit != null) {
      qry.setParameter("idKit", idKit);
    }

    List<Materiales> tmp = qry.getResultList();
    if (tmp.isEmpty()) {
      return null;
    }
    return tmp.get(0);
  }

  public List<Materiales> findByIdPaquete(Integer idPaquete) {
    String isql = "";
    isql += "SELECT p.materialesCollection FROM Paquetes p ";
    isql += "WHERE p.idPaquete = :idPaquete ";
    Query qry = em.createQuery(isql);
    qry.setParameter("idPaquete", idPaquete);
    List<Materiales> rval = qry.getResultList();

    return rval;
  }
/*
  public List<Materiales> findByIdRemito(Integer idRemito) {
    String isql = "";
    isql += "SELECT r.materialesCollection FROM Remitos r ";
    isql += "WHERE r.idRemito = :idRemito ";
    Query qry = em.createQuery(isql, Remitos.class);
    qry.setParameter("idRemito", idRemito);
    List<Materiales> rval = qry.getResultList();

    return rval;
  }*/

  public List<Materiales> findNotInKits() {
    String qry = "SELECT DISTINCT m ";
    qry += "FROM Materiales m ";
    qry += "WHERE m.idKit IS NULL ";
    List<Materiales> rval = em.createQuery(qry).getResultList();
    return rval;
  }

  public List<Materiales> findInPaquetesEst7() {
    Paquetesestados idEstPaquete = new Paquetesestados(Consts.ESTADO_PAQUETE_BAJA);
    String qry = "SELECT DISTINCT m ";
    qry += "FROM Materiales m ";
    qry += "INNER JOIN m.paquetesCollection p ";
    qry += "WHERE p.idEstPaquete = :idEstPaquete ";
    List<Materiales> rval = em.createQuery(qry)
            .setParameter("idEstPaquete", idEstPaquete)
            .getResultList();
    return rval;
  }

  public List<Materiales> findAvailableToAddToPackage() {
    String isql = "";
    isql += "SELECT * ";
    isql += "FROM materiales m ";
    isql += "WHERE ";
    isql += "m.idEstMaterial = " + Consts.TIPO_MONITOREO_IQAS + " ";
    isql += "AND ";
    isql += "(IFNULL(( ";
    isql += "SELECT COUNT(*) ";
    isql += "FROM paquetes p ";
    isql += "INNER JOIN paquetesmateriales pm ";
    isql += "ON p.idPaquete = pm.idPaquete ";
    isql += "WHERE pm.idMaterial = m.idMaterial ";
    isql += "AND p.idEstPaquete != " + Consts.ESTADO_PAQUETE_BAJA + " ";
    isql += "), 0) = 0) ";
    isql += "AND m.habilitado = " + Consts.REGISTRO_HABILITADO + " ";

    Query qry = em.createNativeQuery(isql, Materiales.class);

    return qry.getResultList();
  }
/*
  public List<Materiales> findByIdKit(Kits idKit) {
    Query qry = em.createNamedQuery("Materiales.findByIdKit", Materiales.class);
    qry.setParameter("idKit", idKit.getIdKit());
    return qry.getResultList();
  }

  public List<Materiales> findBySubtpoEquipo(Equipossubtipos subtpoEquipo) {
    String isql = "";
    isql += "SELECT m ";
    isql += "FROM Materiales m ";
    isql += "WHERE m.idTipoMaterial IN ";
    isql += "( ";
    isql += "SELECT mt ";
    isql += "FROM Materialestipos mt ";
    isql += "WHERE mt.subtpoEquipo = :subtpoEquipo ";
    isql += ") ";

    Query qry = em.createQuery(isql);
    qry.setParameter("subtpoEquipo", subtpoEquipo);

    return qry.getResultList();
  }

  public List<Materiales> findBySubtpoEquipoAndIdEstMaterial(Equipossubtipos subtpoEquipo, List<String> lsEstados) {
    return findBySubtpoEquipoAndIdEstMaterial(subtpoEquipo, lsEstados, null);
  }

  public List<Materiales> findBySubtpoEquipoAndIdEstMaterial(Equipossubtipos subtpoEquipo, List<String> lsEstados, Integer habilitado) {

    String isql = "";
    isql += "SELECT m ";
    isql += "FROM Materiales m ";
    isql += "WHERE m.idTipoMaterial IN ";
    isql += "( ";
    isql += "SELECT mt ";
    isql += "FROM Materialestipos mt ";
    isql += "WHERE mt.subtpoEquipo = :subtpoEquipo ";
    isql += ") ";
    isql += "AND ";
    isql += "m.idEstMaterial.idEstMaterial IN " + Utils.list2jpqlList(lsEstados) + " ";
    if (habilitado != null) {
      isql += "AND ";
      isql += "m.habilitado = :habilitado ";
    }

    Query qry = em.createQuery(isql);
    qry.setParameter("subtpoEquipo", subtpoEquipo);
    if (habilitado != null) {
      qry.setParameter("habilitado", habilitado);
    }

    return qry.getResultList();
  }
*/
  public List<Materiales> findByIdEstMaterialAndHabilitado(List<String> lsEstados, Integer habilitado) {

    String isql = "";
    isql += "SELECT m ";
    isql += "FROM Materiales m ";
    isql += "WHERE ";
    isql += "m.idEstMaterial.idEstMaterial IN "; //+ Utils.list2jpqlList(lsEstados) + " ";
    isql += "AND m.habilitado = :habilitado ";

    Query qry = em.createQuery(isql);
    qry.setParameter("habilitado", habilitado);

    return qry.getResultList();
  }

  public List<Materiales> findByNotIdEstMaterialAndHabilitado(List<String> lsEstados, Integer habilitado) {
    String isql = "";
    isql += "SELECT m ";
    isql += "FROM Materiales m ";
    isql += "WHERE ";
    isql += "m.idEstMaterial.idEstMaterial NOT IN ";// + Utils.list2jpqlList(lsEstados) + " ";
    isql += "AND m.habilitado = :habilitado ";

    Query qry = em.createQuery(isql);
    qry.setParameter("habilitado", habilitado);

    return qry.getResultList();
  }
  
  public List<Materiales> filterBy(Almacenes codAlmacen, Materialestipos idTipoMaterial, List<Materialesestados> estados,  Integer habilitado) {
    String isql = "";
    isql += "SELECT m ";
    isql += "FROM Materiales m ";
    isql += "WHERE ";
    isql += "m.habilitado = :habilitado ";
    if(codAlmacen!=null){
        isql += "AND m.codAlmacen = :codAlmacen ";
    }
    if(idTipoMaterial!=null){
        isql += "AND m.idTipoMaterial = :idTipoMaterial ";
    }
    if(estados!=null){
        isql += "AND m.idEstMaterial in :estados ";
    }
    
    Query qry = em.createQuery(isql);
    
    if(habilitado!=null){
        qry.setParameter("habilitado", habilitado);
    }
    if(codAlmacen!=null){
        qry.setParameter("codAlmacen", codAlmacen);
    }
    if(idTipoMaterial!=null){
        qry.setParameter("idTipoMaterial", idTipoMaterial);
    }
    if(estados!=null){
        qry.setParameter("estados", estados);
    }
    
    return qry.getResultList();
  }

}
