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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author usuario
 */
@Entity
@Table(name = "menuopciones", catalog = "ubuntu", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Menuopciones.findAll", query = "SELECT m FROM Menuopciones m"),
    @NamedQuery(name = "Menuopciones.findByIdOpcion", query = "SELECT m FROM Menuopciones m WHERE m.idOpcion = :idOpcion"),
    @NamedQuery(name = "Menuopciones.findByTpoOpcion", query = "SELECT m FROM Menuopciones m WHERE m.tpoOpcion = :tpoOpcion"),
    @NamedQuery(name = "Menuopciones.findByName", query = "SELECT m FROM Menuopciones m WHERE m.name = :name"),
    @NamedQuery(name = "Menuopciones.findByUri", query = "SELECT m FROM Menuopciones m WHERE m.uri = :uri"),
    @NamedQuery(name = "Menuopciones.findByGroupName", query = "SELECT m FROM Menuopciones m WHERE m.groupName = :groupName"),
    @NamedQuery(name = "Menuopciones.findByIcon", query = "SELECT m FROM Menuopciones m WHERE m.icon = :icon")})
public class Menuopciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idOpcion")
    private Integer idOpcion;
    @Column(name = "tpoOpcion")
    private Integer tpoOpcion;
    @Size(max = 45)
    @Column(name = "name")
    private String name;
    @Size(max = 100)
    @Column(name = "uri")
    private String uri;
    @Size(max = 45)
    @Column(name = "groupName")
    private String groupName;
    @Size(max = 45)
    @Column(name = "icon")
    private String icon;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idOpcion", fetch = FetchType.LAZY)
    private Collection<UsuariosMenuopciones> usuariosMenuopcionesCollection;

    public Menuopciones() {
    }

    public Menuopciones(Integer idOpcion) {
        this.idOpcion = idOpcion;
    }

    public Integer getIdOpcion() {
        return idOpcion;
    }

    public void setIdOpcion(Integer idOpcion) {
        this.idOpcion = idOpcion;
    }

    public Integer getTpoOpcion() {
        return tpoOpcion;
    }

    public void setTpoOpcion(Integer tpoOpcion) {
        this.tpoOpcion = tpoOpcion;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @XmlTransient
    public Collection<UsuariosMenuopciones> getUsuariosMenuopcionesCollection() {
        return usuariosMenuopcionesCollection;
    }

    public void setUsuariosMenuopcionesCollection(Collection<UsuariosMenuopciones> usuariosMenuopcionesCollection) {
        this.usuariosMenuopcionesCollection = usuariosMenuopcionesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOpcion != null ? idOpcion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Menuopciones)) {
            return false;
        }
        Menuopciones other = (Menuopciones) object;
        if ((this.idOpcion == null && other.idOpcion != null) || (this.idOpcion != null && !this.idOpcion.equals(other.idOpcion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entidades.Menuopciones[ idOpcion=" + idOpcion + " ]";
    }
    
}
