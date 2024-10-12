package com.app.precios.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Objeto de dominio que representa un producto.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {

  /**
   * Identificador único del producto.
   */
  private Long id;

}
