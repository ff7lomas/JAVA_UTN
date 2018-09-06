/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entidades;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author usuario
 */
@Entity
@Table(name = "lavadoincidencias", catalog = "ubuntu", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lavadoincidencias.findAll", query = "SELECT l FROM Lavadoincidencias l"),
    @NamedQuery(name = "Lavadoincidencias.findByIdLavadoincidencia", query = "SELECT l FROM Lavadoincidencias l WHERE l.idLavadoincidencia = :idLavadoincidencia"),
    @NamedQuery(name = "Lavadoincidencias.findByDscLavadoincidencia", query = "SELECT l FROM Lavadoincidencias l WHERE l.dscLavadoincidencia = :dscLavadoincidencia"),
    @NamedQuery(name = "Lavadoincidencias.findByFechayhora", query = "SELECT l FROM Lavadoincidencias l WHERE l.fechayhora = :fechayhora")})
public class Lavadoincidencias implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idLavadoincidencia")
    private Integer idLavadoincidencia;
    @Size(max = 150)
    @Column(name = "dscLavadoincidencia")
    private String dscLavadoincidencia;
    @Column(name = "fechayhora")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechayhora;
    @ManyToMany(mappedBy = "lavadoincidenciasCollection", fetch = FetchType.LAZY)
    private Collection<Materiales> materialesCollection;
    @JoinColumn(name = "idUsuario", referencedColumnName = "idUsuario")
    @ManyToOne(fetch = FetchType.LAZY)
    private Usuarios idUsuario;

    public Lavadoincidencias() {
    }

    public Lavadoincidencias(Integer idLavadoincidencia) {
        this.idLavadoincidencia = idLavadoincidencia;
    }

    public Integer getIdLavadoincidencia() {
        return idLavadoincidencia;
    }

    public void setIdLavadoincidencia(Integer idLavadoincidencia) {
        this.idLavadoincidencia = idLavadoincidencia;
    }

    public String getDscLavadoincidencia() {
        return dscLavadoincidencia;
    }

    public void setDscLavadoincidencia(String dscLavadoincidencia) {
        this.dscLavadoincidencia = dscLavadoincidencia;
    }

    public Date getFechayhora() {
        return fechayhora;
    }

    public void setFechayhora(Date fechayhora) {
        this.fechayhora = fechayhora;
    }

    @XmlTransient
    public Collection<Materiales> getMaterialesCollection() {
        return materialesCollection;
    }

    public void setMaterialesCollection(Collection<Materiales> materialesCollection) {
        this.materialesCollection = materialesCollection;
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
        hash += (idLavadoincidencia != null ? idLavadoincidencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lavadoincidencias)) {
            return false;
        }
        Lavadoincidencias other = (Lavadoincidencias) object;
        if ((this.idLavadoincidencia == null && other.idLavadoincidencia != null) || (this.idLavadoincidencia != null && !this.idLavadoincidencia.equals(other.idLavadoincidencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entidades.Lavadoincidencias[ idLavadoincidencia=" + idLavadoincidencia + " ]";
    }
    
}
