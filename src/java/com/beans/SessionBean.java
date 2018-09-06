package com.beans;

import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Nahuel Rullo <nahuelrullo at gmail.com>
 */
public class SessionBean {

  public static HttpSession getSession() {
    return (HttpSession) FacesContext.getCurrentInstance()
            .getExternalContext().getSession(false);
  }

  public static HttpServletRequest getRequest() {
    return (HttpServletRequest) FacesContext.getCurrentInstance()
            .getExternalContext().getRequest();
  }

  public static String getUserName() {
    HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
            .getExternalContext().getSession(false);
    return session.getAttribute("username").toString();
  }

  public static String getUserId() {
    HttpSession session = getSession();
    if (session != null) {
      return (String) session.getAttribute("userid");
    } else {
      return null;
    }
  }

//  public void checkPermissions(ComponentSystemEvent event) {
//    FacesContext fc = FacesContext.getCurrentInstance();
//    HttpSession httpSession = (HttpSession) (fc.getExternalContext().getSession(
//                                             false));
//    String cid = (String) httpSession.getAttribute(
//            AttributeName.ADMINISTRATOR_CLIENT_LOGIN_ID);
//    if (cid == null) {
//      ConfigurableNavigationHandler handler
//                                            = (ConfigurableNavigationHandler) fc.
//              getApplication().getNavigationHandler();
//      handler.performNavigation(this.navi.getClientLogin().getLink());
//      return;
//    }
//  }

}
