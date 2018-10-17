package com.entidades;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jsturla
 */
@Entity
@Table(name = "materiales", catalog = "ubuntu", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Materiales.findAll", query = "SELECT m FROM Materiales m")
    ,
    @NamedQuery(name = "Materiales.findByIdMaterial", query = "SELECT m FROM Materiales m WHERE m.idMaterial = :idMaterial")
    ,
    @NamedQuery(name = "Materiales.findByNroLote", query = "SELECT m FROM Materiales m WHERE m.nroLote = :nroLote")
    ,
    @NamedQuery(name = "Materiales.findByNroSerie", query = "SELECT m FROM Materiales m WHERE m.nroSerie = :nroSerie")
    ,
    @NamedQuery(name = "Materiales.findByHabilitado", query = "SELECT m FROM Materiales m WHERE m.habilitado = :habilitado")})
public class Materiales implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idMaterial")
    private Integer idMaterial;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nroLote")
    private String nroLote;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nroSerie")
    private String nroSerie;
    @Basic(optional = false)
    @NotNull
    @Column(name = "habilitado")
    private int habilitado;
    @JoinTable(name = "paquetesmateriales", joinColumns = {
        @JoinColumn(name = "idMaterial", referencedColumnName = "idMaterial")}, inverseJoinColumns = {
        @JoinColumn(name = "idPaquete", referencedColumnName = "idPaquete")})
    @ManyToMany(fetch = FetchType.LAZY)
    private Collection<Paquetes> paquetesCollection;
    @JoinColumn(name = "idEstMaterial", referencedColumnName = "idEstMaterial")
    @ManyToOne(fetch = FetchType.LAZY)
    private Materialesestados idEstMaterial;
    @Size(max = 100)
    @Column(name = "dscTipoMaterial")
    private String dscTipoMaterial;
    @Size(max = 100)
    @Column(name = "marca")
    private String marca;
    @Size(max = 100)
    @Column(name = "familia")
    private String familia;

    public Materiales() {
    }

    public Materiales(Integer idMaterial) {
        this.idMaterial = idMaterial;
    }

    public Materiales(Integer idMaterial, String nroLote, String nroSerie, int habilitado) {
        this.idMaterial = idMaterial;
        this.nroLote = nroLote;
        this.nroSerie = nroSerie;
        this.habilitado = habilitado;
    }

    public Integer getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(Integer idMaterial) {
        this.idMaterial = idMaterial;
    }

    public String getNroLote() {
        return nroLote;
    }

    public void setNroLote(String nroLote) {
        this.nroLote = nroLote;
    }

    public String getNroSerie() {
        return nroSerie;
    }

    public void setNroSerie(String nroSerie) {
        this.nroSerie = nroSerie;
    }

    public int getHabilitado() {
        return habilitado;
    }

    public void setHabilitado(int habilitado) {
        this.habilitado = habilitado;
    }

    public Paquetes getLastPaquete() {
        //SE PUEDE PONER ACA O CUANDO SE LLAMA
        //QUE CUANDO AGARRA EL ÚLTIMO PAQUETE, CHECKEE EL ESTADO PARA VER SI ESTÁ ACTIVO O NO
        if (paquetesCollection.size() != 0) {
            return (Paquetes) paquetesCollection.toArray()[paquetesCollection.toArray().length - 1];
        } else {
            return null;
        }
    }

    @XmlTransient
    public Collection<Paquetes> getPaquetesCollection() {
        return paquetesCollection;
    }

    public void setPaquetesCollection(Collection<Paquetes> paquetesCollection) {
        this.paquetesCollection = paquetesCollection;
    }

    public Materialesestados getIdEstMaterial() {
        return idEstMaterial;
    }

    public void setIdEstMaterial(Materialesestados idEstMaterial) {
        this.idEstMaterial = idEstMaterial;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMaterial != null ? idMaterial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Materiales)) {
            return false;
        }
        Materiales other = (Materiales) object;
        if ((this.idMaterial == null && other.idMaterial != null) || (this.idMaterial != null && !this.idMaterial.equals(other.idMaterial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entidades.Materiales[ idMaterial=" + idMaterial + " ]";
    }

    /**
     * @return the dscTipoMaterial
     */
    public String getDscTipoMaterial() {
        return dscTipoMaterial;
    }

    /**
     * @param dscTipoMaterial the dscTipoMaterial to set
     */
    public void setDscTipoMaterial(String dscTipoMaterial) {
        this.dscTipoMaterial = dscTipoMaterial;
    }

    /**
     * @return the marca
     */
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * @return the familia
     */
    public String getFamilia() {
        return familia;
    }

    public void setFamilia(String familia) {
        this.familia = familia;
    }

}
