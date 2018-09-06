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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author usuario
 */
@Entity
@Table(name = "personascontacto", catalog = "ubuntu", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Personascontacto.findAll", query = "SELECT p FROM Personascontacto p"),
    @NamedQuery(name = "Personascontacto.findByIdContacto", query = "SELECT p FROM Personascontacto p WHERE p.idContacto = :idContacto"),
    @NamedQuery(name = "Personascontacto.findByTpoContacto", query = "SELECT p FROM Personascontacto p WHERE p.tpoContacto = :tpoContacto"),
    @NamedQuery(name = "Personascontacto.findByValor", query = "SELECT p FROM Personascontacto p WHERE p.valor = :valor"),
    @NamedQuery(name = "Personascontacto.findByDescripcion", query = "SELECT p FROM Personascontacto p WHERE p.descripcion = :descripcion")})
public class Personascontacto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idContacto")
    private Integer idContacto;
    @Column(name = "tpoContacto")
    private Integer tpoContacto;
    @Size(max = 50)
    @Column(name = "valor")
    private String valor;
    @Size(max = 50)
    @Column(name = "descripcion")
    private String descripcion;
    @JoinColumn(name = "idPersona", referencedColumnName = "idPersona")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Personas idPersona;

    public Personascontacto() {
    }

    public Personascontacto(Integer idContacto) {
        this.idContacto = idContacto;
    }

    public Integer getIdContacto() {
        return idContacto;
    }

    public void setIdContacto(Integer idContacto) {
        this.idContacto = idContacto;
    }

    public Integer getTpoContacto() {
        return tpoContacto;
    }

    public void setTpoContacto(Integer tpoContacto) {
        this.tpoContacto = tpoContacto;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Personas getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Personas idPersona) {
        this.idPersona = idPersona;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idContacto != null ? idContacto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Personascontacto)) {
            return false;
        }
        Personascontacto other = (Personascontacto) object;
        if ((this.idContacto == null && other.idContacto != null) || (this.idContacto != null && !this.idContacto.equals(other.idContacto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entidades.Personascontacto[ idContacto=" + idContacto + " ]";
    }
    
}
