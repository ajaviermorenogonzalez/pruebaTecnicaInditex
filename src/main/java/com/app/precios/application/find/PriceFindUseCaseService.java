package com.app.precios.application.find;

import com.app.precios.domain.exceptions.PriceNotFoundException;
import com.app.precios.domain.model.Price;
import java.time.LocalDateTime;

/**
 * Interfaz que define las operaciones relacionadas la busqueda de precios.
 */

public interface PriceFindUseCaseService {

  /**
   * Encuentra el precio aplicable basado en el identificador de producto, el identificador de marca
   * y la fecha de aplicación. Si no se encuentra, lanza una {@link PriceNotFoundException}.
   *
   * @param productId El identificador del producto.
   * @param brandId El identificador de la marca.
   * @param applicationDate La fecha de aplicación del precio.
   * @return El precio encontrado como {@link Price}.
   * @throws PriceNotFoundException Si no se encuentra un precio aplicable.
   */
  Price findApplicablePrice(Long productId, Long brandId, LocalDateTime applicationDate)
      throws PriceNotFoundException;


}
