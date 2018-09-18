/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author usuario
 */
@Entity
@Table(name = "materialesestados", catalog = "ubuntu", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Materialesestados.findAll", query = "SELECT m FROM Materialesestados m"),
    @NamedQuery(name = "Materialesestados.findByIdEstMaterial", query = "SELECT m FROM Materialesestados m WHERE m.idEstMaterial = :idEstMaterial"),
    @NamedQuery(name = "Materialesestados.findByDscEstadoMaterial", query = "SELECT m FROM Materialesestados m WHERE m.dscEstadoMaterial = :dscEstadoMaterial"),
    @NamedQuery(name = "Materialesestados.findByHabilitado", query = "SELECT m FROM Materialesestados m WHERE m.habilitado = :habilitado")})
public class Materialesestados implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idEstMaterial")
    private Integer idEstMaterial;
    @Size(max = 45)
    @Column(name = "dscEstadoMaterial")
    private String dscEstadoMaterial;
    @Column(name = "habilitado")
    private Integer habilitado;
//    @OneToMany(mappedBy = "idEstMaterial", fetch = FetchType.LAZY)
//    private Collection<Materialesbitacora> materialesbitacoraCollection;
    @OneToMany(mappedBy = "idEstMaterial", fetch = FetchType.LAZY)
    private Collection<Materiales> materialesCollection;

    public Materialesestados() {
    }

    public Materialesestados(Integer idEstMaterial) {
        this.idEstMaterial = idEstMaterial;
    }

    public Integer getIdEstMaterial() {
        return idEstMaterial;
    }

    public void setIdEstMaterial(Integer idEstMaterial) {
        this.idEstMaterial = idEstMaterial;
    }

    public String getDscEstadoMaterial() {
        return dscEstadoMaterial;
    }

    public void setDscEstadoMaterial(String dscEstadoMaterial) {
        this.dscEstadoMaterial = dscEstadoMaterial;
    }

    public Integer getHabilitado() {
        return habilitado;
    }

    public void setHabilitado(Integer habilitado) {
        this.habilitado = habilitado;
    }

 
    @XmlTransient
    public Collection<Materiales> getMaterialesCollection() {
        return materialesCollection;
    }

    public void setMaterialesCollection(Collection<Materiales> materialesCollection) {
        this.materialesCollection = materialesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstMaterial != null ? idEstMaterial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Materialesestados)) {
            return false;
        }
        Materialesestados other = (Materialesestados) object;
        if ((this.idEstMaterial == null && other.idEstMaterial != null) || (this.idEstMaterial != null && !this.idEstMaterial.equals(other.idEstMaterial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entidades.Materialesestados[ idEstMaterial=" + idEstMaterial + " ]";
    }
    
}
