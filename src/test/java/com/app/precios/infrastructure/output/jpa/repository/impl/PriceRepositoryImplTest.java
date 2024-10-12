package com.app.precios.infrastructure.output.jpa.repository.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.app.precios.domain.model.Price;
import java.time.LocalDateTime;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PriceRepositoryImplTest {

  @Autowired
  private PriceRepositoryImpl priceRepositoryImpl;

  @BeforeEach
  void setUp() {
  }

  @Test
  @DisplayName("OK_FindApplicablePrice")
  void test_when_valid_data_returns_price() {

    /**
     *  BRAND_ID:       1
     *  START_DATE:     2020-06-14-00.00.00
     *  END_DATE:       2020-12-31-23.59.59
     *  PRICE_LIST:     1
     *  PRODUCT_ID:     35455
     *  PRIORITY:       0
     *  PRICE:          35.50
     *  CURR:           EUR
     */

    LocalDateTime applicationDate = LocalDateTime.of(2020, 6, 14, 13, 0);
    Long productId = 35455L;
    Long brandId = 1L;

    Optional<Price> result = priceRepositoryImpl.findFirstApplicablePrice(productId, brandId,
        applicationDate);

    // Verificar que el resultado no sea vacío
    assertTrue(result.isPresent());

    // Verificar los datos de la entidad Price obtenida
    Price price = result.get();
    assertEquals(1L, price.getBrand().getId());
    assertEquals(35455L, price.getProduct().getId());
    assertEquals(35.50, price.getPrice());
    assertEquals(LocalDateTime.of(2020, 6, 14, 0, 0), price.getStartDate());
    assertEquals(LocalDateTime.of(2020, 12, 31, 23, 59, 59), price.getEndDate());
  }

  @Test
  @DisplayName("KO_NonExistentBrand")
  void tet_when_non_existent_brand_returns_empty_price() {

    LocalDateTime applicationDate = LocalDateTime.of(2020, 6, 14, 13, 0);
    Long productId = 35455L;
    Long brandId = 2L;

    Optional<Price> result = priceRepositoryImpl.findFirstApplicablePrice(productId, brandId,
        applicationDate);

    // Verificar que el resultado sea vacío
    assertTrue(result.isEmpty());

  }

}
