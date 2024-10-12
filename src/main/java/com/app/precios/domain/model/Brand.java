package com.app.precios.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Objeto de dominio que representa una marca.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Brand {

  /**
   * Identificador único de la marca.
   */
  private Long id;

  /**
   * Nombre de la marca.
   */
  private String name;

}
