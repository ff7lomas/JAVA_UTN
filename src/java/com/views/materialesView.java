package com.views;

import com.entidades.Materiales;
import com.entidades.Materialesestados;
import com.utils.Consts;
//import com.models.Datamatrix;
import com.utils.JsfUtil;
import com.utils.Utils;
import java.io.IOException;
import java.io.Serializable;
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
@Named("materialesView")
@ViewScoped
public class materialesView implements Serializable {

  private static final long serialVersionUID = 1094801825228386363L;

//  private static final Logger logger = LogManager.getLogger(LoginView.class);

  private List<Materiales> materiales;
  private Materiales materialSelected;
  
  private String newLote;
  private String newSerie;
  private String newDesc;
  private String newMarca;
  private String newFamilia;
  
   Integer  materialIdSelected;
    @Inject
  private LoginView loginView;
    
  @PostConstruct
    public void init() {
        
        materialSelected = null;
        materiales = null;
        reset();
        
    if(    FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("materialSelected")!=null){
        materialIdSelected = Integer.parseInt(  FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("materialSelected"));
		materialSelected = materialesFacade.find(materialIdSelected);
        newLote = materialSelected.getNroLote();
        newSerie = materialSelected.getNroSerie();
        newDesc = materialSelected.getDscTipoMaterial();
        newMarca = materialSelected.getMarca();
        newFamilia = materialSelected.getFamilia();
      
    }
    }

    public void reset() {
        setNewLote("");
        setNewSerie("");
        setNewDesc("");
        setNewMarca("");
        setNewFamilia("");
    }
  

  @EJB
  private com.facades.MaterialesFacade materialesFacade;
  
    @EJB
  private com.facades.MaterialesestadosFacade materialesestadosFacade;

    /**
     * @return the materiales
     */
    public List<Materiales> getMateriales() {
        if(materiales== null)
         //   materiales= materialesFacade.findAll();
               materiales= materialesFacade.findHabilitados();
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
    public Materiales getMaterialSelected() {
        return materialSelected;
    }

    /**
     * @param materialSelected the materialSelected to set
     */
    public void setMaterialSelected(Materiales materialSelected) {
        this.materialSelected = materialSelected;
    }

    /**
     * @return the newLote
     */
    public String getNewLote() {
        return newLote;
    }

    /**
     * @param newLote the newLote to set
     */
    public void setNewLote(String newLote) {
        this.newLote = newLote;
    }

    /**
     * @return the newSerie
     */
    public String getNewSerie() {
        return newSerie;
    }

    /**
     * @param newSerie the newSerie to set
     */
    public void setNewSerie(String newSerie) {
        this.newSerie = newSerie;
    }

    /**
     * @return the newDesc
     */
    public String getNewDesc() {
        return newDesc;
    }

    /**
     * @param newDesc the newDesc to set
     */
    public void setNewDesc(String newDesc) {
        this.newDesc = newDesc;
    }

    /**
     * @return the newMarca
     */
    public String getNewMarca() {
        return newMarca;
    }

    /**
     * @param newMarca the newMarca to set
     */
    public void setNewMarca(String newMarca) {
        this.newMarca = newMarca;
    }

    /**
     * @return the newFamilia
     */
    public String getNewFamilia() {
        return newFamilia;
    }

    /**
     * @param newFamilia the newFamilia to set
     */
    public void setNewFamilia(String newFamilia) {
        this.newFamilia = newFamilia;
    }
    
    public void createMaterial()
    {
        try
        {
            if (materialIdSelected!=null) {//edito
                materialSelected.setNroLote(newLote);
                materialSelected.setNroSerie(newSerie);
                materialSelected.setDscTipoMaterial(newDesc);
                materialSelected.setMarca(newMarca);
                materialSelected.setFamilia(newFamilia);
                materialesFacade.edit(materialSelected);
                JsfUtil.addSuccessMessage("Editado con éxito");
                goBack();
                
            } else {//nuevo

                Materialesestados matEst = materialesestadosFacade.find(Consts.ESTADO_MATERIAL_FUERA);

                materialSelected = new Materiales();
                materialSelected.setNroLote(newLote);
                materialSelected.setNroSerie(newSerie);
                materialSelected.setDscTipoMaterial(newDesc);
                materialSelected.setMarca(newMarca);
                materialSelected.setFamilia(newFamilia);
                materialSelected.setIdEstMaterial(matEst);
                materialesFacade.create(materialSelected);

                JsfUtil.addSuccessMessage("Creado con éxito");
                goBack();
            }
            
            
            
        }
        catch(Exception e)
        {
                     JsfUtil.addErrorMessage("Exepción: "+e.getMessage());   
        }
                
    }
    
    public void quitarMaterial()
    {
        if(materialSelected!=null)
        {
            materialSelected.setHabilitado(1);
            materialesFacade.edit(materialSelected);
            JsfUtil.addSuccessMessage("Eliminado con éxito");
            materiales=null;
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

