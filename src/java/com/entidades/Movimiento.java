/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entidades;

import com.utils.Consts;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import javax.ejb.EJB;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author usuario
 */
@Entity
@Table(name = "movimientos", catalog = "ubuntu", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Movimientos.findAll", query = "SELECT e FROM Movimiento e"),
//    @NamedQuery(name = "Esterilizacion.findByIdEsterilizacion", query = "SELECT e FROM Esterilizacion e WHERE e.idEsterilizacion = :idEsterilizacion"),
//    @NamedQuery(name = "Esterilizacion.findByCiclo", query = "SELECT e FROM Esterilizacion e WHERE e.ciclo = :ciclo"),
//    @NamedQuery(name = "Esterilizacion.findByFecha", query = "SELECT e FROM Esterilizacion e WHERE e.fecha = :fecha"),
//    @NamedQuery(name = "Esterilizacion.findByPuntaje", query = "SELECT e FROM Esterilizacion e WHERE e.puntaje = :puntaje")

})
public class Movimiento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idmovimientos")
    private Integer idmovimientos;
    @Column(name = "tipoMovimiento")
    private Integer tipoMovimiento;
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
//    @Column(name = "puntaje")
//    private Integer puntaje;
    @JoinTable(name = "movimientos_materiales", joinColumns = {
        @JoinColumn(name = "idmovimientos", referencedColumnName = "idmovimientos")}, inverseJoinColumns = {
        @JoinColumn(name = "idMaterial", referencedColumnName = "idMaterial")})
    @ManyToMany(fetch = FetchType.LAZY)
    private Collection<Materiales> materialesCollection;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "esterilizacion", fetch = FetchType.LAZY)
//    private Collection<Esterilizacioninsumos> esterilizacioninsumosCollection;
//    @OneToMany(mappedBy = "idEsterilizacion", fetch = FetchType.LAZY)
//    private Collection<Indicadores> indicadoresCollection;
//    @JoinColumn(name = "idEstadoEst", referencedColumnName = "idEstadoEst")
//    @ManyToOne(optional = false, fetch = FetchType.LAZY)
//    private Esterilizacionestados idEstadoEst;
//    @JoinColumn(name = "idPrograma", referencedColumnName = "idPrograma")
//    @ManyToOne(fetch = FetchType.LAZY)
//    private Equiposprogramas idPrograma;
//    @JoinColumn(name = "idEquipo", referencedColumnName = "idEquipo")
//    @ManyToOne(fetch = FetchType.LAZY)
//    private Equipos idEquipo;
    @JoinColumn(name = "idUsuario", referencedColumnName = "idUsuario")
    @ManyToOne(fetch = FetchType.LAZY)
    private Usuarios idUsuario;

    
    
    public Movimiento() {
    }

    public Movimiento(Integer idEsterilizacion) {
        this.idmovimientos = idEsterilizacion;
    }

    public Integer getIdmovimientos() {
        return idmovimientos;
    }

    public void setIdmovimientos(Integer idmovimientos) {
        this.idmovimientos = idmovimientos;
    }

    public Integer getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(Integer tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

//    public Integer getPuntaje() {
//        return puntaje;
//    }
//
//    public void setPuntaje(Integer puntaje) {
//        this.puntaje = puntaje;
//    }

    @XmlTransient
    public Collection<Materiales> getMaterialesCollection() {
        return materialesCollection;
    }

    public void setMaterialesCollection(Collection<Materiales> materialesCollection) {
        this.materialesCollection = materialesCollection;
    }

//    @XmlTransient
//    public Collection<Esterilizacioninsumos> getEsterilizacioninsumosCollection() {
//        return esterilizacioninsumosCollection;
//    }
//
//    public void setEsterilizacioninsumosCollection(Collection<Esterilizacioninsumos> esterilizacioninsumosCollection) {
//        this.esterilizacioninsumosCollection = esterilizacioninsumosCollection;
//    }
/*
    @XmlTransient
    public Collection<Indicadores> getIndicadoresCollection() {
        return indicadoresCollection;
    }

    public void setIndicadoresCollection(Collection<Indicadores> indicadoresCollection) {
        this.indicadoresCollection = indicadoresCollection;
    }

    public Collection<Indicadores> getIndicadoresBioCollection()
    {
        Collection<Indicadores> list= new ArrayList<Indicadores>();
      
        for (Indicadores p : indicadoresCollection) 
        {
            if(p.getIdLoteIndicador().getIdProdIndicador().getTpoIndicador().getTpoIndicador()==1)
                list.add(p);
        }
    /*   for(int i = 0 ; i < size ; i++) {
            list.add(new Car(getRandomId(), getRandomBrand(), getRandomYear(), getRandomColor(), getRandomPrice(), getRandomSoldState()));
        }*/
         
       /* return list;
    }
    
     public Collection<Indicadores> getIndicadoresQuimCollection()
    {
        Collection<Indicadores> list= new ArrayList<Indicadores>();
      
        for (Indicadores p : indicadoresCollection) 
        {
            if(p.getIdLoteIndicador().getIdProdIndicador().getTpoIndicador().getTpoIndicador()!=1)
                list.add(p);
        }
    /*   for(int i = 0 ; i < size ; i++) {
            list.add(new Car(getRandomId(), getRandomBrand(), getRandomYear(), getRandomColor(), getRandomPrice(), getRandomSoldState()));
        }
         
        return list;
    }*/
    
//    public Esterilizacionestados getIdEstadoEst() {
//        return idEstadoEst;
//    }
//
//    public void setIdEstadoEst(Esterilizacionestados idEstadoEst) {
//        this.idEstadoEst = idEstadoEst;
//    }
/*
    public Equiposprogramas getIdPrograma() {
        return idPrograma;
    }

    public void setIdPrograma(Equiposprogramas idPrograma) {
        this.idPrograma = idPrograma;
    }

    public Equipos getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(Equipos idEquipo) {
        this.idEquipo = idEquipo;
    }*/

    public Usuarios getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuarios idUsuario) {
        this.idUsuario = idUsuario;
    }
    
//    public int actualizarEstado()
//    {
//        //Se llama cada vez que se cambie el valor de algunindicador quimico del mismo
//        //si devuelve true significa que el estado se tiene que actualizar y por ende llamar al facade edit
//
////SI NO TIENE INDICADORES SIGNIFICA QUE NO FUE CONTROLADO
//        
//        int estadoObjetivo=-1;
//        
//        if((indicadoresCollection.isEmpty() || indicadoresCollection==null))
//        {
//            estadoObjetivo= Consts.ESTADO_ESTERILIZACION_NO_CONTROLADO;
//      //   return true;   
//        }
//        
//        //SI NO ESTA VACIO SIGNIFICA QUE TENGO QUE VERIFICAR EL RESTO DE LOS INDICADORES
//        
//        Iterator<Indicadores> itera=indicadoresCollection.iterator();        
//      while(itera.hasNext())
//        {
//           Indicadores temp= itera.next();
//           
//        if((temp.getIdEstadoIndicador().getIdEstadoIndicador()==Consts.RESULTADO_CONTROL_INDICADOR_POSITIVO && temp.getIdLoteIndicador().getIdProdIndicador().getTpoIndicador().getTpoIndicador()==Consts.INDICADOR_TIPO_BIOLOGICO)
//          ||(temp.getIdEstadoIndicador().getIdEstadoIndicador()==Consts.RESULTADO_CONTROL_INDICADOR_NEGATIVO&& temp.getIdLoteIndicador().getIdProdIndicador().getTpoIndicador().getTpoIndicador()!=Consts.INDICADOR_TIPO_BIOLOGICO))
//        {
//            //ACA HACER ALGO CON LOS MATERIALES? 
//            // estadoObjetivo=Consts.ESTADO_LAVADO_SIN_EXITO;        
//             estadoObjetivo=Consts.ESTADO_ESTERILIZACION_CONTAMINADO;
//             break;
//        }
//        else 
//        if(temp.getIdEstadoIndicador().getIdEstadoIndicador()==Consts.RESULTADO_CONTROL_INDICADOR_SIN_RESULTADO)
//        {
//        //  estadoObjetivo= Consts.ESTADO_LAVADO_PARCIALMENTE_CONTROLADO;      
//                    estadoObjetivo= Consts.ESTADO_ESTERILIZACION_PARCIALMENTE_CONTROLADO; 
//          break;
//        }
//        }
//      
//      if(estadoObjetivo==-1)
//           //  estadoObjetivo= Consts.ESTADO_LAVADO_EXITOSO; 
//             estadoObjetivo= Consts.ESTADO_ESTERILIZACION_EXITOSO;
//      
//      if(idEstadoEst.getIdEstadoEst()==estadoObjetivo)
//      {
//          return -1; //dice si cambió o no el estado
//      }
//      else 
//      {
//          return estadoObjetivo;
//            }
//    // en esta funcion lo que tengo que hacer es recorrer todos los indicadores y dependiendo de los estados que tenga
//        //cambiar a parcialmente controlado, controlado, sin control, exito, sin exito, etceterererarar
//    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmovimientos != null ? idmovimientos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Movimiento)) {
            return false;
        }
        Movimiento other = (Movimiento) object;
        if ((this.idmovimientos == null && other.idmovimientos != null) || (this.idmovimientos != null && !this.idmovimientos.equals(other.idmovimientos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entidades.Esterilizacion[ idEsterilizacion=" + idmovimientos + " ]";
    }
    
}