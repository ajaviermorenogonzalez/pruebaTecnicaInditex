package com.app.precios.common.utils;

import lombok.experimental.UtilityClass;

/**
 * Utilidad para el manejo de logs, que proporciona métodos para obtener el nombre de la clase
 * y del metodo que está ejecutando el log.
 */
@UtilityClass
public class LogUtil {

  /**
   * Devuelve el nombre de la clase y el metodo desde donde se llama a este metodo.
   *
   * <p>Este metodo recorre la traza de la pila de llamadas y extrae la clase y el metodo
   * que están invocando el log, proporcionando un formato claro y estructurado que mejora
   * la legibilidad y la depuración del log.</p>
   *
   * @return Una cadena con el nombre de la clase y el metodo, en formato "ClassName.methodName".
   */

  public String getClassNameAndMethodName() {
    StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
    StackTraceElement element = stackTrace[2];
    return String.format("%s.%s", element.getClassName(), element.getMethodName());
  }
}

