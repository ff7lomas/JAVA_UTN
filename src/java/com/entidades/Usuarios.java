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
import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author usuario
 */
@Entity
@Table(name = "usuarios", catalog = "ubuntu", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuarios.findAll", query = "SELECT u FROM Usuarios u"),
    @NamedQuery(name = "Usuarios.findByIdUsuario", query = "SELECT u FROM Usuarios u WHERE u.idUsuario = :idUsuario"),
    @NamedQuery(name = "Usuarios.findByUser", query = "SELECT u FROM Usuarios u WHERE u.user = :user"),
    @NamedQuery(name = "Usuarios.findByPassword", query = "SELECT u FROM Usuarios u WHERE u.password = :password"),
    @NamedQuery(name = "Usuarios.findByLastLogin", query = "SELECT u FROM Usuarios u WHERE u.lastLogin = :lastLogin"),
  //  @NamedQuery(name = "Usuarios.findByRowsPerPage", query = "SELECT u FROM Usuarios u WHERE u.rowsPerPage = :rowsPerPage"),
  //  @NamedQuery(name = "Usuarios.findByLocale", query = "SELECT u FROM Usuarios u WHERE u.locale = :locale"),
    @NamedQuery(name = "Usuarios.findByHabilitado", query = "SELECT u FROM Usuarios u WHERE u.habilitado = :habilitado")})
public class Usuarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idUsuario")
    private Integer idUsuario;
    @Size(max = 50)
    @Column(name = "user")
    private String user;
    @Size(max = 64)
    @Column(name = "password")
    private String password;
    @Column(name = "lastLogin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastLogin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "habilitado")
    private int habilitado;
   /* @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario", fetch = FetchType.LAZY)
    private Collection<UsuariosEventostipos> usuariosEventostiposCollection;
    @OneToMany(mappedBy = "idUsuario", fetch = FetchType.LAZY)
    private Collection<Lavadoincidencias> lavadoincidenciasCollection;
    @OneToMany(mappedBy = "idUsuario", fetch = FetchType.LAZY)
    private Collection<Materialesbitacora> materialesbitacoraCollection;
    @OneToMany(mappedBy = "idUsuario", fetch = FetchType.LAZY)
    private Collection<Paquetes> paquetesCollection;
    @OneToMany(mappedBy = "idUsuario", fetch = FetchType.LAZY)
//    private Collection<UsuariosHistoricotoggle> usuariosHistoricotoggleCollection;
//    @OneToMany(mappedBy = "idUsuario", fetch = FetchType.LAZY)
    private Collection<Esterilizacion> esterilizacionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario", fetch = FetchType.LAZY)
    private Collection<UsuariosMenuopciones> usuariosMenuopcionesCollection;
    @JoinColumn(name = "idPersona", referencedColumnName = "idPersona")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Personas idPersona;*/

    public Usuarios() {
    }

    public Usuarios(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Usuarios(Integer idUsuario,  int habilitado) {
        this.idUsuario = idUsuario;
//        this.rowsPerPage = rowsPerPage;
//        this.locale = locale;
        this.habilitado = habilitado;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

//    public int getRowsPerPage() {
//        return rowsPerPage;
//    }
//
//    public void setRowsPerPage(int rowsPerPage) {
//        this.rowsPerPage = rowsPerPage;
//    }

//    public String getLocale() {
//        return locale;
//    }
//
//    public void setLocale(String locale) {
//        this.locale = locale;
//    }

    public int getHabilitado() {
        return habilitado;
    }

    public void setHabilitado(int habilitado) {
        this.habilitado = habilitado;
    }

//    @XmlTransient
//    public Collection<Remitos> getRemitosCollection() {
//        return remitosCollection;
//    }
//
//    public void setRemitosCollection(Collection<Remitos> remitosCollection) {
//        this.remitosCollection = remitosCollection;
//    }
//
//    @XmlTransient
//    public Collection<Indicadoreslotecajas> getIndicadoreslotecajasCollection() {
//        return indicadoreslotecajasCollection;
//    }
//
//    public void setIndicadoreslotecajasCollection(Collection<Indicadoreslotecajas> indicadoreslotecajasCollection) {
//        this.indicadoreslotecajasCollection = indicadoreslotecajasCollection;
//    }

//    @XmlTransient
//    public Collection<UsuariosDashboardgraficos> getUsuariosDashboardgraficosCollection() {
//        return usuariosDashboardgraficosCollection;
//    }
//
//    public void setUsuariosDashboardgraficosCollection(Collection<UsuariosDashboardgraficos> usuariosDashboardgraficosCollection) {
//        this.usuariosDashboardgraficosCollection = usuariosDashboardgraficosCollection;
//    }

   /* @XmlTransient
    public Collection<UsuariosEventostipos> getUsuariosEventostiposCollection() {
        return usuariosEventostiposCollection;
    }

    public void setUsuariosEventostiposCollection(Collection<UsuariosEventostipos> usuariosEventostiposCollection) {
        this.usuariosEventostiposCollection = usuariosEventostiposCollection;
    }*/

//    @XmlTransient
//    public Collection<Esterilizacionincidencias> getEsterilizacionincidenciasCollection() {
//        return esterilizacionincidenciasCollection;
//    }
//
//    public void setEsterilizacionincidenciasCollection(Collection<Esterilizacionincidencias> esterilizacionincidenciasCollection) {
//        this.esterilizacionincidenciasCollection = esterilizacionincidenciasCollection;
//    }
/*
    @XmlTransient
    public Collection<Lavadoincidencias> getLavadoincidenciasCollection() {
        return lavadoincidenciasCollection;
    }

    public void setLavadoincidenciasCollection(Collection<Lavadoincidencias> lavadoincidenciasCollection) {
        this.lavadoincidenciasCollection = lavadoincidenciasCollection;
    }
*/
//    @XmlTransient
//    public Collection<Acondicionamientoincidencias> getAcondicionamientoincidenciasCollection() {
//        return acondicionamientoincidenciasCollection;
//    }
//
//    public void setAcondicionamientoincidenciasCollection(Collection<Acondicionamientoincidencias> acondicionamientoincidenciasCollection) {
//        this.acondicionamientoincidenciasCollection = acondicionamientoincidenciasCollection;
//    }

    /*@XmlTransient
    public Collection<Materialesbitacora> getMaterialesbitacoraCollection() {
        return materialesbitacoraCollection;
    }

    public void setMaterialesbitacoraCollection(Collection<Materialesbitacora> materialesbitacoraCollection) {
        this.materialesbitacoraCollection = materialesbitacoraCollection;
    }

    @XmlTransient
    public Collection<Paquetes> getPaquetesCollection() {
        return paquetesCollection;
    }

    public void setPaquetesCollection(Collection<Paquetes> paquetesCollection) {
        this.paquetesCollection = paquetesCollection;
    }*/

//    @XmlTransient
//    public Collection<UsuariosHistoricotoggle> getUsuariosHistoricotoggleCollection() {
//        return usuariosHistoricotoggleCollection;
//    }
//
//    public void setUsuariosHistoricotoggleCollection(Collection<UsuariosHistoricotoggle> usuariosHistoricotoggleCollection) {
//        this.usuariosHistoricotoggleCollection = usuariosHistoricotoggleCollection;
//    }

//    @XmlTransient
//    public Collection<Indicadores> getIndicadoresCollection() {
//        return indicadoresCollection;
//    }
//
//    public void setIndicadoresCollection(Collection<Indicadores> indicadoresCollection) {
//        this.indicadoresCollection = indicadoresCollection;
//    }

   /* @XmlTransient
    public Collection<Esterilizacion> getEsterilizacionCollection() {
        return esterilizacionCollection;
    }

    public void setEsterilizacionCollection(Collection<Esterilizacion> esterilizacionCollection) {
        this.esterilizacionCollection = esterilizacionCollection;
    }

    @XmlTransient
    public Collection<UsuariosMenuopciones> getUsuariosMenuopcionesCollection() {
        return usuariosMenuopcionesCollection;
    }

    public void setUsuariosMenuopcionesCollection(Collection<UsuariosMenuopciones> usuariosMenuopcionesCollection) {
        this.usuariosMenuopcionesCollection = usuariosMenuopcionesCollection;
    }

    public Personas getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Personas idPersona) {
        this.idPersona = idPersona;
    }
*/
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuario != null ? idUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuarios)) {
            return false;
        }
        Usuarios other = (Usuarios) object;
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entidades.Usuarios[ idUsuario=" + idUsuario + " ]";
    }
    
}
