/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author usuario
 */
@Embeddable
public class EsterilizacioninsumosPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "idEsterilizacion")
    private int idEsterilizacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idInsumo")
    private int idInsumo;

    public EsterilizacioninsumosPK() {
    }

    public EsterilizacioninsumosPK(int idEsterilizacion, int idInsumo) {
        this.idEsterilizacion = idEsterilizacion;
        this.idInsumo = idInsumo;
    }

    public int getIdEsterilizacion() {
        return idEsterilizacion;
    }

    public void setIdEsterilizacion(int idEsterilizacion) {
        this.idEsterilizacion = idEsterilizacion;
    }

    public int getIdInsumo() {
        return idInsumo;
    }

    public void setIdInsumo(int idInsumo) {
        this.idInsumo = idInsumo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idEsterilizacion;
        hash += (int) idInsumo;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EsterilizacioninsumosPK)) {
            return false;
        }
        EsterilizacioninsumosPK other = (EsterilizacioninsumosPK) object;
        if (this.idEsterilizacion != other.idEsterilizacion) {
            return false;
        }
        if (this.idInsumo != other.idInsumo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entidades.EsterilizacioninsumosPK[ idEsterilizacion=" + idEsterilizacion + ", idInsumo=" + idInsumo + " ]";
    }
    
}
