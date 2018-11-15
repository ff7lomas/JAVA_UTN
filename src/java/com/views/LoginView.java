package com.views;

import com.beans.SessionBean;
import com.entidades.Usuarios;
import com.utils.Consts;
import com.utils.JsfUtil;
import com.utils.Utils;
import java.io.Serializable;
import java.util.Date;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.servlet.http.HttpSession;
import javax.inject.Named;

/**
 *
 * @author jsturla
 */
@Named("loginView")
@SessionScoped
public class LoginView implements Serializable {

    private static final long serialVersionUID = 1094801825228386363L;

    private String username;
    private String password;
    private String msg;
    private Usuarios usuario;

    @EJB
    private com.facades.UsuariosFacade usuariosFacade;

    public String validateUsernamePassword() {
        usuario = usuariosFacade.validateByUsername(username, password);
        return validateUsernamePasswordHelper();
    }

    public boolean isAdminLogin() {
     //   HttpSession session = SessionBean.getSession();
    //    String debug = session.getAttribute("username").toString();
        if (usuarioLogeado().equals("admin")) {
            return true;
        } else {
            return false;
        }
    }

    public String usuarioLogeado() {
        try{
        HttpSession session = SessionBean.getSession();
        String debug = session.getAttribute("username").toString(); 
        return debug;
        }
        catch(Exception e)
        {
            return "No loggeado";
        }
                
    }

    // Validate login helper
    public String validateUsernamePasswordHelper() {
        if (usuario != null) {
//    Es válido
            HttpSession session = SessionBean.getSession();
            session.setAttribute("username", usuario.getUser());
            usuario.setLastLogin(new Date());
            try {
                usuariosFacade.edit(usuario);
            } catch (Exception e) {
                JsfUtil.addErrorMessage("Exepción: " + e.getMessage());
            }
            return "main_menu";
        } else {
//  No es válido
            if (usuariosFacade.findHabilitados().size() == 0) {//no hay nada creado
                Usuarios newUser = new Usuarios();
                newUser.setHabilitado(Consts.REGISTRO_HABILITADO);
                newUser.setUser("admin");
                newUser.setPassword(Utils.createPasswdHash("admin"));
                usuariosFacade.create(newUser);
            }
            JsfUtil.addErrorMessage(("usuario_password_incorrectos"), ("ingrese_usuario_password_correctos"));
            return "dashboard";
        }
    }
    
    public void logOutUsuario()
    {
        HttpSession session = SessionBean.getSession();
             session.removeAttribute("username");
    
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

}
