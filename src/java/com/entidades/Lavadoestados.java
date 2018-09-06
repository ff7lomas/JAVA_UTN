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
 * @author jsturla
 */
@Entity
@Table(name = "estadoprocesolavado", catalog = "ubuntu", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lavadoestados.findAll", query = "SELECT e FROM Lavadoestados e"),
    @NamedQuery(name = "Lavadoestados.findByIdEstado", query = "SELECT e FROM Lavadoestados e WHERE e.idEstadoLavado = :idEstadoLavado"),
    @NamedQuery(name = "Lavadoestados.findByDscEstado", query = "SELECT e FROM Lavadoestados e WHERE e.idEstadoLavado = :idEstadoLavado")})
public class Lavadoestados implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idEstadoLavado")
    private Integer idEstadoLavado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "descEstadoprocesolavado")
    private String dscEstadoLavado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEstadoLavado", fetch = FetchType.LAZY)
    private Collection<Lavados> lavadosCollection;

    public Lavadoestados() {
    }

    public Lavadoestados(Integer idEstadoLavado) {
        this.idEstadoLavado = idEstadoLavado;
    }

    public Lavadoestados(Integer idEstadoLavado, String dscEstadoLavado) {
        this.idEstadoLavado = idEstadoLavado;
        this.dscEstadoLavado = dscEstadoLavado;
    }

    public Integer getIdEstadoLavado() {
        return idEstadoLavado;
    }

    public void setIdEstadoLavado(Integer idEstadoLavado) {
        this.idEstadoLavado = idEstadoLavado;
    }

    public String getDscEstadoLavado() {
        return dscEstadoLavado;
    }

    public void setDscEstadoLavado(String dscEstadoLavado) {
        this.dscEstadoLavado = dscEstadoLavado;
    }

    @XmlTransient
    public Collection<Lavados> getLavadosCollection() {
        return lavadosCollection;
    }

    public void setLavadosCollection(Collection<Lavados> lavadosCollection) {
        this.lavadosCollection = lavadosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstadoLavado != null ? idEstadoLavado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lavadoestados)) {
            return false;
        }
        Lavadoestados other = (Lavadoestados) object;
        if ((this.idEstadoLavado == null && other.idEstadoLavado != null) || (this.idEstadoLavado != null && !this.idEstadoLavado.equals(other.idEstadoLavado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entidades.Esterilizacionestados[ idEstadoEst=" + idEstadoLavado + " ]";
    }
    
}
