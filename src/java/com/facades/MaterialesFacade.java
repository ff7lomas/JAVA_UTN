package com.facades;

import com.entidades.Materiales;
import com.entidades.Materialesestados;
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
public class MaterialesFacade extends AbstractFacade<Materiales> {

    @PersistenceContext(unitName = "ubuntu_PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MaterialesFacade() {
        super(Materiales.class);
    }

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

    public List<Materiales> findHabilitados() {
        String isql = "";
        isql += "SELECT m FROM Materiales m ";
        isql += "WHERE m.habilitado = 0 ";
        Query qry = em.createQuery(isql);
        //qry.setParameter("idPaquete", idPaquete);
        List<Materiales> rval = qry.getResultList();

        return rval;
    }

    public List<Materiales> findNotInKits() {
        String qry = "SELECT DISTINCT m ";
        qry += "FROM Materiales m ";
        qry += "WHERE m.idKit IS NULL ";
        List<Materiales> rval = em.createQuery(qry).getResultList();
        return rval;
    }

    public List<Materiales> findByIdEstMaterialAndHabilitado(int lsEstados, Integer habilitado) {

        String isql = "";
        isql += "SELECT m ";
        isql += "FROM Materiales m ";
        isql += "WHERE ";
        isql += "m.idEstMaterial.idEstMaterial = " + lsEstados; //+ Utils.list2jpqlList(lsEstados) + " ";
        isql += " AND m.habilitado = :habilitado ";

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
        isql += " AND m.habilitado = :habilitado ";

        Query qry = em.createQuery(isql);
        qry.setParameter("habilitado", habilitado);

        return qry.getResultList();
    }
}
