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
@Table(name = "usuarios_eventostipos", catalog = "ubuntu", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsuariosEventostipos.findAll", query = "SELECT u FROM UsuariosEventostipos u"),
    @NamedQuery(name = "UsuariosEventostipos.findByIdusuariosEventostipos", query = "SELECT u FROM UsuariosEventostipos u WHERE u.idusuariosEventostipos = :idusuariosEventostipos"),
    @NamedQuery(name = "UsuariosEventostipos.findByPopup", query = "SELECT u FROM UsuariosEventostipos u WHERE u.popup = :popup"),
    @NamedQuery(name = "UsuariosEventostipos.findByTabla", query = "SELECT u FROM UsuariosEventostipos u WHERE u.tabla = :tabla")})
public class UsuariosEventostipos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idusuarios_eventostipos")
    private Integer idusuariosEventostipos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "popup")
    private boolean popup;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tabla")
    private boolean tabla;
    @JoinColumn(name = "idUsuario", referencedColumnName = "idUsuario")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Usuarios idUsuario;
    @JoinColumn(name = "idTipoEvento", referencedColumnName = "idTipoEvento")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Eventostipos idTipoEvento;

    public UsuariosEventostipos() {
    }

    public UsuariosEventostipos(Integer idusuariosEventostipos) {
        this.idusuariosEventostipos = idusuariosEventostipos;
    }

    public UsuariosEventostipos(Integer idusuariosEventostipos, boolean popup, boolean tabla) {
        this.idusuariosEventostipos = idusuariosEventostipos;
        this.popup = popup;
        this.tabla = tabla;
    }

    public Integer getIdusuariosEventostipos() {
        return idusuariosEventostipos;
    }

    public void setIdusuariosEventostipos(Integer idusuariosEventostipos) {
        this.idusuariosEventostipos = idusuariosEventostipos;
    }

    public boolean getPopup() {
        return popup;
    }

    public void setPopup(boolean popup) {
        this.popup = popup;
    }

    public boolean getTabla() {
        return tabla;
    }

    public void setTabla(boolean tabla) {
        this.tabla = tabla;
    }

    public Usuarios getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuarios idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Eventostipos getIdTipoEvento() {
        return idTipoEvento;
    }

    public void setIdTipoEvento(Eventostipos idTipoEvento) {
        this.idTipoEvento = idTipoEvento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idusuariosEventostipos != null ? idusuariosEventostipos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuariosEventostipos)) {
            return false;
        }
        UsuariosEventostipos other = (UsuariosEventostipos) object;
        if ((this.idusuariosEventostipos == null && other.idusuariosEventostipos != null) || (this.idusuariosEventostipos != null && !this.idusuariosEventostipos.equals(other.idusuariosEventostipos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entidades.UsuariosEventostipos[ idusuariosEventostipos=" + idusuariosEventostipos + " ]";
    }
    
}
