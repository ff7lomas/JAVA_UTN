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
import org.primefaces.model.chart.PieChartModel;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;

/**
 *
 * @author jsturla
 */
@Named("reporteView")
@ViewScoped
public class reporteView implements Serializable {

  private static final long serialVersionUID = 1094801825228386363L;

//  private static final Logger logger = LogManager.getLogger(LoginView.class);

//  private List<Materiales> materiales;
//  private Materiales materialSelected;
//  
//  private String newLote;
//  private String newSerie;
//  private String newDesc;
//  private String newMarca;
//  private String newFamilia;
  
  private PieChartModel pieModel1;
    private PieChartModel pieModel2;
  
   Integer  materialIdSelected;
    @Inject
  private LoginView loginView;
      
  @EJB
  private com.facades.MaterialesFacade materialesFacade;
  
    @EJB
  private com.facades.MaterialesestadosFacade materialesestadosFacade;
    
        @EJB
  private com.facades.MovimientosFacade movimientosFacade;
    
    @PostConstruct
    public void init() {
        createPieModel1();
        createPieModel2();
    }

//    public void reset() {
//        setNewLote("");
//        setNewSerie("");
//        setNewDesc("");
//        setNewMarca("");
//        setNewFamilia("");
//    }
    
    
    private void createPieModel1() {
        pieModel1 = new PieChartModel();
       
        pieModel1.set("Fuera",materialesFacade.findByIdEstMaterialAndHabilitado(Consts.ESTADO_MATERIAL_FUERA, Consts.REGISTRO_HABILITADO).size());
        pieModel1.set("Ingresado", materialesFacade.findByIdEstMaterialAndHabilitado(Consts.ESTADO_MATERIAL_INGRESADO, Consts.REGISTRO_HABILITADO).size());
        pieModel1.set("Preparado", materialesFacade.findByIdEstMaterialAndHabilitado(Consts.ESTADO_MATERIAL_PREPARADO, Consts.REGISTRO_HABILITADO).size());
        pieModel1.set("Esterilizado", materialesFacade.findByIdEstMaterialAndHabilitado(Consts.ESTADO_MATERIAL_ESTERILIZADO, Consts.REGISTRO_HABILITADO).size());
         
        pieModel1.setTitle("Materiales");
        pieModel1.setLegendPosition("w");
        pieModel1.setShadow(false);
    }
    
      private void createPieModel2() {
        pieModel2 = new PieChartModel();
       
        pieModel2.set("Entradas",movimientosFacade.findByTipoMov(Consts.MOVIMIENTO_ENTRADA).size());
        pieModel2.set("Salidas", movimientosFacade.findByTipoMov(Consts.MOVIMIENTO_SALIDA).size());
         
        pieModel2.setTitle("Movimientos");
        pieModel2.setLegendPosition("w");
        pieModel2.setShadow(false);
    }


    /**
     * @return the materiales
     */
//    public List<Materiales> getMateriales() {
//        if(materiales== null)
//         //   materiales= materialesFacade.findAll();
//               materiales= materialesFacade.findHabilitados();
//        return materiales;
//    }
//
//    /**
//     * @param materiales the materiales to set
//     */
//    public void setMateriales(List<Materiales> materiales) {
//        this.materiales = materiales;
//    }
//
//    /**
//     * @return the materialSelected
//     */
//    public Materiales getMaterialSelected() {
//        return materialSelected;
//    }
//
//    /**
//     * @param materialSelected the materialSelected to set
//     */
//    public void setMaterialSelected(Materiales materialSelected) {
//        this.materialSelected = materialSelected;
//    }
//
//    /**
//     * @return the newLote
//     */
//    public String getNewLote() {
//        return newLote;
//    }
//
//    /**
//     * @param newLote the newLote to set
//     */
//    public void setNewLote(String newLote) {
//        this.newLote = newLote;
//    }
//
//    /**
//     * @return the newSerie
//     */
//    public String getNewSerie() {
//        return newSerie;
//    }
//
//    /**
//     * @param newSerie the newSerie to set
//     */
//    public void setNewSerie(String newSerie) {
//        this.newSerie = newSerie;
//    }
//
//    /**
//     * @return the newDesc
//     */
//    public String getNewDesc() {
//        return newDesc;
//    }
//
//    /**
//     * @param newDesc the newDesc to set
//     */
//    public void setNewDesc(String newDesc) {
//        this.newDesc = newDesc;
//    }
//
//    /**
//     * @return the newMarca
//     */
//    public String getNewMarca() {
//        return newMarca;
//    }
//
//    /**
//     * @param newMarca the newMarca to set
//     */
//    public void setNewMarca(String newMarca) {
//        this.newMarca = newMarca;
//    }
//
//    /**
//     * @return the newFamilia
//     */
//    public String getNewFamilia() {
//        return newFamilia;
//    }
//
//    /**
//     * @param newFamilia the newFamilia to set
//     */
//    public void setNewFamilia(String newFamilia) {
//        this.newFamilia = newFamilia;
//    }
//    
//    public void createMaterial()
//    {
//        try
//        {
//            if (materialIdSelected!=null) {//edito
//                materialSelected.setNroLote(newLote);
//                materialSelected.setNroSerie(newSerie);
//                materialSelected.setDscTipoMaterial(newDesc);
//                materialSelected.setMarca(newMarca);
//                materialSelected.setFamilia(newFamilia);
//                materialesFacade.edit(materialSelected);
//                JsfUtil.addSuccessMessage("Editado con éxito");
//                goBack();
//                
//            } else {//nuevo
//
//                Materialesestados matEst = materialesestadosFacade.find(Consts.ESTADO_MATERIAL_FUERA);
//
//                materialSelected = new Materiales();
//                materialSelected.setNroLote(newLote);
//                materialSelected.setNroSerie(newSerie);
//                materialSelected.setDscTipoMaterial(newDesc);
//                materialSelected.setMarca(newMarca);
//                materialSelected.setFamilia(newFamilia);
//                materialSelected.setIdEstMaterial(matEst);
//                materialesFacade.create(materialSelected);
//
//                JsfUtil.addSuccessMessage("Creado con éxito");
//                goBack();
//            }
//            
//            
//            
//        }
//        catch(Exception e)
//        {
//                     JsfUtil.addErrorMessage("Exepción: "+e.getMessage());   
//        }
//                
//    }
//    
//    public void quitarMaterial()
//    {
//        if(materialSelected!=null)
//        {
//            materialSelected.setHabilitado(1);
//            materialesFacade.edit(materialSelected);
//            JsfUtil.addSuccessMessage("Eliminado con éxito");
//            materiales=null;
//        }
//    }
    
      
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
     

    /**
     * @return the pieModel1
     */
    public PieChartModel getPieModel1() {
        return pieModel1;
    }

    /**
     * @param pieModel1 the pieModel1 to set
     */
    public void setPieModel1(PieChartModel pieModel1) {
        this.pieModel1 = pieModel1;
    }

    /**
     * @return the pieModel2
     */
    public PieChartModel getPieModel2() {
        return pieModel2;
    }

    /**
     * @param pieModel2 the pieModel2 to set
     */
    public void setPieModel2(PieChartModel pieModel2) {
        this.pieModel2 = pieModel2;
    }

}

