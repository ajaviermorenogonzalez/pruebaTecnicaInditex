package com.app.precios.domain.repository;

import com.app.precios.domain.model.Price;
import com.app.precios.infrastructure.output.jpa.entities.PriceEntity;
import java.time.LocalDateTime;
import java.util.Optional;

/**
 * Repositorio de metodos sobre precios.
 */
public interface PriceRepository {

  /**
   * Encuentra el primer precio aplicable para un producto y una marca dados, dentro de un
   * rango de fechas basado en la fecha de aplicación proporcionada.
   *
   * @param productId El identificador del producto para el que se busca el precio.
   * @param brandId El identificador de la marca asociada al producto.
   * @param applicationDate La fecha en la que se desea aplicar el precio, que debe estar
   *                        dentro del rango de fechas de vigencia del precio.
   * @return Un {@link Optional} que contiene el {@link PriceEntity} si se encuentra
   *         un precio aplicable; de lo contrario, devuelve un {@link Optional#empty()}.
   */
  Optional<Price> findFirstApplicablePrice(Long productId, Long brandId, LocalDateTime applicationDate);

}
