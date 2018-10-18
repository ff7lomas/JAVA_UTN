package com.views;

import com.entidades.Usuarios;
import com.utils.JsfUtil;
import com.utils.Utils;
import java.io.Serializable;
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
@Named("usuariosView")
@ViewScoped
public class usuariosView implements Serializable {

    private static final long serialVersionUID = 1094801825228386363L;

    private List<Usuarios> usuarios;
    private Usuarios usuarioSelected;

    private String newUsername;
    private String newPassword;
    private String repeatPassword;

    Integer usuarioIdSelected;

    @PostConstruct
    public void init() {

        usuarioSelected = null;
        usuarios = null;
        reset();

        if (FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("usuarioSelected") != null) {
            usuarioIdSelected = Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("usuarioSelected"));
            usuarioSelected = usuariosFacade.find(usuarioIdSelected);
            newUsername = usuarioSelected.getUser();
        }
    }

    public void reset() {
        setNewUsername("");
        setNewPassword("");
        setRepeatPassword("");
    }

    @Inject
    private LoginView loginView;

    @EJB
    private com.facades.UsuariosFacade usuariosFacade;

    /**
     * @return the materiales
     */
    public List<Usuarios> getUsuarios() {
        if (usuarios == null) //   materiales= materialesFacade.findAll();
        {
            usuarios = usuariosFacade.findHabilitados();
        }
        return usuarios;
    }

    /**
     * @param usuarios the materiales to set
     */
    public void setUsuarios(List<Usuarios> usuarios) {
        this.usuarios = usuarios;
    }

    /**
     * @return the materialSelected
     */
    public Usuarios getUsuarioSelected() {
        return usuarioSelected;
    }

    /**
     * @param materialSelected the materialSelected to set
     */
    public void setUsuarioSelected(Usuarios usuarioSelected) {
        this.usuarioSelected = usuarioSelected;
    }

    /**
     * @return the newLote
     */
    public String getNewUsername() {
        return newUsername;
    }

    /**
     * @param newUsername the newLote to set
     */
    public void setNewUsername(String newUsername) {
        this.newUsername = newUsername;
    }

    /**
     * @return the newSerie
     */
    public String getNewPassword() {
        return newPassword;
    }

    /**
     * @param newPassword the newSerie to set
     */
    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    /**
     * @return the newDesc
     */
    public String getRepeatPassword() {
        return repeatPassword;
    }

    /**
     * @param repeatPassword the newDesc to set
     */
    public void setRepeatPassword(String repeatPassword) {
        this.repeatPassword = repeatPassword;
    }

    public void createUsuario() {
        try {

            if (usuarioIdSelected != null) {//edito
                usuarioSelected.setUser(newUsername);
                usuarioSelected.setPassword(newPassword);
                usuariosFacade.edit(usuarioSelected);
                JsfUtil.addSuccessMessage("Editado con éxito");
                goBack();

            } else {//nuevo

                usuarioSelected = new Usuarios();
                usuarioSelected.setUser(newUsername);
                usuarioSelected.setPassword(Utils.createPasswdHash(newPassword));
                usuarioSelected.setHabilitado(0);
                usuariosFacade.create(usuarioSelected);

                JsfUtil.addSuccessMessage("Creado con éxito");
                goBack();
            }

        } catch (Exception e) {
            JsfUtil.addErrorMessage("Exepción: " + e.getMessage());
        }

    }

    public void quitarUsuario() {
        if (usuarioSelected != null && !usuarioSelected.getUser().equals("admin")) {
            usuarioSelected.setHabilitado(1);
            usuariosFacade.edit(usuarioSelected);
            JsfUtil.addSuccessMessage("Eliminado con éxito");
            usuarios = null;
        } else {
            JsfUtil.addErrorMessage("No puede eliminar admin");
        }
    }

    public void goBack() {
        try {
            ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
            ec.redirect(ec.getRequestContextPath() + "/faces/usuarios_all.xhtml");
        } catch (Exception e) {
            JsfUtil.addErrorMessage("Exepción: " + e.getMessage());
        }
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
        if (!loginView.getUsername().equals("admin")) {
            goLogin();
            return "";
        } else {
            return loginView.getUsername();
        }
    }

}
