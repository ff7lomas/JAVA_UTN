/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entidades;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "historicotoggle", catalog = "ubuntu", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Historicotoggle.findAll", query = "SELECT h FROM Historicotoggle h"),
    @NamedQuery(name = "Historicotoggle.findByIdToggle", query = "SELECT h FROM Historicotoggle h WHERE h.idToggle = :idToggle"),
    @NamedQuery(name = "Historicotoggle.findByDscToggle", query = "SELECT h FROM Historicotoggle h WHERE h.dscToggle = :dscToggle"),
    @NamedQuery(name = "Historicotoggle.findByDefaultVisible", query = "SELECT h FROM Historicotoggle h WHERE h.defaultVisible = :defaultVisible")})
public class Historicotoggle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idToggle")
    private Integer idToggle;
    @Size(max = 45)
    @Column(name = "dscToggle")
    private String dscToggle;
    @Column(name = "defaultVisible")
    private Boolean defaultVisible;
    @OneToMany(mappedBy = "idToggle", fetch = FetchType.LAZY)
    private Collection<UsuariosHistoricotoggle> usuariosHistoricotoggleCollection;

    public Historicotoggle() {
    }

    public Historicotoggle(Integer idToggle) {
        this.idToggle = idToggle;
    }

    public Integer getIdToggle() {
        return idToggle;
    }

    public void setIdToggle(Integer idToggle) {
        this.idToggle = idToggle;
    }

    public String getDscToggle() {
        return dscToggle;
    }

    public void setDscToggle(String dscToggle) {
        this.dscToggle = dscToggle;
    }

    public Boolean getDefaultVisible() {
        return defaultVisible;
    }

    public void setDefaultVisible(Boolean defaultVisible) {
        this.defaultVisible = defaultVisible;
    }

    @XmlTransient
    public Collection<UsuariosHistoricotoggle> getUsuariosHistoricotoggleCollection() {
        return usuariosHistoricotoggleCollection;
    }

    public void setUsuariosHistoricotoggleCollection(Collection<UsuariosHistoricotoggle> usuariosHistoricotoggleCollection) {
        this.usuariosHistoricotoggleCollection = usuariosHistoricotoggleCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idToggle != null ? idToggle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Historicotoggle)) {
            return false;
        }
        Historicotoggle other = (Historicotoggle) object;
        if ((this.idToggle == null && other.idToggle != null) || (this.idToggle != null && !this.idToggle.equals(other.idToggle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entidades.Historicotoggle[ idToggle=" + idToggle + " ]";
    }
    
}
