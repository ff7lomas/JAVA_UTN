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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author usuario
 */
@Entity
@Table(name = "usuarios_historicotoggle", catalog = "ubuntu", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsuariosHistoricotoggle.findAll", query = "SELECT u FROM UsuariosHistoricotoggle u"),
    @NamedQuery(name = "UsuariosHistoricotoggle.findById", query = "SELECT u FROM UsuariosHistoricotoggle u WHERE u.id = :id"),
    @NamedQuery(name = "UsuariosHistoricotoggle.findByVisible", query = "SELECT u FROM UsuariosHistoricotoggle u WHERE u.visible = :visible")})
public class UsuariosHistoricotoggle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "visible")
    private Boolean visible;
    @JoinColumn(name = "idToggle", referencedColumnName = "idToggle")
    @ManyToOne(fetch = FetchType.LAZY)
    private Historicotoggle idToggle;
    @JoinColumn(name = "idUsuario", referencedColumnName = "idUsuario")
    @ManyToOne(fetch = FetchType.LAZY)
    private Usuarios idUsuario;

    public UsuariosHistoricotoggle() {
    }

    public UsuariosHistoricotoggle(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    public Historicotoggle getIdToggle() {
        return idToggle;
    }

    public void setIdToggle(Historicotoggle idToggle) {
        this.idToggle = idToggle;
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
        if (!(object instanceof UsuariosHistoricotoggle)) {
            return false;
        }
        UsuariosHistoricotoggle other = (UsuariosHistoricotoggle) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entidades.UsuariosHistoricotoggle[ id=" + id + " ]";
    }
    
}
