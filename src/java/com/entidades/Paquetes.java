package com.entidades;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jsturla
 */
@Entity
@Table(name = "paquetes", catalog = "ubuntu", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Paquetes.findAll", query = "SELECT p FROM Paquetes p"),
    @NamedQuery(name = "Paquetes.findByIdPaquete", query = "SELECT p FROM Paquetes p WHERE p.idPaquete = :idPaquete"),
    @NamedQuery(name = "Paquetes.findByFecha", query = "SELECT p FROM Paquetes p WHERE p.fecha = :fecha"),
    @NamedQuery(name = "Paquetes.findByHabilitado", query = "SELECT p FROM Paquetes p WHERE p.habilitado = :habilitado")})
public class Paquetes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPaquete")
    private Integer idPaquete;
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "habilitado")
    private int habilitado;
     @Basic(optional = false)
    @NotNull
    @Column(name = "esterilizado")
    private int esterilizado;   
     @JoinTable(name = "paquetesmateriales", joinColumns = {
        @JoinColumn(name = "idPaquete", referencedColumnName = "idPaquete")}, inverseJoinColumns = {
        @JoinColumn(name = "idMaterial", referencedColumnName = "idMaterial")})
    @ManyToMany(fetch = FetchType.LAZY)
    private Collection<Materiales> materialesCollection;   
    @ManyToMany(mappedBy = "paquetesCollection", fetch = FetchType.LAZY)
    private Collection<Esterilizacion> esterilizacionCollection;
    @JoinColumn(name = "idUsuario", referencedColumnName = "idUsuario")
    @ManyToOne(fetch = FetchType.LAZY)
    private Usuarios idUsuario;

    public Paquetes() {
    }

    public Paquetes(Integer idPaquete) {
        this.idPaquete = idPaquete;
    }

    public Paquetes(Integer idPaquete, int habilitado) {
        this.idPaquete = idPaquete;
        this.habilitado = habilitado;
    }

    public boolean isEsterilizado()
    {
        if(esterilizacionCollection.size()>0)
            return true;
        else
            return false;
    }
    
    public Integer getIdPaquete() {
        return idPaquete;
    }

    public void setIdPaquete(Integer idPaquete) {
        this.idPaquete = idPaquete;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getHabilitado() {
        return habilitado;
    }

    public void setHabilitado(int habilitado) {
        this.habilitado = habilitado;
    }

    @XmlTransient
    public Collection<Materiales> getMaterialesCollection() {
        return materialesCollection;
    }

    public void setMaterialesCollection(Collection<Materiales> materialesCollection) {
        this.materialesCollection = materialesCollection;
    }

    @XmlTransient
    public Collection<Esterilizacion> getEsterilizacionCollection() {
        return esterilizacionCollection;
    }

    public void setEsterilizacionCollection(Collection<Esterilizacion> esterilizacionCollection) {
        this.esterilizacionCollection = esterilizacionCollection;
    }

    public Usuarios getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuarios idUsuario) {
        this.idUsuario = idUsuario;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPaquete != null ? idPaquete.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Paquetes)) {
            return false;
        }
        Paquetes other = (Paquetes) object;
        if ((this.idPaquete == null && other.idPaquete != null) || (this.idPaquete != null && !this.idPaquete.equals(other.idPaquete))) {
            return false;
        }
        return true;
    }

    /**
     * @return the esterilizado
     */
    public int getEsterilizado() {
        return esterilizado;
    }

    /**
     * @param esterilizado the esterilizado to set
     */
    public void setEsterilizado(int esterilizado) {
        this.esterilizado = esterilizado;
    }
}
