package com.app.precios.infrastructure.input.rest.impl;

import com.app.precios.application.find.PriceFindUseCaseService;
import com.app.precios.common.utils.LogUtil;
import com.app.precios.infrastructure.input.rest.PricesApiDelegate;
import com.app.precios.infrastructure.input.rest.dto.PriceResponseDTO;
import com.app.precios.infrastructure.input.rest.mapper.PriceDtoMapper;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * Implementación de la interfaz {@link PricesApiDelegate} para manejar las peticiones de precios.
 *
 * <p>Esta clase actúa como el punto de entrada de las solicitudes relacionadas con los precios.</p>
 */

@Service
@RequiredArgsConstructor
public class PricesApiDelegateImpl implements PricesApiDelegate {

  private final PriceFindUseCaseService priceFindUseCaseService;

  private final PriceDtoMapper priceDtoMapper;

  private static final Logger log = LoggerFactory.getLogger(PricesApiDelegateImpl.class);

  @Override
  public ResponseEntity<PriceResponseDTO> findFirstApplicablePrice(Long productId, Long brandId,
      LocalDateTime applicationDate) throws Exception {

    log.info("{} Try to find applicable price", LogUtil.getClassNameAndMethodName());
    log.debug("{} Input data [productId: {}] [brandId: {}] [applicationDate: {}]",
        LogUtil.getClassNameAndMethodName(), productId, brandId, applicationDate);

    return new ResponseEntity<>(priceDtoMapper.toPriceResponseDto(priceFindUseCaseService
        .findApplicablePrice(productId, brandId, applicationDate)), HttpStatus.OK);

  }
}
