package com.utils;

/**
 *
 * @author Nahuel Rullo <nahuelrullo at gmail.com>
 */
public final class Consts {

  public static final String ENTIDAD_USUARIO = "001";
  public static final String ENTIDAD_EQUIPO = "002";
  public static final String ENTIDAD_MATERIAL = "003";
  public static final String ENTIDAD_INSUMO = "004";
  public static final String ENTIDAD_PAQUETE = "005";
  public static final String ENTIDAD_FABRICANTE = "006";
  public static final String ENTIDAD_INDICADOR = "007";
  public static final String ENTIDAD_REMITO = "008";
  public static final String ENTIDAD_KIT = "009";
  public static final String ENTIDAD_LOTECAJA = "010";
  public static final String ENTIDAD_IP_SRV = "011";
  public static final String ENTIDAD_ALMACEN = "012";
  public static final String ENTIDAD_PACIENTE = "013";
  public static final String ENTIDAD_CIRUGIA = "014";
  public static final String ENTIDAD_INDICADOR_HIGIENE = "015";
  

  public static final int ESTADO_MATERIAL_CONTAMINADO = 1;
  public static final int ESTADO_MATERIAL_LAVADO = 2;
  public static final int ESTADO_MATERIAL_CONTROL_LAVADO = 3;
  public static final int ESTADO_MATERIAL_PREPARADO = 4;
  public static final int ESTADO_MATERIAL_ESTERILIZADO = 5;
  public static final int ESTADO_MATERIAL_CONTROLADO = 6;
  public static final int ESTADO_MATERIAL_BAJA = 7;
  public static final int ESTADO_MATERIAL_EN_LAVADO = 8;
  public static final int ESTADO_MATERIAL_EN_ESTERILIZACION = 9;
  public static final int ESTADO_MATERIAL_NO_DISPONIBLE = 10;
  public static final int ESTADO_MATERIAL_NO_CONTROLADO = 11;
  public static final int ESTADO_MATERIAL_PARCIALMENTE_CONTROLADO = 12;
  public static final int ESTADO_MATERIAL_DISPONIBLE = 13;

  public static final int ESTADO_INDICADOR_HABILITADO = 1;
  public static final int ESTADO_INDICADOR_UTILIZADO = 2;
  public static final int ESTADO_INDICADOR_VENCIDO = 3;
  public static final int ESTADO_INDICADOR_FINALIZADO = 4;
  public static final int ESTADO_INDICADOR_CONTROLADO = 5;
  public static final int ESTADO_INDICADOR_LEYENDO = 6;
  public static final int ESTADO_INDICADOR_LEIDO = 7;

  public static final String COLOR_ESTADO_INDICADOR_HABILITADO = "#000000";
  public static final String COLOR_ESTADO_INDICADOR_UTILIZADO = "#9a4996";
  public static final String COLOR_ESTADO_INDICADOR_VENCIDO = "#000000";
  public static final String COLOR_ESTADO_INDICADOR_FINALIZADO = "#000000";
  public static final String COLOR_ESTADO_INDICADOR_CONTROLADO = "#000000";
  public static final String COLOR_ESTADO_INDICADOR_LEYENDO = "#000000";
  public static final String COLOR_ESTADO_INDICADOR_LEIDO = "#000000";

  public static final int RESULTADO_CONTROL_INDICADOR_SIN_RESULTADO = 1;
  public static final int RESULTADO_CONTROL_INDICADOR_POSITIVO = 2;
  public static final int RESULTADO_CONTROL_INDICADOR_NEGATIVO = 3;
  public static final int RESULTADO_CONTROL_INDICADOR_CANCELADO = 4;
  public static final int RESULTADO_CONTROL_INDICADOR_SAFE = 5;
  public static final int RESULTADO_CONTROL_INDICADOR_UNSAFE = 6;
  public static final int RESULTADO_CONTROL_INDICADOR_EXTENDED = 7;

  public static final String COLOR_RESULTADO_CONTROL_INDICADOR_SIN_RESULTADO = "#000000";
  public static final String COLOR_RESULTADO_CONTROL_INDICADOR_POSITIVO = "#e62039";
  public static final String COLOR_RESULTADO_CONTROL_INDICADOR_NEGATIVO = "#84bc25";
  public static final String COLOR_RESULTADO_CONTROL_INDICADOR_CANCELADO = "#e58709";

  public static final int ESTADO_ESTERILIZACION_PENDIENTE_CONTROL = 1;
  public static final int ESTADO_ESTERILIZACION_PARCIALMENTE_CONTROLADO = 2;
  public static final int ESTADO_ESTERILIZACION_EXITOSO = 3;
  public static final int ESTADO_ESTERILIZACION_CONTAMINADO = 4;
  public static final int ESTADO_ESTERILIZACION_NO_CONTROLADO = 5;
  public static final int ESTADO_ESTERILIZACION_EN_CURSO = 6;
  
  public static final int ESTADO_CIRUGIA_PENDIENTE_CONTROL = 1;
  public static final int ESTADO_CIRUGIA_PARCIALMENTE_CONTROLADO = 2;
  public static final int ESTADO_CIRUGIA_EXITOSO = 3;
  public static final int ESTADO_CIRUGIA_FALLIDO = 4;
  public static final int ESTADO_CIRUGIA_SIN_CONTROL = 5;
  
  public static final int ESTADO_LAVADO_PENDIENTE_CONTROL = 1;
  public static final int ESTADO_LAVADO_SIN_EXITO=2;
  public static final int ESTADO_LAVADO_EXITOSO = 3;
  public static final int ESTADO_LAVADO_PARCIALMENTE_CONTROLADO = 4;
  public static final int ESTADO_LAVADO_NO_CONTROLADO = 6;
  public static final int ESTADO_LAVADO_EN_CURSO = 5;

  public static final int ESTADO_PAQUETE_PREPARADO = 4;
  public static final int ESTADO_PAQUETE_ESTERILIZADO = 5;
  public static final int ESTADO_PAQUETE_CONTROLADO = 6;
  public static final int ESTADO_PAQUETE_BAJA = 7;
  public static final int ESTADO_PAQUETE_EN_ESTERILIZACION = 8;
  public static final int ESTADO_PAQUETE_DISPONIBLE = 9;
  public static final int ESTADO_PAQUETE_SIN_CONTROL = 10;
  public static final int ESTADO_PAQUETE_PARCIALMENTE_CONTROLADO = 11;
  
  public static final int ESTADO_PROCESO_HIGIENE_PREPARADO = 1;
  public static final int ESTADO_PROCESO_HIGIENE_EN_CURSO = 2;
  public static final int ESTADO_PROCESO_HIGIENE_FINALIZADO = 3;

  public static final int INDICADOR_SCBI_NO_EXPUESTO = 0;
  public static final int INDICADOR_SCBI_EXPUESTO = 1;

  public static final int INDICADOR_PUNTAJE_ALTO = 10;
  public static final int INDICADOR_PUNTAJE_MEDIO = 30;
  public static final int INDICADOR_PUNTAJE_BAJO = 60;
  public static final int INDICADOR_PUNTAJE_NULO = 101;

  public static final int INDICADOR_TIPO_BIOLOGICO = 1;
  public static final int INDICADOR_TIPO_QUIM_LAVADO = 2;
  public static final int INDICADOR_TIPO_QUIM_ESTERIL = 3;
  public static final int INDICADOR_TIPO_HIGIENE = 4;
  
  public static final int TIPO_MONITOREO_CUANTITATIVO = 1;
  public static final int TIPO_MONITOREO_IQAS = 2;
  
  
  public static final int RPE_ALTO = 33;
  public static final int RPE_MEDIO = 66;
  public static final int RPE_BAJO = 100;
  public static final int RPE_NULO = 115;

  public static final int ACTION_INICIAR_ESTERILIZACION = 30;
  public static final int ACTION_CONTROLAR_ESTERILIZACION = 31;
  public static final int ACTION_RPE = 32;
  public static final int ACTION_INICIAR_LAVADO = 33;

  public static final int EQUIPO_TIPO_ESTERILIZADOR = 1;
  public static final int EQUIPO_TIPO_INCUBADORA = 2;
  public static final int EQUIPO_TIPO_LAVADOR = 3;
  public static final int EQUIPO_TIPO_EMPAQUETADORA = 4;

  public static final int REMITO_TIPO_RECEPCION = 1;
  public static final int REMITO_TIPO_ENTREGA = 2;
  
  public static final int REMITO_ANCHO_PAGINA_A4 = 595;
  public static final int REMITO_ALTO_PAGINA_A4 = 841;
  
  public static final int REGISTRO_HABILITADO = 0;
  public static final int REGISTRO_DESHABILITADO = 1;
  
  public static final String CODIGO_ALMACEN_CENTRAL = "almacenCentral";
    public static final String CODIGO_ALMACEN_QUIROFANO = "Quirofano";   //temporal juan

  public static final String JASYPT_PASSWD = "vdm308";

  // Group Separator
  public static final String GS = "\u001D";

  // Marca lote indicadores
  public static final String MARCA_LOTE = "BIONOVA";

  // Prefijos de los campos de un DM
  public static final String DM_PREFIX_GTIN = "01";
  public static final String DM_PREFIX_VENCIMIENTO = "17";
  public static final String DM_PREFIX_FABRICACION = "11";
  public static final String DM_PREFIX_EMPRESA = "251";
  public static final String DM_PREFIX_MARCA = "91";
  public static final String DM_PREFIX_CODPRODUCTO = "240";
  public static final String DM_PREFIX_LOTE = "10";
  public static final String DM_PREFIX_POBLACION = "93";
  public static final String DM_PREFIX_CONDEXPVALORD = "94";
  public static final String DM_PREFIX_VALORD = "92";
  public static final String DM_PREFIX_NROSERIECAJA = "250";
  public static final String DM_PREFIX_NROSERIE = "21";
  public static final String DM_PREFIX_IDENTIDAD = "99";

  public static final String PRODUCTO_NOM_BASE_BT110 = "BT110";
  public static final String PRODUCTO_NOM_BASE_BT220 = "BT220";
  public static final String PRODUCTO_NOM_BASE_BT221 = "BT221";
  public static final String PRODUCTO_NOM_BASE_BT222 = "BT222";
  public static final String PRODUCTO_NOM_BASE_BT223 = "BT223";
  public static final String PRODUCTO_NOM_BASE_BT224 = "BT224";
  public static final String PRODUCTO_NOM_BASE_BT20 = "BT20";

  public static final int WS_OP_RESULTADO_OK = 0;
  public static final int WS_OP_RESULTADO_ERROR = -1;
  public static final int WS_OP_RESULTADO_OK_NOT_EXPECTED = 1;

  public static final int MENUOP_TIPO_FATHER = 1;
  public static final int MENUOP_TIPO_LINK = 2;

  public static final int IND_RES_GAUGE_ALTO = 5;
  public static final int IND_RES_GAUGE_MEDIO = 10;
  public static final int IND_RES_GAUGE_BAJO = 100;

  public static final int MATERIAL_INGRESA = 0;
  public static final int MATERIAL_NO_INGRESA = 1;
  
  public static final int EVENTO_TIPO_INGRESO_MATERIAL_CENTRAL = 1;
  public static final int EVENTO_TIPO_INICIO_LAVADO = 2;
  public static final int EVENTO_TIPO_REGISTRO_INCIDENCIA_LAVADO = 3;
  public static final int EVENTO_TIPO_REGISTRO_INCIDENCIA_ACONDICIONAMIENTO = 4;
  public static final int EVENTO_TIPO_REGISTRO_INCIDENCIA_ESTERILIZACION = 5;
  public static final int EVENTO_TIPO_FIN_LAVADO = 6;
  public static final int EVENTO_TIPO_ARMADO_PAQUETE = 7;
  public static final int EVENTO_TIPO_BAJA_INSTRUMENTO = 8;
  public static final int EVENTO_TIPO_INICIO_PROCESO_ESTERILIZACION = 9;
  public static final int EVENTO_TIPO_FIN_PROCESO_ESTERILIZACION = 10;
  public static final int EVENTO_TIPO_INICIO_CONTROL_IB = 11;
  public static final int EVENTO_TIPO_RESULTADO_CONTROL_IB = 12;
  public static final int EVENTO_TIPO_CAMBIO_ESTADO_MATERIAL = 13;
  public static final int EVENTO_TIPO_VENCIMIENTO_INDICADORES = 14;
  public static final int EVENTO_TIPO_NIVELES_STOCK = 15;
  public static final int EVENTO_TIPO_RETIRO_MATERIAL_CENTRAL = 16;
  public static final int EVENTO_TIPO_ALTA_INDICADORES = 17;
  public static final int EVENTO_TIPO_ALTA_MATERIAL = 18;
  public static final int EVENTO_TIPO_ALTA_EQUIPO = 19;
  public static final int EVENTO_TIPO_INICIO_CIRUGIA = 20;
  private Consts() {
    throw new AssertionError();
  }

}
