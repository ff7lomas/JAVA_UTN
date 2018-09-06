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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
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
@Table(name = "materialestipos", catalog = "ubuntu", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Materialestipos.findAll", query = "SELECT m FROM Materialestipos m"),
    @NamedQuery(name = "Materialestipos.findByIdTipoMaterial", query = "SELECT m FROM Materialestipos m WHERE m.idTipoMaterial = :idTipoMaterial"),
    @NamedQuery(name = "Materialestipos.findByDscTipoMaterial", query = "SELECT m FROM Materialestipos m WHERE m.dscTipoMaterial = :dscTipoMaterial"),
    @NamedQuery(name = "Materialestipos.findByPathFichaTecnica", query = "SELECT m FROM Materialestipos m WHERE m.pathFichaTecnica = :pathFichaTecnica"),
    @NamedQuery(name = "Materialestipos.findByInstrucciones", query = "SELECT m FROM Materialestipos m WHERE m.instrucciones = :instrucciones"),
    @NamedQuery(name = "Materialestipos.findByMarca", query = "SELECT m FROM Materialestipos m WHERE m.marca = :marca"),
    @NamedQuery(name = "Materialestipos.findByFamilia", query = "SELECT m FROM Materialestipos m WHERE m.familia = :familia"),
    @NamedQuery(name = "Materialestipos.findByGtin", query = "SELECT m FROM Materialestipos m WHERE m.gtin = :gtin")})
public class Materialestipos implements Serializable {

    @Lob
    @Column(name = "img")
    private byte[] img;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTipoMaterial")
    private Integer idTipoMaterial;
    @Size(max = 100)
    @Column(name = "dscTipoMaterial")
    private String dscTipoMaterial;
    @Size(max = 250)
    @Column(name = "pathFichaTecnica")
    private String pathFichaTecnica;
    @Size(max = 150)
    @Column(name = "instrucciones")
    private String instrucciones;
    @Size(max = 100)
    @Column(name = "marca")
    private String marca;
    @Size(max = 100)
    @Column(name = "familia")
    private String familia;
    @Size(max = 50)
    @Column(name = "gtin")
    private String gtin;
    @OneToMany(mappedBy = "idTipoMaterial", fetch = FetchType.LAZY)
    private Collection<Materiales> materialesCollection;
//    @JoinColumn(name = "subtpoEquipo", referencedColumnName = "subtpoEquipo")
//    @ManyToOne(fetch = FetchType.LAZY)
//    private Equipossubtipos subtpoEquipo;

    public Materialestipos() {
    }

    public Materialestipos(Integer idTipoMaterial) {
        this.idTipoMaterial = idTipoMaterial;
    }

    public Integer getIdTipoMaterial() {
        return idTipoMaterial;
    }

    public void setIdTipoMaterial(Integer idTipoMaterial) {
        this.idTipoMaterial = idTipoMaterial;
    }

    public String getDscTipoMaterial() {
        return dscTipoMaterial;
    }

    public void setDscTipoMaterial(String dscTipoMaterial) {
        this.dscTipoMaterial = dscTipoMaterial;
    }

    public String getPathFichaTecnica() {
        return pathFichaTecnica;
    }

    public void setPathFichaTecnica(String pathFichaTecnica) {
        this.pathFichaTecnica = pathFichaTecnica;
    }


    public String getInstrucciones() {
        return instrucciones;
    }

    public void setInstrucciones(String instrucciones) {
        this.instrucciones = instrucciones;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getFamilia() {
        return familia;
    }

    public void setFamilia(String familia) {
        this.familia = familia;
    }

    public String getGtin() {
        return gtin;
    }

    public void setGtin(String gtin) {
        this.gtin = gtin;
    }

    @XmlTransient
    public Collection<Materiales> getMaterialesCollection() {
        return materialesCollection;
    }

    public void setMaterialesCollection(Collection<Materiales> materialesCollection) {
        this.materialesCollection = materialesCollection;
    }

//    public Equipossubtipos getSubtpoEquipo() {
//        return subtpoEquipo;
//    }
//
//    public void setSubtpoEquipo(Equipossubtipos subtpoEquipo) {
//        this.subtpoEquipo = subtpoEquipo;
//    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoMaterial != null ? idTipoMaterial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Materialestipos)) {
            return false;
        }
        Materialestipos other = (Materialestipos) object;
        if ((this.idTipoMaterial == null && other.idTipoMaterial != null) || (this.idTipoMaterial != null && !this.idTipoMaterial.equals(other.idTipoMaterial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entidades.Materialestipos[ idTipoMaterial=" + idTipoMaterial + " ]";
    }

    public byte[] getImg() {
        return img;
    }

    public void setImg(byte[] img) {
        this.img = img;
    }
    
}
