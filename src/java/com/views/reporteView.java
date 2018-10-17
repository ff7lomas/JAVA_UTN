package com.views;

import com.utils.Consts;
import com.utils.JsfUtil;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.model.chart.PieChartModel;

/**
 *
 * @author jsturla
 */
@Named("reporteView")
@ViewScoped
public class reporteView implements Serializable {

    private static final long serialVersionUID = 1094801825228386363L;

    private PieChartModel pieModel1;
    private PieChartModel pieModel2;

    @Inject
    private LoginView loginView;

    @EJB
    private com.facades.MaterialesFacade materialesFacade;

    @EJB
    private com.facades.MovimientosFacade movimientosFacade;

    @PostConstruct
    public void init() {
        createPieModel1();
        createPieModel2();
    }

    private void createPieModel1() {
        pieModel1 = new PieChartModel();

        pieModel1.set("Fuera", materialesFacade.findByIdEstMaterialAndHabilitado(Consts.ESTADO_MATERIAL_FUERA, Consts.REGISTRO_HABILITADO).size());
        pieModel1.set("Ingresado", materialesFacade.findByIdEstMaterialAndHabilitado(Consts.ESTADO_MATERIAL_INGRESADO, Consts.REGISTRO_HABILITADO).size());
        pieModel1.set("Preparado", materialesFacade.findByIdEstMaterialAndHabilitado(Consts.ESTADO_MATERIAL_PREPARADO, Consts.REGISTRO_HABILITADO).size());
        pieModel1.set("Esterilizado", materialesFacade.findByIdEstMaterialAndHabilitado(Consts.ESTADO_MATERIAL_ESTERILIZADO, Consts.REGISTRO_HABILITADO).size());

        pieModel1.setTitle("Materiales");
        pieModel1.setLegendPosition("w");
        pieModel1.setShadow(false);
    }

    private void createPieModel2() {
        pieModel2 = new PieChartModel();

        pieModel2.set("Entradas", movimientosFacade.findByTipoMov(Consts.MOVIMIENTO_ENTRADA).size());
        pieModel2.set("Salidas", movimientosFacade.findByTipoMov(Consts.MOVIMIENTO_SALIDA).size());

        pieModel2.setTitle("Movimientos");
        pieModel2.setLegendPosition("w");
        pieModel2.setShadow(false);
    }

    public void goLogin() {
        try {
            ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
            ec.redirect(ec.getRequestContextPath() + "/faces/index.xhtml");
        } catch (Exception e) {
            JsfUtil.addErrorMessage("Exepción: " + e.getMessage());
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
