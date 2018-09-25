package com.views;

import com.entidades.Esterilizacion;
import com.entidades.Materiales;
import com.entidades.Materialesestados;
import com.entidades.Paquetes;
import com.entidades.Usuarios;
import com.facades.EsterilizacionFacade;
import com.facades.PaquetesFacade;

import com.facades.MovimientosFacade;

import com.entidades.Movimiento;
//import com.models.Datamatrix;
import com.utils.JsfUtil;
import com.utils.Consts;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;

/**
 *
 * @author jsturla
 */
@Named("egresoPaqueteView")
@ViewScoped
public class egresoPaqueteView implements Serializable {

  private static final long serialVersionUID = 1094801825228386363L;

//  private static final Logger logger = LogManager.getLogger(LoginView.class);

  private List<Paquetes> paquetes;
  private List<Paquetes> paquetesSelected;
  
 
  
 private Date newFecha;
 private int newCiclo;
 private Usuarios newUsuario;
  
  
     @Inject
  private LoginView loginView;
   
  @PostConstruct
    public void init() {
        
        paquetesSelected =  new ArrayList<Paquetes>();
        paquetes = null;       

    }

    public void reset() {
        paquetes=null;
        paquetesSelected= new ArrayList<Paquetes>();
        newFecha= new Date();
    }
  

  @EJB
  private com.facades.MaterialesFacade materialesFacade;
  
    @EJB
  private com.facades.MaterialesestadosFacade materialesestadosFacade;
    
        @EJB
  private com.facades.PaquetesFacade paquetesFacade;
    
        @EJB
  private com.facades.EsterilizacionFacade esterilizacionFacade;
        
     @EJB
  private com.facades.UsuariosFacade usuariosFacade;
     
     
        @EJB
  private com.facades.MovimientosFacade movimientosFacade;

    /**
     * @return the materiales
     */
    public List<Paquetes> getPaquetes() {
//        List<Paquetes> tempPaquete;
        if (paquetes == null) {
            paquetes = paquetesFacade.findHabilitadosSiEsteriles();
//            paquetes = new ArrayList<Paquetes>();
//            for (Paquetes paquete : tempPaquete) {
//                if (!paquete.isEsterilizado()) {
//                    paquetes.add(paquete);
//                }
//            }
        }
        return paquetes;
    }
    

    /**
     * @param paquetes the materiales to set
     */
    public void setPaquetes(List<Paquetes> paquetes) {
        this.paquetes = paquetes;
    }

    /**
     * @return the materialSelected
     */
    public List<Paquetes> getPaquetesSelected() {
        return paquetesSelected;
    }

    /**
     * @param paquetesSelected the materialSelected to set
     */
    public void setPaquetesSelected(List<Paquetes> paquetesSelected) {
        this.paquetesSelected = paquetesSelected;
    }

    
    public void createEgreso()
    {
        try
        {
            //debugear, limpiar y reutilizar, dando de baja paquete, cambiando estadios material
             Movimiento newMovimiento= new Movimiento();
            newMovimiento.setFecha(new Date());
            List<Materiales> allMateriales= new ArrayList<>();
            
            newMovimiento.setIdUsuario(loginView.getUsuario());
            
            Materialesestados estadoObjectivo= materialesestadosFacade.find(Consts.ESTADO_MATERIAL_FUERA);
            
            for(Paquetes paquete: paquetesSelected){
                
            for(Materiales material: paquete.getMaterialesCollection())
            {
             material.setIdEstMaterial(estadoObjectivo);
             materialesFacade.edit(material);
            }
            allMateriales.addAll(paquete.getMaterialesCollection());
            paquete.setHabilitado(1);
            paquetesFacade.edit(paquete);
            }
            
            newMovimiento.setMaterialesCollection(allMateriales);
            newMovimiento.setTipoMovimiento(Consts.MOVIMIENTO_SALIDA);
            movimientosFacade.create(newMovimiento);
            JsfUtil.addSuccessMessage("Egreso exitoso!");
            
            reset();
            
           
            
        }
        catch( Exception e)
        {
            JsfUtil.addErrorMessage("Exepción: "+e.getMessage());
        }
    }
    
//      public void goBack()
//    {
//        try{
//        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
//      ec.redirect(ec.getRequestContextPath() + "/faces/materiales_all.xhtml");
//        }
//        catch(Exception e)
//        {
//            
//        }
//    }

    /**
     * @return the newFecha
     */
    public Date getNewFecha() {
        return newFecha;
    }

    /**
     * @param newFecha the newFecha to set
     */
    public void setNewFecha(Date newFecha) {
        this.newFecha = newFecha;
    }

    /**
     * @return the newTipoMov
     */
    public int getNewCiclo() {
        return newCiclo;
    }

    /**
     * @param newCiclo the newTipoMov to set
     */
    public void setNewCiclo(int newCiclo) {
        this.newCiclo = newCiclo;
    }

    /**
     * @return the newUsuario
     */
    public Usuarios getNewUsuario() {
        return newUsuario;
    }

    /**
     * @param newUsuario the newUsuario to set
     */
    public void setNewUsuario(Usuarios newUsuario) {
        this.newUsuario = newUsuario;
    }
    
           public void goLogin()
    {
        try{
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
      ec.redirect(ec.getRequestContextPath() + "/faces/index.xhtml");
        }
        catch(Exception e)
        {
                        JsfUtil.addErrorMessage("Exepción: "+e.getMessage());
        }
    }
      
      public String getUser(){
         if(loginView.getUsername()==null)
         { goLogin();
         return "";}
             else
          return loginView.getUsername();
      }

}
