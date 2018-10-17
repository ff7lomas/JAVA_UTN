package com.utils;

/**
 *
 * @author jsturla
 */
public final class Consts {

  public static final int MOVIMIENTO_ENTRADA = 0;
  public static final int MOVIMIENTO_SALIDA = 1;

  public static final int ESTADO_MATERIAL_FUERA= 1;
  public static final int ESTADO_MATERIAL_INGRESADO = 2;
  public static final int ESTADO_MATERIAL_PREPARADO = 3;
  public static final int ESTADO_MATERIAL_ESTERILIZADO = 4;

  public static final int ESTADO_ESTERILIZACION_PENDIENTE_CONTROL = 1;
  public static final int ESTADO_ESTERILIZACION_PARCIALMENTE_CONTROLADO = 2;
  public static final int ESTADO_ESTERILIZACION_EXITOSO = 3;
  public static final int ESTADO_ESTERILIZACION_CONTAMINADO = 4;
  public static final int ESTADO_ESTERILIZACION_NO_CONTROLADO = 5;
  public static final int ESTADO_ESTERILIZACION_EN_CURSO = 6;
  
  public static final int ESTADO_PAQUETE_PREPARADO = 4;
  public static final int ESTADO_PAQUETE_ESTERILIZADO = 5;
  public static final int ESTADO_PAQUETE_CONTROLADO = 6;
  public static final int ESTADO_PAQUETE_BAJA = 7;
  public static final int ESTADO_PAQUETE_EN_ESTERILIZACION = 8;
  public static final int ESTADO_PAQUETE_DISPONIBLE = 9;
  public static final int ESTADO_PAQUETE_SIN_CONTROL = 10;
  public static final int ESTADO_PAQUETE_PARCIALMENTE_CONTROLADO = 11;
  
  public static final int REGISTRO_HABILITADO=0;
  
  private Consts() {
    throw new AssertionError();
  }

}
