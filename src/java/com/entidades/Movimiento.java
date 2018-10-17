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
 * @author jsturla
 */
@Entity
@Table(name = "movimientos", catalog = "ubuntu", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Movimientos.findAll", query = "SELECT e FROM Movimiento e"),})
public class Movimiento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idmovimientos")
    private Integer idmovimientos;
    @Column(name = "tipoMovimiento")
    private Integer tipoMovimiento;
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @JoinTable(name = "movimientos_materiales", joinColumns = {
        @JoinColumn(name = "idmovimientos", referencedColumnName = "idmovimientos")}, inverseJoinColumns = {
        @JoinColumn(name = "idMaterial", referencedColumnName = "idMaterial")})
    @ManyToMany(fetch = FetchType.LAZY)
    private Collection<Materiales> materialesCollection;
    @JoinColumn(name = "idUsuario", referencedColumnName = "idUsuario")
    @ManyToOne(fetch = FetchType.LAZY)
    private Usuarios idUsuario;

    public Movimiento() {
    }

    public Movimiento(Integer idEsterilizacion) {
        this.idmovimientos = idEsterilizacion;
    }

    public Integer getIdmovimientos() {
        return idmovimientos;
    }

    public void setIdmovimientos(Integer idmovimientos) {
        this.idmovimientos = idmovimientos;
    }

    public Integer getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(Integer tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @XmlTransient
    public Collection<Materiales> getMaterialesCollection() {
        return materialesCollection;
    }

    public void setMaterialesCollection(Collection<Materiales> materialesCollection) {
        this.materialesCollection = materialesCollection;
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
        hash += (idmovimientos != null ? idmovimientos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Movimiento)) {
            return false;
        }
        Movimiento other = (Movimiento) object;
        if ((this.idmovimientos == null && other.idmovimientos != null) || (this.idmovimientos != null && !this.idmovimientos.equals(other.idmovimientos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entidades.Esterilizacion[ idEsterilizacion=" + idmovimientos + " ]";
    }

}
