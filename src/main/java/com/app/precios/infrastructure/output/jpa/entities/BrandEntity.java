package com.app.precios.infrastructure.output.jpa.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entidad que representa la tabla de marcas en la base de datos.
 **
 * <p>Está mapeada a la tabla {@code brands} en la base de datos.</p>
 */
@Entity
@Data
@Table(name = "brands")
@NoArgsConstructor
@AllArgsConstructor
public class BrandEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;

  @Column(nullable = false)
  private String name;

}
