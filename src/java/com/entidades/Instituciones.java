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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
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
@Table(name = "instituciones", catalog = "ubuntu", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Instituciones.findAll", query = "SELECT i FROM Instituciones i"),
    @NamedQuery(name = "Instituciones.findByIdInstitucion", query = "SELECT i FROM Instituciones i WHERE i.idInstitucion = :idInstitucion"),
    @NamedQuery(name = "Instituciones.findByDscInstitucion", query = "SELECT i FROM Instituciones i WHERE i.dscInstitucion = :dscInstitucion"),
    @NamedQuery(name = "Instituciones.findByDir", query = "SELECT i FROM Instituciones i WHERE i.dir = :dir"),
    @NamedQuery(name = "Instituciones.findByLocalidad", query = "SELECT i FROM Instituciones i WHERE i.localidad = :localidad"),
    @NamedQuery(name = "Instituciones.findByProvincia", query = "SELECT i FROM Instituciones i WHERE i.provincia = :provincia"),
    @NamedQuery(name = "Instituciones.findByPais", query = "SELECT i FROM Instituciones i WHERE i.pais = :pais"),
    @NamedQuery(name = "Instituciones.findByEmail", query = "SELECT i FROM Instituciones i WHERE i.email = :email"),
    @NamedQuery(name = "Instituciones.findByTel", query = "SELECT i FROM Instituciones i WHERE i.tel = :tel"),
    @NamedQuery(name = "Instituciones.findByWebsite", query = "SELECT i FROM Instituciones i WHERE i.website = :website"),
    @NamedQuery(name = "Instituciones.findByHabilitado", query = "SELECT i FROM Instituciones i WHERE i.habilitado = :habilitado")})
public class Instituciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idInstitucion")
    private Integer idInstitucion;
    @Size(max = 250)
    @Column(name = "dscInstitucion")
    private String dscInstitucion;
    @Size(max = 250)
    @Column(name = "dir")
    private String dir;
    @Size(max = 100)
    @Column(name = "localidad")
    private String localidad;
    @Size(max = 100)
    @Column(name = "provincia")
    private String provincia;
    @Size(max = 100)
    @Column(name = "pais")
    private String pais;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 100)
    @Column(name = "email")
    private String email;
    @Size(max = 100)
    @Column(name = "tel")
    private String tel;
    @Size(max = 100)
    @Column(name = "website")
    private String website;
    @Lob
    @Column(name = "logo")
    private byte[] logo;
    @Column(name = "habilitado")
    private Boolean habilitado;

    public Instituciones() {
    }

    public Instituciones(Integer idInstitucion) {
        this.idInstitucion = idInstitucion;
    }

    public Integer getIdInstitucion() {
        return idInstitucion;
    }

    public void setIdInstitucion(Integer idInstitucion) {
        this.idInstitucion = idInstitucion;
    }

    public String getDscInstitucion() {
        return dscInstitucion;
    }

    public void setDscInstitucion(String dscInstitucion) {
        this.dscInstitucion = dscInstitucion;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public byte[] getLogo() {
        return logo;
    }

    public void setLogo(byte[] logo) {
        this.logo = logo;
    }

    public Boolean getHabilitado() {
        return habilitado;
    }

    public void setHabilitado(Boolean habilitado) {
        this.habilitado = habilitado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idInstitucion != null ? idInstitucion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Instituciones)) {
            return false;
        }
        Instituciones other = (Instituciones) object;
        if ((this.idInstitucion == null && other.idInstitucion != null) || (this.idInstitucion != null && !this.idInstitucion.equals(other.idInstitucion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entidades.Instituciones[ idInstitucion=" + idInstitucion + " ]";
    }
    
}
