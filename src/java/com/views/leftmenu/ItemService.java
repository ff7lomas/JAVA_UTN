package com.views.leftmenu;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;


/**
 *
 * @author Nahuel Rullo <nahuelrullo at gmail.com>
 */
//@ManagedBean(name = "itemService", eager = true)
@Named("itemService")
//@ViewScoped
@SessionScoped
//@ApplicationScoped
public class ItemService implements Serializable {

  private List<Item> items;
  
  @PostConstruct
  public void init() {
    
    items = new ArrayList<>();
    
//    List<UsuariosMenuopciones> ops = usuariosMenuopcionesFacade.findByIdUsuario(loginView.getUsuario());
    
//    int i = 0;
//    for (UsuariosMenuopciones op : ops) {
//      if (op.getIdOpcion().getTpoOpcion().equals(1)) {
//        continue;
//      } else {
//        items.add(
//          new Item(
//            i++, 
//            op.getIdOpcion().getName(), 
//            op.getIdOpcion().getName(), 
//            op.getIdOpcion().getUri(), 
//            (op.getIdOpcion().getTpoOpcion().equals(0)? op.getIdOpcion().getName() : op.getIdOpcion().getGroupName())
//          )
//        );
//      }
//    }
    
    items.add(new Item(0, "dashboard", "dashboard", "/dashboard.xhtml", "dashboard"));
    
    items.add(new Item(1, "materiales", "materiales", "/materiales/materiales.xhtml", "materiales"));
    
    items.add(new Item(2, "indicadores", "indicadores", "/insumos/indicadores-caja.xhtml", "insumos"));
    items.add(new Item(3, "insumos", "insumos", "/insumos/insumos.xhtml", "insumos"));
    
    items.add(new Item(4, "iniciar_lavado", "iniciar_lavado", "/lavado/iniciar-lavado.xhtml", "lavado"));
    items.add(new Item(5, "controlar_lavado", "controlar_lavado", "/lavado/controlar-lavado.xhtml", "lavado"));
    
    items.add(new Item(6, "acondicionamiento_materiales", "acondicionamiento_materiales", "/esterilizacion/paquetes.xhtml", "esterilizacion"));
    items.add(new Item(7, "iniciar_esterilizacion", "iniciar_esterilizacion", "/esterilizacion/sel_equipo.xhtml?action=30", "esterilizacion"));
    items.add(new Item(8, "controlar_proceso_esterilizacion", "controlar_proceso_esterilizacion", "/esterilizacion/sel_proceso_esterilizacion.xhtml", "esterilizacion"));
    items.add(new Item(9, "incubadoras", "incubadoras", "/esterilizacion/control_vivo.xhtml", "esterilizacion"));
    items.add(new Item(10, "rpe", "rpe", "/esterilizacion/sel_equipo.xhtml?action=32", "esterilizacion"));
    
    items.add(new Item(11, "iniciar_cirugia", "iniciar_cirugia", "/cirugia/iniciar-cirugia.xhtml", "cirugia"));
    
    items.add(new Item(12, "usuarios", "usuarios", "/datosgenerales/usuarios/usuarios.xhtml", "datos_generales"));
    items.add(new Item(13, "fabricantes", "fabricantes", "/datosgenerales/fabricantes/fabricantes.xhtml", "datos_generales"));
    items.add(new Item(14, "equipos", "equipos", "/datosgenerales/equipos/equipos.xhtml", "datos_generales"));
    
  }

  public List<Item> getItems() {
    init();
    return items;
  }

}
