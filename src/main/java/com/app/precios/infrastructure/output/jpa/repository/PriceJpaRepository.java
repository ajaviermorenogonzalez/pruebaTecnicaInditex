package com.app.precios.infrastructure.output.jpa.repository;

import com.app.precios.infrastructure.output.jpa.entities.PriceEntity;
import java.time.LocalDateTime;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Repositorio para gestionar las operaciones sobre la entidad {@link PriceEntity}.
 */
@Repository
public interface PriceJpaRepository extends JpaRepository<PriceEntity, Long> {

  /**
   * Encuentra el primer precio aplicable para un producto y una marca dados, dentro de un
   * rango de fechas basado en la fecha de aplicación proporcionada.
   *
   * <p>Este metodo selecciona el precio con mayor prioridad (ordenado de forma descendente)
   * que esté vigente en la fecha de aplicación dada.</p>
   *
   * @param productId El identificador del producto para el que se busca el precio.
   * @param brandId El identificador de la marca asociada al producto.
   * @param applicationDate La fecha en la que se desea aplicar el precio, que debe estar
   *                        dentro del rango de fechas de vigencia del precio.
   * @return Un {@link Optional} que contiene el {@link PriceEntity} si se encuentra
   *         un precio aplicable; de lo contrario, devuelve un {@link Optional#empty()}.
   */
  @Query("SELECT p FROM PriceEntity p JOIN FETCH p.brand WHERE p.product.id = :productId "
      + "AND p.brand.id = :brandId " + "AND :applicationDate BETWEEN p.startDate AND p.endDate "
      + "ORDER BY p.priority DESC " + "LIMIT 1")
  Optional<PriceEntity> findFirstApplicablePrice(Long productId, Long brandId,
      LocalDateTime applicationDate);

}
