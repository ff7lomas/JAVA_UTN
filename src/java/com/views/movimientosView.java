package com.views;

import com.entidades.Materiales;
import com.entidades.Materialesestados;
import com.entidades.Movimiento;
import com.entidades.Usuarios;
import com.facades.MovimientosFacade;
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
@Named("movimientosView")
@ViewScoped
public class movimientosView implements Serializable {

  private static final long serialVersionUID = 1094801825228386363L;

//  private static final Logger logger = LogManager.getLogger(LoginView.class);

  private List<Materiales> materiales;
  private List<Materiales> materialesSelected;
  
  
  
 private Date newFecha;
 private int newTipoMov;
 private Usuarios newUsuario;
  
   Integer  materialIdSelected;
  
     @Inject
  private LoginView loginView;
   
  @PostConstruct
    public void init() {
        
        materialesSelected =  new ArrayList<Materiales>();
        materiales = null;       

    }

    public void reset() {
        materiales=null;
        materialesSelected= new ArrayList<Materiales>();
        newFecha= new Date();
    }
  

  @EJB
  private com.facades.MaterialesFacade materialesFacade;
  
    @EJB
  private com.facades.MaterialesestadosFacade materialesestadosFacade;
    
        @EJB
  private com.facades.MovimientosFacade movimientosFacade;
    
     @EJB
  private com.facades.UsuariosFacade usuariosFacade;

    /**
     * @return the materiales
     */
    public List<Materiales> getMateriales() {
        if(materiales== null)
         //   materiales= materialesFacade.findAll();
               materiales= materialesFacade.findHabilitados();
        return materiales;
    }
    
       public List<Materiales> getMaterialesIngreso() {
           newTipoMov=Consts.MOVIMIENTO_ENTRADA;
        if(materiales== null)
               materiales= materialesFacade.findByIdEstMaterialAndHabilitado(Consts.ESTADO_MATERIAL_FUERA,Consts.REGISTRO_HABILITADO); //CAMBIAR ESTO POR ESTADOS
        return materiales;
    }
       
          public List<Materiales> getMaterialesSalida() {
                newTipoMov=Consts.MOVIMIENTO_SALIDA;
        if(materiales== null)
             materiales= materialesFacade.findByIdEstMaterialAndHabilitado(Consts.ESTADO_MATERIAL_ESTERILIZADO,Consts.REGISTRO_HABILITADO); //CAMBIAR ESTO POR ESTADOS
      
        return materiales;
    }

    /**
     * @param materiales the materiales to set
     */
    public void setMateriales(List<Materiales> materiales) {
        this.materiales = materiales;
    }

    /**
     * @return the materialSelected
     */
    public List<Materiales> getMaterialesSelected() {
        return materialesSelected;
    }

    /**
     * @param materialesSelected the materialSelected to set
     */
    public void setMaterialesSelected(List<Materiales> materialesSelected) {
        this.materialesSelected = materialesSelected;
    }

    
    public void createMovimiento()
    {
        try
        {
            Movimiento newMovimiento= new Movimiento();
            newMovimiento.setFecha(new Date());
            
            newMovimiento.setIdUsuario(loginView.getUsuario());
            
            Materialesestados estadoObjectivo= materialesestadosFacade.find(Consts.ESTADO_MATERIAL_INGRESADO);
            for(Materiales material: materialesSelected)
            {
             material.setIdEstMaterial(estadoObjectivo);
             materialesFacade.edit(material);
            }
            
            newMovimiento.setMaterialesCollection(materialesSelected);
            newMovimiento.setTipoMovimiento(newTipoMov);
            movimientosFacade.create(newMovimiento);
            JsfUtil.addSuccessMessage("Ingreso exitoso!");
            
            reset();
        }
        catch( Exception e)
        {
                        JsfUtil.addErrorMessage("Exepción: "+e.getMessage());
        }
    }
    
      public void goBack()
    {
        try{
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
      ec.redirect(ec.getRequestContextPath() + "/faces/materiales_all.xhtml");
        }
        catch(Exception e)
        {
                        JsfUtil.addErrorMessage("Exepción: "+e.getMessage());
        }
    }

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
    public int getNewTipoMov() {
        return newTipoMov;
    }

    /**
     * @param newTipoMov the newTipoMov to set
     */
    public void setNewTipoMov(int newTipoMov) {
        this.newTipoMov = newTipoMov;
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

}
