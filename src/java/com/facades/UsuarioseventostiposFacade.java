package com.facades;

import com.entidades.Eventostipos;
import com.entidades.UsuariosEventostipos;
import com.entidades.Usuarios;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author Nahuel Rullo <nahuelrullo at gmail.com>
 */
@Stateless
public class UsuarioseventostiposFacade extends AbstractFacade<UsuariosEventostipos> {

//    private static final org.apache.logging.log4j.Logger logger
//            = org.apache.logging.log4j.LogManager.getLogger("UsuariosEventostiposFacade");

    @PersistenceContext(unitName = "ubuntu_PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioseventostiposFacade() {
        super(UsuariosEventostipos.class);
    }

    public List<UsuariosEventostipos> findAllUsuariosEventostipos(){
    
        String isql = "";
        isql += "SELECT DISTINCT c ";
        isql += "FROM UsuariosEventostipos c ";
        isql += "WHERE ";
        isql += "c.idusuariosEventostipos IS NOT NULL ";
        Query qry = em.createQuery(isql, UsuariosEventostipos.class);
        return qry.getResultList();
    }
    
        
    public List<UsuariosEventostipos> findAllByUsuario(Usuarios usr){
        String isql = "";
        isql += "SELECT DISTINCT c ";
        isql += "FROM UsuariosEventostipos c ";
        isql += "WHERE ";
        isql += "c.idusuariosEventostipos IS NOT NULL ";
        if (usr != null) {
          isql += "AND ";
          isql += "c.idUsuario = :usuario ";
        }
        Query qry = em.createQuery(isql, UsuariosEventostipos.class);
        if (usr != null) {
         qry.setParameter("usuario", usr);
        }
        return qry.getResultList();
    }
    
    public List<Eventostipos> findAllEventosTipos(Usuarios usr){
        
        String isql = "SELECT evt FROM Eventostipos evt JOIN evt.usuariosEventostiposCollection uevt WHERE uevt.idUsuario = :idUsuario ";
        TypedQuery<Eventostipos> qry = em.createQuery(isql, Eventostipos.class);
        if (usr != null) {
        qry.setParameter("idUsuario", usr);
        }
        return qry.getResultList();
    }  
    
    public List<UsuariosEventostipos> findAllUsuariosEventostipos(Usuarios usr){
    
        String isql = "";
        isql += "SELECT DISTINCT c ";
        isql += "FROM UsuariosEventostipos c ";
        isql += "WHERE ";
        isql += "c.idusuariosEventostipos IS NOT NULL ";
        isql += " AND c.idUsuario = :idUsuario";
        TypedQuery<UsuariosEventostipos> qry = em.createQuery(isql, UsuariosEventostipos.class);
        if (usr != null) {
            qry.setParameter("idUsuario", usr);
        }
        return qry.getResultList();
    }
    
    public List<Eventostipos> findEventoTipo(UsuariosEventostipos usuarioeventotipo){
        
        String isql  = "SELECT evt FROM Eventostipos evt JOIN evt.usuariosEventostiposCollection uevt ";
               isql += "WHERE uevt.idUsuario = :user AND uevt.idTipoEvento = :idevt";
        TypedQuery<Eventostipos> qry = em.createQuery(isql, Eventostipos.class);
        if (usuarioeventotipo != null) {
            Usuarios user = usuarioeventotipo.getIdUsuario();
            Eventostipos idevt = usuarioeventotipo.getIdTipoEvento();
            qry.setParameter("user", user);
            qry.setParameter("idevt", idevt);
        }
        return qry.getResultList();
        
    }
       
}
