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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author usuario
 */
@Entity
@Table(name = "esterilizacion", catalog = "ubuntu", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Esterilizacion.findAll", query = "SELECT e FROM Esterilizacion e")
    ,
    @NamedQuery(name = "Esterilizacion.findByIdEsterilizacion", query = "SELECT e FROM Esterilizacion e WHERE e.idEsterilizacion = :idEsterilizacion")
    ,
    @NamedQuery(name = "Esterilizacion.findByCiclo", query = "SELECT e FROM Esterilizacion e WHERE e.ciclo = :ciclo")
    ,
    @NamedQuery(name = "Esterilizacion.findByFecha", query = "SELECT e FROM Esterilizacion e WHERE e.fecha = :fecha"),})
public class Esterilizacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idEsterilizacion")
    private Integer idEsterilizacion;
    @Column(name = "ciclo")
    private Integer ciclo;
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @JoinTable(name = "esterilizacionpaquetes", joinColumns = {
        @JoinColumn(name = "idEsterilizacion", referencedColumnName = "idEsterilizacion")}, inverseJoinColumns = {
        @JoinColumn(name = "idPaquete", referencedColumnName = "idPaquete")})
    @ManyToMany(fetch = FetchType.LAZY)
    private Collection<Paquetes> paquetesCollection;
    @ManyToOne(fetch = FetchType.LAZY)
    private Usuarios idUsuario;

    public Esterilizacion() {
    }

    public Esterilizacion(Integer idEsterilizacion) {
        this.idEsterilizacion = idEsterilizacion;
    }

    public Integer getIdEsterilizacion() {
        return idEsterilizacion;
    }

    public void setIdEsterilizacion(Integer idEsterilizacion) {
        this.idEsterilizacion = idEsterilizacion;
    }

    public Integer getCiclo() {
        return ciclo;
    }

    public void setCiclo(Integer ciclo) {
        this.ciclo = ciclo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @XmlTransient
    public Collection<Paquetes> getPaquetesCollection() {
        return paquetesCollection;
    }

    public void setPaquetesCollection(Collection<Paquetes> paquetesCollection) {
        this.paquetesCollection = paquetesCollection;
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
        hash += (idEsterilizacion != null ? idEsterilizacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Esterilizacion)) {
            return false;
        }
        Esterilizacion other = (Esterilizacion) object;
        if ((this.idEsterilizacion == null && other.idEsterilizacion != null) || (this.idEsterilizacion != null && !this.idEsterilizacion.equals(other.idEsterilizacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entidades.Esterilizacion[ idEsterilizacion=" + idEsterilizacion + " ]";
    }

}
