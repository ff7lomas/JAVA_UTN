package com.facades;

import com.entidades.Paquetes;
import com.utils.Consts;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author jsturla
 */
@Stateless
public class PaquetesFacade extends AbstractFacade<Paquetes> {

    @PersistenceContext(unitName = "ubuntu_PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PaquetesFacade() {
        super(Paquetes.class);
    }

    public List<Paquetes> findHabilitados() {
        List<Paquetes> rval = null;

        String isql = "SELECT p ";
        isql += "FROM Paquetes p ";
        isql += "WHERE p.habilitado = :habilitado ";

        Query qry = em.createQuery(isql, Paquetes.class);
        qry.setParameter("habilitado", Consts.REGISTRO_HABILITADO);

        rval = qry.getResultList();

        return rval;
    }

    public List<Paquetes> findHabilitadosNoEsteriles() {
        List<Paquetes> rval = null;

        String isql = "SELECT p ";
        isql += "FROM Paquetes p ";
        isql += "WHERE p.habilitado = :habilitado ";
        isql += " AND p.esterilizado=0";

        Query qry = em.createQuery(isql, Paquetes.class);
        qry.setParameter("habilitado", Consts.REGISTRO_HABILITADO);

        rval = qry.getResultList();

        return rval;
    }

    public List<Paquetes> findHabilitadosSiEsteriles() {
        List<Paquetes> rval = null;

        String isql = "SELECT p ";
        isql += "FROM Paquetes p ";
        isql += "WHERE p.habilitado = :habilitado ";
        isql += " AND p.esterilizado=1";

        Query qry = em.createQuery(isql, Paquetes.class);
        qry.setParameter("habilitado", Consts.REGISTRO_HABILITADO);

        rval = qry.getResultList();

        return rval;
    }

}
