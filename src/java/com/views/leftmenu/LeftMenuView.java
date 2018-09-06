package com.views.leftmenu;

import com.entidades.Menuopciones;
import com.entidades.Usuarios;
import com.utils.Utils;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import org.primefaces.event.SelectEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

//@ManagedBean
@Named("leftMenuView")
@ViewScoped
//@SessionScoped
public class LeftMenuView implements Serializable {

//  private static final org.apache.logging.log4j.Logger logger
//                                                               = org.apache.logging.log4j.LogManager.
//          getLogger("LeftMenuView");

  private Item item;
  private String menu = null;

  @EJB
  private com.facades.UsuariosMenuopcionesFacade usuariosMenuopcionesFacade;

  @EJB
  private com.facades.MenuopcionesFacade menuopcionesFacade;
//  private List<Menuopciones> menuopciones = null;

//  @ManagedProperty("#{itemService}")
  @Inject
  private ItemService itemService;

  @PostConstruct
  public void init() {

  }

  public List<Item> completeItem(String query) {
    List<Item> allItems = itemService.getItems();
    List<Item> filteredItems = new ArrayList<>();

    for (int i = 0; i < allItems.size(); i++) {
      Item skin = allItems.get(i);
      if (skin.getName().toLowerCase().contains(query)) {
        filteredItems.add(skin);
      }
    }

    return filteredItems;
  }
  
  public boolean opcionHabilitada(Usuarios idUsuario, Integer idOpcion) {
    return usuariosMenuopcionesFacade.isOpHabilitadaByIdUsuarioAndIdOpcion(idUsuario, idOpcion);
  }

  public char getItemsGroup(Item item) {
    return item.getDisplayName().charAt(0);
  }

  public Item getItem() {
    return item;
  }

  public void setItem(Item item) {
    this.item = item;
  }

  public void setItemService(ItemService itemService) {
    this.itemService = itemService;
  }

  public char getItemGroup(Item item) {
    return item.getDisplayName().charAt(0);
  }

  public void onItemSelect(SelectEvent event) throws IOException {
    Item itemSelected = (Item) event.getObject();

    ExternalContext ec = FacesContext.getCurrentInstance().
            getExternalContext();
    ec.redirect(ec.getRequestContextPath()
                        + itemSelected.getUriAction());
  }

//  public List<Menuopciones> getMenuopciones() {
//    if (menuopciones == null) {
//      menuopciones = menuopcionesFacade.findAll();
//    }
//
//    return menuopciones;
//  }
  public String getMenu() {

    if (menu == null) {
      menu = "<ul id=\"sm_leftmenu_b\" class=\"layout-menubar-container\">";

      List<Menuopciones> menuopciones = menuopcionesFacade.findAll("idOpcion");
      Integer opAnterior = -1;
      for (Menuopciones menuopcion : menuopciones) {
//        logger.debug("menuopcion.getName(): " + menuopcion.getName());

        if (menuopcion.getTpoOpcion() == 0) {
          if (opAnterior == 2) {
            menu += "</ul>";
            menu += "</li>";
          }

          menu += "<li id=\"sm_" + menuopcion.getName()
                          + "_0\" role=\"menuitem\">";
          menu += "<a href=\"/T-Matrix" + menuopcion.getUri()
                          + "\" onclick=\"Sentinel.toggleSubMenu(this)\"><i class=\""
                  + menuopcion.getIcon() + " yellow i\"></i> " + (menuopcion.getName()) + "</a>";
          menu += "</li>";
          opAnterior = 0;
        }

        if (menuopcion.getTpoOpcion() == 1) {
          if (opAnterior == 2) {
            menu += "</ul>";
            menu += "</li>";
          }

          menu += "<li id=\"sm_" + menuopcion.getName()
                          + "_1\" role=\"menuitem\">";
          menu
                  += "<a href=\"#\" onclick=\"Sentinel.toggleSubMenu(this);return false;\"><i class=\""
                     + menuopcion.getIcon() + " yellow i\"></i>"
                             + (menuopcion.getName())
                             + "<i class=\"icon-angle-down Fright\"></i></a>";
          menu
                  += "<ul class=\"layout-menubar-submenu-container\" role=\"menu\">";
          opAnterior = 1;
        }

        if (menuopcion.getTpoOpcion() == 2) {
          menu += "<li id=\"sm_" + menuopcion.getName()
                          + "_2\" role=\"menuitem\">";
          menu += "<a class=\"marginLevel-1\" href=\"/T-Matrix" + menuopcion.
                  getUri() + "\"><i class=\"" + menuopcion.getIcon()
                          + " yellow i\"></i> " + (menuopcion.getName()) + "</a>";
          menu += "</li>";
          opAnterior = 2;
        }

      }

      if (opAnterior == 2) {
        menu += "</ul>";
        menu += "</li>";
      }
//      menu += "</ul>";
//      menu += "</li>";
      menu += "</ul>";
    }

    return menu;

  }

}
