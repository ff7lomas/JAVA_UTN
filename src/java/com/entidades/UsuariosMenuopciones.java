/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author usuario
 */
@Entity
@Table(name = "usuarios_menuopciones", catalog = "ubuntu", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsuariosMenuopciones.findAll", query = "SELECT u FROM UsuariosMenuopciones u"),
    @NamedQuery(name = "UsuariosMenuopciones.findById", query = "SELECT u FROM UsuariosMenuopciones u WHERE u.id = :id"),
    @NamedQuery(name = "UsuariosMenuopciones.findByHabilitado", query = "SELECT u FROM UsuariosMenuopciones u WHERE u.habilitado = :habilitado"),
    @NamedQuery(name = "UsuariosMenuopciones.findByShortcut", query = "SELECT u FROM UsuariosMenuopciones u WHERE u.shortcut = :shortcut")})
public class UsuariosMenuopciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "habilitado")
    private boolean habilitado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "shortcut")
    private boolean shortcut;
    @JoinColumn(name = "idOpcion", referencedColumnName = "idOpcion")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Menuopciones idOpcion;
    @JoinColumn(name = "idUsuario", referencedColumnName = "idUsuario")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Usuarios idUsuario;

    public UsuariosMenuopciones() {
    }

    public UsuariosMenuopciones(Integer id) {
        this.id = id;
    }

    public UsuariosMenuopciones(Integer id, boolean habilitado, boolean shortcut) {
        this.id = id;
        this.habilitado = habilitado;
        this.shortcut = shortcut;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean getHabilitado() {
        return habilitado;
    }

    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
    }

    public boolean getShortcut() {
        return shortcut;
    }

    public void setShortcut(boolean shortcut) {
        this.shortcut = shortcut;
    }

    public Menuopciones getIdOpcion() {
        return idOpcion;
    }

    public void setIdOpcion(Menuopciones idOpcion) {
        this.idOpcion = idOpcion;
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
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuariosMenuopciones)) {
            return false;
        }
        UsuariosMenuopciones other = (UsuariosMenuopciones) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entidades.UsuariosMenuopciones[ id=" + id + " ]";
    }
    
}
