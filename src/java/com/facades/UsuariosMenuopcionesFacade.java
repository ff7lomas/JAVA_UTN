package com.facades;

//import com.entidades.Equipos;
import com.entidades.Menuopciones;
import com.entidades.Usuarios;
import com.entidades.UsuariosMenuopciones;
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
public class UsuariosMenuopcionesFacade extends AbstractFacade<UsuariosMenuopciones> {

  @PersistenceContext(unitName = "ubuntu_PU")
  private EntityManager em;

  @Override
  protected EntityManager getEntityManager() {
    return em;
  }

  public UsuariosMenuopcionesFacade() {
    super(UsuariosMenuopciones.class);
  }

  public List<UsuariosMenuopciones> findByShortcut(Boolean shortcut, int idUsuario) {

    List<UsuariosMenuopciones> rval = null;

    String isql = "SELECT umo FROM UsuariosMenuopciones umo ";
    isql += "WHERE umo.shortcut = :shortcut ";
    isql += "AND umo.idUsuario = :idUsuario ";

    Query qry = em.createQuery(isql, UsuariosMenuopciones.class);
    qry.setParameter("shortcut", shortcut);
    qry.setParameter("idUsuario", idUsuario);

    rval = qry.getResultList();

    return rval;

  }

  /*  
   public List<UsuariosMenuopciones> findByIdUsuario(Usuarios idUsuario) {
    
   List<UsuariosMenuopciones> rval = null;
    
   Query qry = em.createNamedQuery("UsuariosMenuopciones.findByIdUsuario", UsuariosMenuopciones.class);
   qry.setParameter("idUsuario", idUsuario);
    
   rval = qry.getResultList();
    
   return rval;
    
   }
   */
  public List<UsuariosMenuopciones> findByIdUsuario(Usuarios idUsuario) {

    List<UsuariosMenuopciones> rval = null;

    String isql = "";
    isql += "SELECT um ";
    isql += "FROM UsuariosMenuopciones um ";
    isql += "WHERE um.idUsuario = :idUsuario ";
    isql += "ORDER BY um.idOpcion ASC ";

    Query qry = em.createQuery(isql, UsuariosMenuopciones.class);
    qry.setParameter("idUsuario", idUsuario);

    rval = qry.getResultList();

    return rval;

  }

  public List<UsuariosMenuopciones> findByIdUsuarioAndTpoOpcion(Usuarios idUsuario, Integer tpoOpcion) {
    String isql = "";
    isql += "SELECT um ";
    isql += "FROM UsuariosMenuopciones um ";
    isql += "INNER JOIN Menuopciones mo ON um.idOpcion = mo.idOpcion ";
    isql += "WHERE um.idUsuario = :idUsuario ";
    isql += "AND mo.tpoOpcion = :tpoOpcion ";
    isql += "ORDER BY um.idOpcion ASC ";

    Query qry = em.createQuery(isql, UsuariosMenuopciones.class);
    qry.setParameter("idUsuario", idUsuario);
    qry.setParameter("tpoOpcion", tpoOpcion);

    return qry.getResultList();
  }

  public UsuariosMenuopciones findByIdUsuarioAndIdOpcion(Usuarios idUsuario, Menuopciones idOpcion) {
    String isql = "SELECT umo FROM UsuariosMenuopciones umo ";
    isql += "WHERE umo.idUsuario = :idUsuario ";
    isql += "AND umo.idOpcion = :idOpcion ";

    Query qry = em.createQuery(isql, UsuariosMenuopciones.class);
    qry.setParameter("idUsuario", idUsuario);
    qry.setParameter("idOpcion", idOpcion);

    List<UsuariosMenuopciones> tmp = qry.getResultList();

    UsuariosMenuopciones rval = null;

    if (!tmp.isEmpty()) {
      rval = tmp.get(0);
    }
    return rval;
  }

  public Boolean isOpHabilitadaByIdUsuarioAndIdOpcion(Usuarios idUsuario, Integer idOpcion) {
    String isql = "";
    isql += "SELECT um ";
    isql += "FROM UsuariosMenuopciones um ";
    isql += "WHERE ";
    isql += "um.idUsuario = :idUsuario ";
    isql += "AND ";
    isql += "um.idOpcion.idOpcion = :idOpcion ";
    isql += "AND ";
    isql += "um.habilitado = :habilitado ";

    Query qry = em.createQuery(isql, UsuariosMenuopciones.class);
    qry.setParameter("idUsuario", idUsuario);
    qry.setParameter("idOpcion", idOpcion);
    qry.setParameter("habilitado", true);
    
    List<UsuariosMenuopciones> tmp = qry.getResultList();
    if (tmp == null || tmp.isEmpty()) {
      return false;
    }
    return true;
  }
  
  public Boolean isOpHabilitadaByIdUsuarioAndDireccion(String username, String pageDir) {
      boolean resultado=false;
            String sql = " SELECT * ";
        sql += " FROM menuopciones mo ";
        sql += "INNER JOIN usuarios_menuopciones umo ON mo.idOpcion= umo.idOpcion ";
        sql += "INNER JOIN usuarios usu ON usu.idUsuario= umo.idUsuario ";
        sql += "WHERE usu.user='" + username + "' ";
        sql += "AND mo.uri LIKE '%" + pageDir + "%' "; //tengo que ver mejor la parte de uri
        sql+= "AND umo.habilitado=1";
          
        List results=em.createNativeQuery(sql).getResultList();
        
        if( results.size()>0)
        {
            //nada, revisar esto
            //Si lo hago asi, si no esta expresamente denegado, accede a la pagina
            //significa que se podría hacer a las subpaginas que no aparecen en DB
            
            //Sino muchas subpaginas serán denegadas, a menos que se haga algo al respecto
            //como por ejemplo agregar todas las supaginas a la lista de menuopciones, pero eso sería al re pedo
            //porque si tenes permisos a una, deberías tener permiso a las subpaginas, aunque tengan otro nombre
            resultado=true;
        }
    return resultado;
  }

}
