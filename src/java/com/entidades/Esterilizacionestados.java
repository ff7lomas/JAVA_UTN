/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entidades;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author usuario
 */
@Entity
@Table(name = "esterilizacionestados", catalog = "ubuntu", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Esterilizacionestados.findAll", query = "SELECT e FROM Esterilizacionestados e"),
    @NamedQuery(name = "Esterilizacionestados.findByIdEstadoEst", query = "SELECT e FROM Esterilizacionestados e WHERE e.idEstadoEst = :idEstadoEst"),
    @NamedQuery(name = "Esterilizacionestados.findByDscEstadoEst", query = "SELECT e FROM Esterilizacionestados e WHERE e.dscEstadoEst = :dscEstadoEst")})
public class Esterilizacionestados implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idEstadoEst")
    private Integer idEstadoEst;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "dscEstadoEst")
    private String dscEstadoEst;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEstadoEst", fetch = FetchType.LAZY)
    private Collection<Esterilizacion> esterilizacionCollection;

    public Esterilizacionestados() {
    }

    public Esterilizacionestados(Integer idEstadoEst) {
        this.idEstadoEst = idEstadoEst;
    }

    public Esterilizacionestados(Integer idEstadoEst, String dscEstadoEst) {
        this.idEstadoEst = idEstadoEst;
        this.dscEstadoEst = dscEstadoEst;
    }

    public Integer getIdEstadoEst() {
        return idEstadoEst;
    }

    public void setIdEstadoEst(Integer idEstadoEst) {
        this.idEstadoEst = idEstadoEst;
    }

    public String getDscEstadoEst() {
        return dscEstadoEst;
    }

    public void setDscEstadoEst(String dscEstadoEst) {
        this.dscEstadoEst = dscEstadoEst;
    }

    @XmlTransient
    public Collection<Esterilizacion> getEsterilizacionCollection() {
        return esterilizacionCollection;
    }

    public void setEsterilizacionCollection(Collection<Esterilizacion> esterilizacionCollection) {
        this.esterilizacionCollection = esterilizacionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstadoEst != null ? idEstadoEst.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Esterilizacionestados)) {
            return false;
        }
        Esterilizacionestados other = (Esterilizacionestados) object;
        if ((this.idEstadoEst == null && other.idEstadoEst != null) || (this.idEstadoEst != null && !this.idEstadoEst.equals(other.idEstadoEst))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entidades.Esterilizacionestados[ idEstadoEst=" + idEstadoEst + " ]";
    }
    
}
