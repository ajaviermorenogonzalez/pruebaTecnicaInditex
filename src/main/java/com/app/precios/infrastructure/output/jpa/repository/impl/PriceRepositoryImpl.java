package com.app.precios.infrastructure.output.jpa.repository.impl;

import com.app.precios.common.utils.LogUtil;
import com.app.precios.domain.model.Price;
import com.app.precios.domain.repository.PriceRepository;
import com.app.precios.infrastructure.output.jpa.mapper.PriceEntityMapper;
import com.app.precios.infrastructure.output.jpa.repository.PriceJpaRepository;
import java.time.LocalDateTime;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Implementacion de PriceRepository para la conexion con BBDD a través de JPA.
 *
 * <p>Esta clase contiene la lógica para realizar consultas avanzadas sobre la tabla de precios,
 * como encontrar el precio más aplicable basado en el identificador del producto, la marca y una
 * fecha de aplicación. Extiende las capacidades de los repositorios estándar de JPA.</p>
 */
@RequiredArgsConstructor
@Service
public class PriceRepositoryImpl implements PriceRepository {

  private final PriceJpaRepository priceJpaRepository;

  private final PriceEntityMapper priceEntityMapper;

  private static final Logger log = LoggerFactory.getLogger(PriceRepositoryImpl.class);

  /**
   * Encuentra el precio más aplicable para un producto y una marca específicos, dentro del rango de
   * fechas basado en la fecha de aplicación proporcionada.
   *
   * <p>La consulta selecciona el precio con mayor prioridad para la fecha de aplicación
   * especificada, si existe. De lo contrario, devuelve un {@link Optional#empty()}.</p>
   *
   * @param productId       El identificador del producto para el que se busca el precio.
   * @param brandId         El identificador de la marca asociada al producto.
   * @param applicationDate La fecha de aplicación para la cual se busca el precio.
   * @return Un {@link Optional} que contiene el {@link Price} si se encuentra un precio aplicable.
   */
  @Override
  public Optional<Price> findApplicablePrice(Long productId, Long brandId,
      LocalDateTime applicationDate) {

    log.info("{} Try to find applicable price", LogUtil.getClassNameAndMethodName());
    log.debug("{} Input data [productId: {}] [brandId: {}] [applicationDate: {}]",
        LogUtil.getClassNameAndMethodName(), productId, brandId, applicationDate);

    return priceJpaRepository.findFirstApplicablePrice(productId, brandId, applicationDate)
        .map(priceEntityMapper::toDomain);
  }
}
