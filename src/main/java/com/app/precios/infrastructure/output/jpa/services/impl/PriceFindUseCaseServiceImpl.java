package com.app.precios.infrastructure.output.jpa.services.impl;

import com.app.precios.application.find.PriceFindUseCaseService;
import com.app.precios.common.utils.LogUtil;
import com.app.precios.domain.exceptions.PriceNotFoundException;
import com.app.precios.domain.model.Price;
import com.app.precios.domain.repository.PriceRepository;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Implementación de los metodos relacionados con la busqueda de precios.
 */
@Service
@RequiredArgsConstructor
public class PriceFindUseCaseServiceImpl implements PriceFindUseCaseService {

  private final PriceRepository priceRepository;
  private static final Logger log = LoggerFactory.getLogger(PriceFindUseCaseServiceImpl.class);

  /**
   * {@inheritDoc}
   */
  @Override
  public Price findApplicablePrice(Long productId, Long brandId, LocalDateTime applicationDate)
      throws PriceNotFoundException {

    log.info("{} Try to find applicable price", LogUtil.getClassNameAndMethodName());
    log.debug("{} Input data [productId: {}] [brandId: {}] [applicationDate: {}]",
        LogUtil.getClassNameAndMethodName(), productId, brandId, applicationDate);

    return priceRepository.findFirstApplicablePrice(productId, brandId, applicationDate)
        .orElseThrow(() -> new PriceNotFoundException("Price not found for product " + productId
            + " and brand " + brandId
            + " and application date " + applicationDate));
  }

}
