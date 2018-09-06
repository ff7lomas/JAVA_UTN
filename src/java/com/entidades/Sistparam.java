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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author usuario
 */
@Entity
@Table(name = "sistparam", catalog = "ubuntu", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sistparam.findAll", query = "SELECT s FROM Sistparam s"),
    @NamedQuery(name = "Sistparam.findByIdParametro", query = "SELECT s FROM Sistparam s WHERE s.idParametro = :idParametro"),
    @NamedQuery(name = "Sistparam.findByClaveParametro", query = "SELECT s FROM Sistparam s WHERE s.claveParametro = :claveParametro"),
    @NamedQuery(name = "Sistparam.findByValorParametro", query = "SELECT s FROM Sistparam s WHERE s.valorParametro = :valorParametro"),
    @NamedQuery(name = "Sistparam.findByTipoDato", query = "SELECT s FROM Sistparam s WHERE s.tipoDato = :tipoDato"),
    @NamedQuery(name = "Sistparam.findByTipoParam", query = "SELECT s FROM Sistparam s WHERE s.tipoParam = :tipoParam")})
public class Sistparam implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idParametro")
    private Integer idParametro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "claveParametro")
    private String claveParametro;
    @Size(max = 250)
    @Column(name = "valorParametro")
    private String valorParametro;
    @Size(max = 45)
    @Column(name = "tipoDato")
    private String tipoDato;
    @Size(max = 45)
    @Column(name = "tipoParam")
    private String tipoParam;

    public Sistparam() {
    }

    public Sistparam(Integer idParametro) {
        this.idParametro = idParametro;
    }

    public Sistparam(Integer idParametro, String claveParametro) {
        this.idParametro = idParametro;
        this.claveParametro = claveParametro;
    }

    public Integer getIdParametro() {
        return idParametro;
    }

    public void setIdParametro(Integer idParametro) {
        this.idParametro = idParametro;
    }

    public String getClaveParametro() {
        return claveParametro;
    }

    public void setClaveParametro(String claveParametro) {
        this.claveParametro = claveParametro;
    }

    public String getValorParametro() {
        return valorParametro;
    }

    public void setValorParametro(String valorParametro) {
        this.valorParametro = valorParametro;
    }

    public String getTipoDato() {
        return tipoDato;
    }

    public void setTipoDato(String tipoDato) {
        this.tipoDato = tipoDato;
    }

    public String getTipoParam() {
        return tipoParam;
    }

    public void setTipoParam(String tipoParam) {
        this.tipoParam = tipoParam;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idParametro != null ? idParametro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sistparam)) {
            return false;
        }
        Sistparam other = (Sistparam) object;
        if ((this.idParametro == null && other.idParametro != null) || (this.idParametro != null && !this.idParametro.equals(other.idParametro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entidades.Sistparam[ idParametro=" + idParametro + " ]";
    }
    
}
