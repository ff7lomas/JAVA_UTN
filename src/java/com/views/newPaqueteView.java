package com.views;

import com.entidades.Materiales;
import com.entidades.Materialesestados;
import com.entidades.Paquetes;
import com.entidades.Usuarios;
import com.utils.JsfUtil;
import com.utils.Consts;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author jsturla
 */
@Named("newPaqueteView")
@ViewScoped
public class newPaqueteView implements Serializable {

    private static final long serialVersionUID = 1094801825228386363L;

    private List<Materiales> materiales;
    private List<Materiales> materialesSelected;

    private Date newFecha;
    private int newTipoMov;
    private Usuarios newUsuario;

    @Inject
    private LoginView loginView;

    @PostConstruct
    public void init() {

        materialesSelected = new ArrayList<>();
        materiales = null;

    }

    public void reset() {
        materiales = null;
        materialesSelected = new ArrayList<>();
        newFecha = new Date();
    }

    @EJB
    private com.facades.MaterialesFacade materialesFacade;

    @EJB
    private com.facades.MaterialesestadosFacade materialesestadosFacade;

    @EJB
    private com.facades.PaquetesFacade paquetesFacade;

    @EJB
    private com.facades.UsuariosFacade usuariosFacade;

    /**
     * @return the materiales
     */
    public List<Materiales> getMateriales() {
        if (materiales == null) {
            materiales = materialesFacade.findByIdEstMaterialAndHabilitado(Consts.ESTADO_MATERIAL_INGRESADO, Consts.REGISTRO_HABILITADO); //CAMBIAR ESTO POR ESTADOS
        }
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

    public void createPaquete() {
        try {
            Paquetes newPaquete = new Paquetes();
            newPaquete.setFecha(new Date());

            newPaquete.setIdUsuario(loginView.getUsuario());

            Materialesestados estadoObjectivo = materialesestadosFacade.find(Consts.ESTADO_MATERIAL_PREPARADO);
            for (Materiales material : materialesSelected) {
                material.setIdEstMaterial(estadoObjectivo);
                materialesFacade.edit(material);
            }

            newPaquete.setMaterialesCollection(materialesSelected);
            newPaquete.setHabilitado(Consts.REGISTRO_HABILITADO);
            paquetesFacade.create(newPaquete);
            JsfUtil.addSuccessMessage("Ingreso exitoso!");

            reset();
        } catch (Exception e) {
            JsfUtil.addErrorMessage("Exepción: " + e.getMessage());
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

    public void goLogin() {
        try {
            ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
            ec.redirect(ec.getRequestContextPath() + "/faces/index.xhtml");
        } catch (Exception e) {
            JsfUtil.addErrorMessage("Exepción: " + e.getMessage());
        }
    }

    public String getUser() {
        if (loginView.getUsername() == null) {
            goLogin();
            return "";
        } else {
            return loginView.getUsername();
        }
    }

}
