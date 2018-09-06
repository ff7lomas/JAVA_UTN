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
@Table(name = "eventostipos", catalog = "ubuntu", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Eventostipos.findAll", query = "SELECT e FROM Eventostipos e"),
    @NamedQuery(name = "Eventostipos.findByIdTipoEvento", query = "SELECT e FROM Eventostipos e WHERE e.idTipoEvento = :idTipoEvento"),
    @NamedQuery(name = "Eventostipos.findByDscTipoEvento", query = "SELECT e FROM Eventostipos e WHERE e.dscTipoEvento = :dscTipoEvento"),
    @NamedQuery(name = "Eventostipos.findByCartel", query = "SELECT e FROM Eventostipos e WHERE e.cartel = :cartel")})
public class Eventostipos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTipoEvento")
    private Integer idTipoEvento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "dscTipoEvento")
    private String dscTipoEvento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cartel")
    private int cartel;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoEvento", fetch = FetchType.LAZY)
    private Collection<Eventos> eventosCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoEvento", fetch = FetchType.LAZY)
    private Collection<UsuariosEventostipos> usuariosEventostiposCollection;

    public Eventostipos() {
    }

    public Eventostipos(Integer idTipoEvento) {
        this.idTipoEvento = idTipoEvento;
    }

    public Eventostipos(Integer idTipoEvento, String dscTipoEvento, int cartel) {
        this.idTipoEvento = idTipoEvento;
        this.dscTipoEvento = dscTipoEvento;
        this.cartel = cartel;
    }

    public Integer getIdTipoEvento() {
        return idTipoEvento;
    }

    public void setIdTipoEvento(Integer idTipoEvento) {
        this.idTipoEvento = idTipoEvento;
    }

    public String getDscTipoEvento() {
        return dscTipoEvento;
    }

    public void setDscTipoEvento(String dscTipoEvento) {
        this.dscTipoEvento = dscTipoEvento;
    }

    public int getCartel() {
        return cartel;
    }

    public void setCartel(int cartel) {
        this.cartel = cartel;
    }

    @XmlTransient
    public Collection<Eventos> getEventosCollection() {
        return eventosCollection;
    }

    public void setEventosCollection(Collection<Eventos> eventosCollection) {
        this.eventosCollection = eventosCollection;
    }

    @XmlTransient
    public Collection<UsuariosEventostipos> getUsuariosEventostiposCollection() {
        return usuariosEventostiposCollection;
    }

    public void setUsuariosEventostiposCollection(Collection<UsuariosEventostipos> usuariosEventostiposCollection) {
        this.usuariosEventostiposCollection = usuariosEventostiposCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoEvento != null ? idTipoEvento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Eventostipos)) {
            return false;
        }
        Eventostipos other = (Eventostipos) object;
        if ((this.idTipoEvento == null && other.idTipoEvento != null) || (this.idTipoEvento != null && !this.idTipoEvento.equals(other.idTipoEvento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entidades.Eventostipos[ idTipoEvento=" + idTipoEvento + " ]";
    }
    
}
