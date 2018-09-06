package com.views;

import com.beans.SessionBean;
import com.entidades.Usuarios;
//import com.models.Datamatrix;
import com.utils.JsfUtil;
import com.utils.Utils;
import java.io.IOException;
import java.io.Serializable;
import java.util.Date;
import java.util.Map;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import javax.inject.Named;

/**
 *
 * @author Nahuel Rullo <nahuelrullo at gmail.com>
 */
@Named("loginView")
@SessionScoped
public class LoginView implements Serializable {

  private static final long serialVersionUID = 1094801825228386363L;

//  private static final Logger logger = LogManager.getLogger(LoginView.class);

  private String username;
  private String password;
  private String msg;
  private Usuarios usuario;

  @EJB
  private com.facades.UsuariosFacade usuariosFacade;
  
  // Validate login laser
 

  // Validate login form
  public String validateUsernamePassword() {
    usuario = usuariosFacade.validateByUsername(username, password);
  return "welcomePrimefaces";
    //return validateUsernamePasswordHelper();
  }


  // Validate login helper
  public String validateUsernamePasswordHelper() {
    if (usuario != null) {
//      logger.debug("Es valido!!");
      HttpSession session = SessionBean.getSession();
      session.setAttribute("username", usuario.getUser());
      usuario.setLastLogin(new Date());
      try {
        usuariosFacade.edit(usuario);
      } catch (Exception e) {
//        logger.error("Error al editar usuario...");
      }
      return "dashboard";
    } else {
//      logger.debug("NO valido!!");
      JsfUtil.addErrorMessage(("usuario_password_incorrectos"),  ("ingrese_usuario_password_correctos"));
      return "login";
    }
  }

  // Logout, invalidate session
  public String logout() {
    HttpSession session = SessionBean.getSession();
    session.invalidate();
    usuario = null;
    return "login";
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
