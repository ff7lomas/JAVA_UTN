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
@Table(name = "paquetesestados", catalog = "ubuntu", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Paquetesestados.findAll", query = "SELECT p FROM Paquetesestados p"),
    @NamedQuery(name = "Paquetesestados.findByIdEstPaquete", query = "SELECT p FROM Paquetesestados p WHERE p.idEstPaquete = :idEstPaquete"),
    @NamedQuery(name = "Paquetesestados.findByDscEstadoPaquete", query = "SELECT p FROM Paquetesestados p WHERE p.dscEstadoPaquete = :dscEstadoPaquete")})
public class Paquetesestados implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idEstPaquete")
    private Integer idEstPaquete;
    @Size(max = 45)
    @Column(name = "dscEstadoPaquete")
    private String dscEstadoPaquete;
    @OneToMany(mappedBy = "idEstPaquete", fetch = FetchType.LAZY)
    private Collection<Paquetes> paquetesCollection;

    public Paquetesestados() {
    }

    public Paquetesestados(Integer idEstPaquete) {
        this.idEstPaquete = idEstPaquete;
    }

    public Integer getIdEstPaquete() {
        return idEstPaquete;
    }

    public void setIdEstPaquete(Integer idEstPaquete) {
        this.idEstPaquete = idEstPaquete;
    }

    public String getDscEstadoPaquete() {
        return dscEstadoPaquete;
    }

    public void setDscEstadoPaquete(String dscEstadoPaquete) {
        this.dscEstadoPaquete = dscEstadoPaquete;
    }

    @XmlTransient
    public Collection<Paquetes> getPaquetesCollection() {
        return paquetesCollection;
    }

    public void setPaquetesCollection(Collection<Paquetes> paquetesCollection) {
        this.paquetesCollection = paquetesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstPaquete != null ? idEstPaquete.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Paquetesestados)) {
            return false;
        }
        Paquetesestados other = (Paquetesestados) object;
        if ((this.idEstPaquete == null && other.idEstPaquete != null) || (this.idEstPaquete != null && !this.idEstPaquete.equals(other.idEstPaquete))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entidades.Paquetesestados[ idEstPaquete=" + idEstPaquete + " ]";
    }
    
}
