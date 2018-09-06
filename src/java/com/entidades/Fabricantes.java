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
@Table(name = "fabricantes", catalog = "ubuntu", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fabricantes.findAll", query = "SELECT f FROM Fabricantes f"),
    @NamedQuery(name = "Fabricantes.findByIdFabricante", query = "SELECT f FROM Fabricantes f WHERE f.idFabricante = :idFabricante"),
    @NamedQuery(name = "Fabricantes.findByNomFabricante", query = "SELECT f FROM Fabricantes f WHERE f.nomFabricante = :nomFabricante"),
    @NamedQuery(name = "Fabricantes.findByUriFabricante", query = "SELECT f FROM Fabricantes f WHERE f.uriFabricante = :uriFabricante"),
    @NamedQuery(name = "Fabricantes.findByHabilitado", query = "SELECT f FROM Fabricantes f WHERE f.habilitado = :habilitado")})
public class Fabricantes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idFabricante")
    private Integer idFabricante;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nomFabricante")
    private String nomFabricante;
    @Size(max = 255)
    @Column(name = "uriFabricante")
    private String uriFabricante;
    @Basic(optional = false)
    @NotNull
    @Column(name = "habilitado")
    private int habilitado;
//    @OneToMany(mappedBy = "idFabricante", fetch = FetchType.LAZY)
//    private Collection<Equipos> equiposCollection;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFabricante", fetch = FetchType.LAZY)
//    private Collection<Indicadoresproducto> indicadoresproductoCollection;
//    @OneToMany(mappedBy = "idFabricante", fetch = FetchType.LAZY)
//    private Collection<Insumos> insumosCollection;

    public Fabricantes() {
    }

    public Fabricantes(Integer idFabricante) {
        this.idFabricante = idFabricante;
    }

    public Fabricantes(Integer idFabricante, String nomFabricante, int habilitado) {
        this.idFabricante = idFabricante;
        this.nomFabricante = nomFabricante;
        this.habilitado = habilitado;
    }

    public Integer getIdFabricante() {
        return idFabricante;
    }

    public void setIdFabricante(Integer idFabricante) {
        this.idFabricante = idFabricante;
    }

    public String getNomFabricante() {
        return nomFabricante;
    }

    public void setNomFabricante(String nomFabricante) {
        this.nomFabricante = nomFabricante;
    }

    public String getUriFabricante() {
        return uriFabricante;
    }

    public void setUriFabricante(String uriFabricante) {
        this.uriFabricante = uriFabricante;
    }

    public int getHabilitado() {
        return habilitado;
    }

    public void setHabilitado(int habilitado) {
        this.habilitado = habilitado;
    }
//
//    @XmlTransient
//    public Collection<Equipos> getEquiposCollection() {
//        return equiposCollection;
//    }
//
//    public void setEquiposCollection(Collection<Equipos> equiposCollection) {
//        this.equiposCollection = equiposCollection;
//    }
//
//    @XmlTransient
//    public Collection<Indicadoresproducto> getIndicadoresproductoCollection() {
//        return indicadoresproductoCollection;
//    }
//
//    public void setIndicadoresproductoCollection(Collection<Indicadoresproducto> indicadoresproductoCollection) {
//        this.indicadoresproductoCollection = indicadoresproductoCollection;
//    }
//
//    @XmlTransient
//    public Collection<Insumos> getInsumosCollection() {
//        return insumosCollection;
//    }
//
//    public void setInsumosCollection(Collection<Insumos> insumosCollection) {
//        this.insumosCollection = insumosCollection;
//    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFabricante != null ? idFabricante.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fabricantes)) {
            return false;
        }
        Fabricantes other = (Fabricantes) object;
        if ((this.idFabricante == null && other.idFabricante != null) || (this.idFabricante != null && !this.idFabricante.equals(other.idFabricante))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entidades.Fabricantes[ idFabricante=" + idFabricante + " ]";
    }
    
}
