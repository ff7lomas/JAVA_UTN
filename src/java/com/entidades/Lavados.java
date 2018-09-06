/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entidades;

import com.utils.Consts;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
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
 * @author jsturla
 */

@Entity
@Table(name = "lavado", catalog = "ubuntu", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "lavado.findAll", query = "SELECT e FROM Lavados e"),
    @NamedQuery(name = "lavado.findByIdLavado", query = "SELECT e FROM Lavados e WHERE e.idLavado = :idlavado")
  //  @NamedQuery(name = "lavado.findByCiclo", query = "SELECT e FROM lavado e WHERE e.ciclo = :ciclo"),
  //  @NamedQuery(name = "lavado.findByFecha", query = "SELECT e FROM lavado e WHERE e.fecha = :fecha")
    })
public class Lavados implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)    
    @Column(name = "idlavado")
    private Integer idLavado;   
//    @Column(name = "tiempoLavado")
//    private Integer tiempoLavado;
    @Column(name = "fechaHoraLavado")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
//    @JoinColumn(name = "idEquipo", referencedColumnName = "idEquipo")
//    @ManyToOne(fetch = FetchType.LAZY)
//    private Equipos idEquipo;       
    @JoinColumn(name = "idUsuario", referencedColumnName = "idUsuario")
    @ManyToOne(fetch = FetchType.LAZY)
    private Usuarios idUsuario;        

    @ManyToMany(mappedBy = "lavadosCollection", fetch = FetchType.LAZY)
    private Collection<Materiales> materialesCollection;
    
//    @OneToMany(mappedBy = "idLavado", fetch = FetchType.LAZY)
//    private Collection<Indicadores> indicadoresCollection; //ind quimicos
    
    @JoinColumn(name = "idEstadoLavado", referencedColumnName = "idEstadoLavado")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Lavadoestados idEstadoLavado; 

//  @JoinColumn(name = "idPrograma", referencedColumnName = "idPrograma")
//    @ManyToOne(fetch = FetchType.LAZY)
//    private Equiposprogramas idPrograma;
 
  
  
    public Lavados() {
    }

    public Lavados(Integer idLavado) {
        this.idLavado = idLavado;
    }

    public Integer getIdLavado() {
        return idLavado;
    }

    public void setIdLavado(Integer idLavado) {
        this.idLavado = idLavado;
    }

//    public Integer getTiempo() {
//        return tiempoLavado;
//    }
//
//    public void setTiempo(Integer tiempo) {
//        this.tiempoLavado = tiempo;
//    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

   @XmlTransient
    public Collection<Materiales> getMaterialesCollection() {
        return materialesCollection;
    }

    public void setMaterialCollection(Collection<Materiales> material) {
        this.materialesCollection = material;
    }


//
//    @XmlTransient
//    public Collection<Indicadores> getIndicadoresCollection() {
//        return indicadoresCollection;
//    }
//
//    public void setIndicadoresCollection(Collection<Indicadores> indicadoresCollection) {
//        this.indicadoresCollection = indicadoresCollection;
//    }

    public Lavadoestados getIdEstadoLav() {
        return idEstadoLavado;
    }

    public void setIdEstadoLav(Lavadoestados idEstadoLavado) {
        this.idEstadoLavado = idEstadoLavado;
    }

//    public Equipos getIdEquipo() {
//        return idEquipo;
//    }
//
//    public void setIdEquipo(Equipos idEquipo) {
//        this.idEquipo = idEquipo;
//    }

    public Usuarios getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuarios idUsuario) {
        this.idUsuario = idUsuario;
    }
    
//      public int actualizarEstado()
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
//            estadoObjetivo= Consts.ESTADO_LAVADO_NO_CONTROLADO;
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
//        if(temp.getIdResultadoControlIndicador().getIdResultadoControlIndicador()==Consts.RESULTADO_CONTROL_INDICADOR_UNSAFE)
//        {
//             estadoObjetivo= Consts.ESTADO_LAVADO_SIN_EXITO;        
//             break;
//        }
//        else 
//        if(temp.getIdResultadoControlIndicador().getIdResultadoControlIndicador()==Consts.RESULTADO_CONTROL_INDICADOR_SIN_RESULTADO)
//        {
//          estadoObjetivo= Consts.ESTADO_LAVADO_PARCIALMENTE_CONTROLADO;        
//          break;
//        }
//        }
//      
//      if(estadoObjetivo==-1)
//             estadoObjetivo= Consts.ESTADO_LAVADO_EXITOSO; 
//      
//      if(idEstadoLavado.getIdEstadoLavado()==estadoObjetivo)
//      {
//          return -1;
//      }
//      else 
//      {
//          //idEstadoLavado=estadoObjetivo;
//          return estadoObjetivo;
//            }
//    // en esta funcion lo que tengo que hacer es recorrer todos los indicadores y dependiendo de los estados que tenga
//        //cambiar a parcialmente controlado, controlado, sin control, exito, sin exito, etceterererarar
//    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLavado != null ? idLavado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lavados)) {
            return false;
        }
        Lavados other = (Lavados) object;
        if ((this.idLavado == null && other.idLavado != null) || (this.idLavado != null && !this.idLavado.equals(other.idLavado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entidades.Lavados[ idLavado=" + idLavado + " ]";
    }
        
//    public Equiposprogramas getIdPrograma() {
//        return idPrograma;
//    }
//
//    public void setIdPrograma(Equiposprogramas idPrograma) {
//        this.idPrograma = idPrograma;
//    }
    
}
