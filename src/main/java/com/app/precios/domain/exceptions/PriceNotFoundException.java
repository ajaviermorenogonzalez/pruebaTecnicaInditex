package com.app.precios.domain.exceptions;

/**
 * Excepción lanzada cuando no se encuentra un precio.
 */
public class PriceNotFoundException extends RuntimeException {

  /**
   * Constructor de la excepción que acepta un mensaje.
   *
   * @param message El mensaje de error.
   */
  public PriceNotFoundException(String message) {
    super(message);
  }


}
