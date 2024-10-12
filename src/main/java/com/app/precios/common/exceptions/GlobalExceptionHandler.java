package com.app.precios.common.exceptions;

import com.app.precios.domain.exceptions.PriceNotFoundException;
import com.app.precios.infrastructure.input.rest.dto.ErrorResponseDTO;
import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Controlador global de manejo de excepciones para toda la aplicación.
 *
 * <p>Este controlador captura excepciones específicas y globales que puedan ocurrir en los
 * controladores de la API, devolviendo una respuesta personalizada a los clientes.</p>
 */
@ControllerAdvice
public class GlobalExceptionHandler {

  /**
   * Maneja la excepción {@link PriceNotFoundException} que se lanza cuando no se encuentra un
   * precio.
   *
   * @param ex La excepción lanzada cuando no se encuentra el precio solicitado.
   * @return Una respuesta de error personalizada con el estado HTTP 404 (Not Found).
   */
  @ExceptionHandler(PriceNotFoundException.class)
  public ResponseEntity<ErrorResponseDTO> handlePriceNotFoundException(PriceNotFoundException ex) {
    ErrorResponseDTO errorResponse = new ErrorResponseDTO(
        LocalDateTime.now(),
        "Price Not Found",
        ex.getMessage()
    );
    return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
  }

  /**
   * Maneja cualquier excepción global que no sea específicamente capturada por otro manejador.
   *
   * @param ex La excepción lanzada de tipo genérico {@link Exception}.
   * @return Una respuesta de error personalizada con el estado HTTP 500 (Internal Server Error).
   */
  @ExceptionHandler(Exception.class)
  public ResponseEntity<ErrorResponseDTO> handleGlobalException(Exception ex) {
    ErrorResponseDTO errorResponse = new ErrorResponseDTO(
        LocalDateTime.now(),
        "Internal Server Error",
        ex.getMessage()
    );
    return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
  }

  /**
   * Maneja la excepción {@link MissingServletRequestParameterException} que se lanza cuando faltan
   * parámetros obligatorios en la solicitud.
   *
   * @param ex La excepción lanzada cuando falta un parámetro requerido en la solicitud.
   * @return Una respuesta de error personalizada con el estado HTTP 400 (Bad Request).
   */
  @ExceptionHandler(MissingServletRequestParameterException.class)
  public ResponseEntity<ErrorResponseDTO> handleGlobalException(
      MissingServletRequestParameterException ex) {
    ErrorResponseDTO errorResponse = new ErrorResponseDTO(
        LocalDateTime.now(),
        "Bad Request",
        ex.getMessage()
    );
    return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
  }
}
