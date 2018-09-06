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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author usuario
 */
@Entity
@Table(name = "paquetes", catalog = "ubuntu", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Paquetes.findAll", query = "SELECT p FROM Paquetes p"),
    @NamedQuery(name = "Paquetes.findByIdPaquete", query = "SELECT p FROM Paquetes p WHERE p.idPaquete = :idPaquete"),
    @NamedQuery(name = "Paquetes.findByFecha", query = "SELECT p FROM Paquetes p WHERE p.fecha = :fecha"),
    @NamedQuery(name = "Paquetes.findByHabilitado", query = "SELECT p FROM Paquetes p WHERE p.habilitado = :habilitado")})
public class Paquetes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPaquete")
    private Integer idPaquete;
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "habilitado")
    private int habilitado;
    @ManyToMany(mappedBy = "paquetesCollection", fetch = FetchType.LAZY)
    private Collection<Materiales> materialesCollection;
    @ManyToMany(mappedBy = "paquetesCollection", fetch = FetchType.LAZY)
    private Collection<Esterilizacion> esterilizacionCollection;
    @JoinColumn(name = "idUsuario", referencedColumnName = "idUsuario")
    @ManyToOne(fetch = FetchType.LAZY)
    private Usuarios idUsuario;
    @JoinColumn(name = "idEstPaquete", referencedColumnName = "idEstPaquete")
    @ManyToOne(fetch = FetchType.LAZY)
    private Paquetesestados idEstPaquete;
//    @OneToMany(mappedBy = "idPaquete", fetch = FetchType.LAZY)
//    private Collection<Indicadores> indicadoresCollection;
//    @OneToMany(mappedBy = "idPaquete", fetch = FetchType.LAZY)
//    private Collection<Insumos> insumosCollection;
    @JoinColumn(name = "codAlmacen", referencedColumnName = "idAlmacen")
    @ManyToOne(fetch = FetchType.LAZY)
    private Almacenes codAlmacen;
//     @ManyToMany(mappedBy = "paquetesCollection", fetch = FetchType.LAZY)
//    private Collection<Cirugia> cirugiaCollection;

    public Paquetes() {
    }

    public Paquetes(Integer idPaquete) {
        this.idPaquete = idPaquete;
    }

    public Paquetes(Integer idPaquete, int habilitado) {
        this.idPaquete = idPaquete;
        this.habilitado = habilitado;
    }

//     public Collection<Indicadores> getIndicadoresBioCollection()
//    {
//        Collection<Indicadores> list= new ArrayList<Indicadores>();
//      
//        for (Indicadores p : indicadoresCollection) 
//        {
//            if(p.getIdLoteIndicador().getIdProdIndicador().getTpoIndicador().getTpoIndicador()==1)
//                list.add(p);
//        }
//    /*   for(int i = 0 ; i < size ; i++) {
//            list.add(new Car(getRandomId(), getRandomBrand(), getRandomYear(), getRandomColor(), getRandomPrice(), getRandomSoldState()));
//        }*/
//         
//        return list;
//    }
//    
//     public Collection<Indicadores> getIndicadoresQuimCollection()
//    {
//        Collection<Indicadores> list= new ArrayList<Indicadores>();
//      
//        for (Indicadores p : indicadoresCollection) 
//        {
//            if(p.getIdLoteIndicador().getIdProdIndicador().getTpoIndicador().getTpoIndicador()!=1)
//                list.add(p);
//        }
//    /*   for(int i = 0 ; i < size ; i++) {
//            list.add(new Car(getRandomId(), getRandomBrand(), getRandomYear(), getRandomColor(), getRandomPrice(), getRandomSoldState()));
//        }*/
//         
//        return list;
//    }
    
    public Integer getIdPaquete() {
        return idPaquete;
    }

    public void setIdPaquete(Integer idPaquete) {
        this.idPaquete = idPaquete;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getHabilitado() {
        return habilitado;
    }

    public void setHabilitado(int habilitado) {
        this.habilitado = habilitado;
    }

    @XmlTransient
    public Collection<Materiales> getMaterialesCollection() {
        return materialesCollection;
    }

    public void setMaterialesCollection(Collection<Materiales> materialesCollection) {
        this.materialesCollection = materialesCollection;
    }

    @XmlTransient
    public Collection<Esterilizacion> getEsterilizacionCollection() {
        return esterilizacionCollection;
    }

    public void setEsterilizacionCollection(Collection<Esterilizacion> esterilizacionCollection) {
        this.esterilizacionCollection = esterilizacionCollection;
    }

    public Usuarios getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuarios idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Paquetesestados getIdEstPaquete() {
        return idEstPaquete;
    }

    public void setIdEstPaquete(Paquetesestados idEstPaquete) {
        this.idEstPaquete = idEstPaquete;
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
//
//    @XmlTransient
//    public Collection<Insumos> getInsumosCollection() {
//        return insumosCollection;
//    }
//
//    public void setInsumosCollection(Collection<Insumos> insumosCollection) {
//        this.insumosCollection = insumosCollection;
//    }
//    
//      @XmlTransient
//    public Collection<Cirugia> getCirugiaCollection() {
//        return cirugiaCollection;
//    }
//
//    public void setCirugiaCollection(Collection<Cirugia> cirugiaCollection) {
//        this.cirugiaCollection = cirugiaCollection;
//    }
//    
//    public Cirugia getCirugia()
//    {
//        if(!cirugiaCollection.isEmpty())
//        {
//            return (Cirugia)cirugiaCollection.toArray()[0];
//        }
//        else return null;
//    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPaquete != null ? idPaquete.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Paquetes)) {
            return false;
        }
        Paquetes other = (Paquetes) object;
        if ((this.idPaquete == null && other.idPaquete != null) || (this.idPaquete != null && !this.idPaquete.equals(other.idPaquete))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entidades.Paquetes[ idPaquete=" + idPaquete + " ]";
    }
    
        public Almacenes getCodAlmacen() {
        return codAlmacen;
    }

    public void setCodAlmacen(Almacenes codAlmacen) {
        this.codAlmacen = codAlmacen;
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
//       //     estadoObjetivo= Consts.ESTADO_ESTERILIZACION_NO_CONTROLADO;
//                 estadoObjetivo= Consts.ESTADO_PAQUETE_SIN_CONTROL;
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
//             estadoObjetivo=Consts.ESTADO_PAQUETE_BAJA;
//             break;
//        }
//        else 
//        if(temp.getIdEstadoIndicador().getIdEstadoIndicador()==Consts.RESULTADO_CONTROL_INDICADOR_SIN_RESULTADO)
//        {
//        //  estadoObjetivo= Consts.ESTADO_LAVADO_PARCIALMENTE_CONTROLADO;      
//                    estadoObjetivo= Consts.ESTADO_PAQUETE_PARCIALMENTE_CONTROLADO; 
//          break;
//        }
//        }
//      
//      if(estadoObjetivo==-1)
//           //  estadoObjetivo= Consts.ESTADO_LAVADO_EXITOSO; 
//             estadoObjetivo= Consts.ESTADO_PAQUETE_CONTROLADO;
//      
//      if(idEstPaquete.getIdEstPaquete()==estadoObjetivo)
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
//    
}
