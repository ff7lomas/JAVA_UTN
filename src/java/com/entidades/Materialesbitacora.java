package com.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Nahuel Rullo <nahuelrullo at gmail.com>
 */
@Entity
@Table(name = "materialesbitacora", catalog = "ubuntu", schema = "")
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
@NamedQueries({
  @NamedQuery(name = "Materialesbitacora.findAll", query = "SELECT e FROM Materialesbitacora e"),
  @NamedQuery(name = "Materialesbitacora.findByIdMaterialesbitacora", query = "SELECT e FROM Materialesbitacora e WHERE e.idMaterialbitacora = :idMaterialbitacora"),
  @NamedQuery(name = "Materialesbitacora.findByFechayhora", query = "SELECT e FROM Materialesbitacora e WHERE e.fechayhora = :fechayhora")})
public class Materialesbitacora implements Serializable {
  
  private static final long serialVersionUID = 1L;
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "idMaterialbitacora")
  @XmlAttribute
  private Integer idMaterialbitacora;
  
  @Column(name = "fechayhora")
  @Temporal(TemporalType.TIMESTAMP)
  @XmlAttribute
  private Date fechayhora;
  
  @JoinColumn(name = "idUsuario", referencedColumnName = "idUsuario")
  @ManyToOne
  @XmlElement
  private Usuarios idUsuario;
  
  @JoinColumn(name = "idMaterial", referencedColumnName = "idMaterial")
  @ManyToOne
  @XmlElement
  private Materiales idMaterial;
  
  @JoinColumn(name = "idEstMaterial", referencedColumnName = "idEstMaterial")
  @ManyToOne
  @XmlElement
  private Materialesestados idEstMaterial;

	@NotNull
	@Column(name = "ingresa", columnDefinition = "INT(1) default '1'")
	private Integer ingresa = 1;
  
  public Materialesbitacora() {
  }

  public Materialesbitacora(Integer idMaterialbitacora) {
    this.idMaterialbitacora = idMaterialbitacora;
  }
  
  public void setFechayhora(Date fechayhora) {
    this.fechayhora = fechayhora;
  }

  public Date getFechayhora() {
    return fechayhora;
  }

  public Usuarios getIdUsuario() {
    return idUsuario;
  }

  public void setIdUsuario(Usuarios idUsuario) {
    this.idUsuario = idUsuario;
  }

  public Integer getIdMaterialbitacora() {
    return idMaterialbitacora;
  }

  public void setIdMaterialbitacora(Integer idMaterialbitacora) {
    this.idMaterialbitacora = idMaterialbitacora;
  }

  public void setIdMaterial(Materiales idMaterial) {
    this.idMaterial = idMaterial;
  }

  public Materiales getIdMaterial() {
    return idMaterial;
  }

  public void setIdEstMaterial(Materialesestados idEstMaterial) {
    this.idEstMaterial = idEstMaterial;
  }

  public Materialesestados getIdEstMaterial() {
    return idEstMaterial;
  }

  public void setIngresa(Integer ingresa) {
    this.ingresa = ingresa;
  }

  public Integer getIngresa() {
    return ingresa;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (idMaterialbitacora != null ? idMaterialbitacora.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Materialesbitacora)) {
      return false;
    }
    Materialesbitacora other = (Materialesbitacora) object;
    if ((this.idMaterialbitacora == null && other.idMaterialbitacora != null) || (this.idMaterialbitacora != null && !this.idMaterialbitacora.equals(other.idMaterialbitacora))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "com.vodemia.terragene.Sistema.Entidades.Materialesbitacora[ idMaterialbitacora=" + idMaterialbitacora + " ]";
  }
  
}
