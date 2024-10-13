package com.app.precios.domain.model;

import com.app.precios.domain.enums.Currency;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Data;

/**
 * Objeto de dominio que representa el precio de un producto para una marca.
 */
@Data
@Builder
public class Price {

  /**
   * Identificador único del precio.
   */
  private Long id;

  /**
   * Producto al que se aplica este precio.
   *
   * <p>Referencia a la entidad {@link Product} que representa el producto.</p>
   */
  private Product product;

  /**
   * Marca asociada a este precio.
   *
   * <p>Referencia a la entidad {@link Brand} que representa la marca.</p>
   */
  private Brand brand;

  /**
   * Valor del precio aplicado al producto.
   */
  private Double price;

  /**
   * Moneda en la que está expresado el precio.
   *
   * <p>Utiliza el enum {@link Currency} para representar la moneda.</p>
   */
  private Currency currency;

  /**
   * Prioridad del precio en caso de que haya varias tarifas aplicables.
   *
   * <p>Los precios con una prioridad más alta (mayor número) tienen preferencia sobre
   * los de menor prioridad.</p>
   */
  private Integer priority;

  /**
   * Identificador de la lista de precios (tarifa) a la que pertenece este precio.
   */
  private Integer priceList;

  /**
   * Fecha de inicio de la vigencia del precio.
   */
  private LocalDateTime startDate;

  /**
   * Fecha de finalización de la vigencia del precio.
   */
  private LocalDateTime endDate;

}
