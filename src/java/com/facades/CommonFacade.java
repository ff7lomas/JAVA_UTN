package com.facades;

import com.utils.Consts;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ejb.Stateless;

/**
 *
 * @author Nahuel Rullo <nahuelrullo at gmail.com>
 */
@Stateless
public class CommonFacade {

//  private static final org.apache.logging.log4j.Logger logger
//          = org.apache.logging.log4j.LogManager.
//          getLogger("CommonFacade");

  @PersistenceContext(unitName = "ubuntu_PU")
  private EntityManager em;


  public CommonFacade() {
  }

  public void resetDB() {
    //logger.debug("resetDB executed...");
    
    em.createNativeQuery("SET foreign_key_checks = 0;").executeUpdate();

    em.createNativeQuery("TRUNCATE TABLE equiposinsumos;").executeUpdate();

    em.createNativeQuery("TRUNCATE TABLE esterilizacion;").executeUpdate();
    em.createNativeQuery("TRUNCATE TABLE esterilizacioninsumos;").executeUpdate();
    em.createNativeQuery("TRUNCATE TABLE esterilizacionpaquetes;").executeUpdate();

    em.createNativeQuery("TRUNCATE TABLE indicadores;").executeUpdate();
    em.createNativeQuery("TRUNCATE TABLE indicadoreslotecajas;").executeUpdate();

    em.createNativeQuery("TRUNCATE TABLE insumos;").executeUpdate();

    em.createNativeQuery("TRUNCATE TABLE kits;").executeUpdate();

    em.createNativeQuery("TRUNCATE TABLE materialesbitacora;").executeUpdate();

    em.createNativeQuery("TRUNCATE TABLE paquetes;").executeUpdate();
    em.createNativeQuery("TRUNCATE TABLE paquetesmateriales;").executeUpdate();

    em.createNativeQuery("TRUNCATE TABLE remitos;").executeUpdate();
    em.createNativeQuery("TRUNCATE TABLE remitosmateriales;").executeUpdate();

    em.createNativeQuery("TRUNCATE TABLE acondicionamientoincidencias;").executeUpdate();
    em.createNativeQuery("TRUNCATE TABLE materiales_acondicionamientoincidencias;").executeUpdate();

    em.createNativeQuery("TRUNCATE TABLE lavadoincidencias;").executeUpdate();
    em.createNativeQuery("TRUNCATE TABLE materiales_lavadoincidencias;").executeUpdate();

    em.createNativeQuery("TRUNCATE TABLE esterilizacionincidencias;").executeUpdate();
    em.createNativeQuery("TRUNCATE TABLE materiales_esterilizacionincidencias;").executeUpdate();

    em.createNativeQuery("TRUNCATE TABLE eventos;").executeUpdate();
    
    
    // Desde acá .....  (Agregado el 20170105 )
    em.createNativeQuery("TRUNCATE TABLE cirugia;").executeUpdate();
    em.createNativeQuery("TRUNCATE TABLE cirugia_materiales;").executeUpdate();
    
    String isql = "";
    isql += "DELETE FROM usuarios_menuopciones WHERE idUsuario != '1' ";
    isql += "AND idUsuario != '5' ";
    isql += "AND idUsuario != '6' ";
    em.createNativeQuery(isql).executeUpdate();
    
    isql = "";
    isql += "DELETE FROM usuarios_historicotoggle WHERE idUsuario != '1' ";
    isql += "AND idUsuario != '5' ";
    isql += "AND idUsuario != '6' ";
    em.createNativeQuery(isql).executeUpdate();
    
    isql = "";
    isql += "DELETE FROM usuarios_dashboardgraficos WHERE idUsuario != '1' ";
    isql += "AND idUsuario != '5' ";
    isql += "AND idUsuario != '6' ";
    em.createNativeQuery(isql).executeUpdate();
    
    isql = "";
    isql += "DELETE FROM usuarios_eventostipos WHERE idUsuario != '1' ";
    isql += "AND idUsuario != '5' ";
    isql += "AND idUsuario != '6' ";
    em.createNativeQuery(isql).executeUpdate();
    
    isql = "";
    isql += "DELETE FROM usuarios WHERE idUsuario != '1' ";
    isql += "AND idUsuario != '5' ";
    isql += "AND idUsuario != '6' ";
    em.createNativeQuery(isql).executeUpdate();
    
    isql = "";
    isql += "DELETE FROM profesionales WHERE idPersona != '13' ";
    isql += "AND idPersona != '25' ";
    isql += "AND idPersona != '26' ";
    em.createNativeQuery(isql).executeUpdate();
    
    isql = "";
    isql += "DELETE FROM personas WHERE idPersona != '13' ";
    isql += "AND idPersona != '25' ";
    isql += "AND idPersona != '26' ";
    em.createNativeQuery(isql).executeUpdate();
    
    em.createNativeQuery("DELETE FROM almacenes WHERE idAlmacen != '0';").executeUpdate();
    
    // ... hasta acá.

    em.createNativeQuery("UPDATE materiales SET idKit=NULL;").executeUpdate();
    em.createNativeQuery("UPDATE materiales SET idPropietario=NULL;").executeUpdate();
    em.createNativeQuery("UPDATE materiales SET codAlmacen=NULL;").executeUpdate();
    em.createNativeQuery("UPDATE materiales SET idEstMaterial=" + Consts.ESTADO_MATERIAL_NO_DISPONIBLE + ";").executeUpdate();
    em.createNativeQuery("UPDATE materiales SET habilitado=" + Consts.REGISTRO_HABILITADO + ";").executeUpdate();

    isql = "";
    isql += "INSERT INTO materialesbitacora (fechayhora, idMaterial, idEstMaterial, idUsuario) ";
    isql += "SELECT NOW() AS fechayhora, m.idMaterial AS idMaterial, m.idEstMaterial AS idEstMaterial, ";
    isql += "(SELECT u.idUsuario FROM usuarios u WHERE u.user = 'admin') AS idUsuario ";
    isql += "FROM materiales m ";
    em.createNativeQuery(isql).executeUpdate();

    em.createNativeQuery("SET foreign_key_checks = 1;").executeUpdate();

    em.getEntityManagerFactory().getCache().evictAll();
  }

}
