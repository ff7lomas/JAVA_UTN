package com.facades;

import com.entidades.Movimiento;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author jsturla
 */
@Stateless
public class MovimientosFacade extends AbstractFacade<Movimiento> {

    @PersistenceContext(unitName = "ubuntu_PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MovimientosFacade() {
        super(Movimiento.class);
    }

    public Movimiento findByIdMaterial(Integer idMaterial) {
        Movimiento rval = null;

        String isql = "SELECT e ";
        isql += "FROM Movimiento e ";
        isql += "JOIN p.materialesCollection m ";
        isql += "WHERE (m.idMaterial = :idMaterial)";

        Query qry = em.createQuery(isql, Movimiento.class);
        qry.setParameter("idMaterial", idMaterial);

        List<Movimiento> tmp = qry.getResultList();

        if (!tmp.isEmpty()) {
            rval = tmp.get(0);
        }

        return rval;
    }

    public List<Movimiento> findByTipoMov(Integer tipoMovimiento) {
        Movimiento rval = null;

        String isql = "SELECT e ";
        isql += "FROM Movimiento e ";
        isql += "WHERE (e.tipoMovimiento = :tipoMovimiento)";

        Query qry = em.createQuery(isql);
        qry.setParameter("tipoMovimiento", tipoMovimiento);

        return qry.getResultList();
    }

    public Integer getNextId() {
        String isql = "";
        isql += "SELECT MAX(e.idmovimientos) ";
        isql += "FROM Movimiento e ";

        Query qry = em.createQuery(isql, Integer.class);

        try {
            return (Integer) qry.getSingleResult() + 1;
        } catch (NoResultException e) {
            return 0;
        }
    }

}
