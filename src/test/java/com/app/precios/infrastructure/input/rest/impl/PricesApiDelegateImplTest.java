package com.app.precios.infrastructure.input.rest.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.app.precios.infrastructure.input.rest.dto.PriceResponseDTO;
import java.time.LocalDateTime;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest
class PricesApiDelegateImplTest {

  @Autowired
  private PricesApiDelegateImpl pricesApiDelegate;

  @Test
  @DisplayName("Test 1: Petición a las 10:00 del día 14 del producto 35455 para la brand 1 (ZARA)")
  void testFindApplicablePrice_Case1() throws Exception {
    Long productId = 35455L;
    Long brandId = 1L;
    LocalDateTime applicationDate = LocalDateTime.of(2020, 6, 14, 10, 0);

    ResponseEntity<PriceResponseDTO> response = pricesApiDelegate.findFirstApplicablePrice(productId, brandId, applicationDate);

    assertEquals(HttpStatus.OK, response.getStatusCode());
    assertNotNull(response.getBody());
    assertEquals(35.50, response.getBody().getPrice());
    assertEquals(1, response.getBody().getBrandId());
    assertEquals(35455, response.getBody().getProductId());
  }

  @Test
  @DisplayName("Test 2: Petición a las 16:00 del día 14 del producto 35455 para la brand 1 (ZARA)")
  void testFindApplicablePrice_Case2() throws Exception {
    Long productId = 35455L;
    Long brandId = 1L;
    LocalDateTime applicationDate = LocalDateTime.of(2020, 6, 14, 16, 0);

    ResponseEntity<PriceResponseDTO> response = pricesApiDelegate.findFirstApplicablePrice(productId, brandId, applicationDate);

    assertEquals(HttpStatus.OK, response.getStatusCode());
    assertNotNull(response.getBody());
    assertEquals(25.45, response.getBody().getPrice());
    assertEquals(1, response.getBody().getBrandId());
    assertEquals(35455, response.getBody().getProductId());
  }

  @Test
  @DisplayName("Test 3: Petición a las 21:00 del día 14 del producto 35455 para la brand 1 (ZARA)")
  void testFindApplicablePrice_Case3() throws Exception {
    Long productId = 35455L;
    Long brandId = 1L;
    LocalDateTime applicationDate = LocalDateTime.of(2020, 6, 14, 21, 0);

    ResponseEntity<PriceResponseDTO> response = pricesApiDelegate.findFirstApplicablePrice(productId, brandId, applicationDate);

    assertEquals(HttpStatus.OK, response.getStatusCode());
    assertNotNull(response.getBody());
    assertEquals(35.50, response.getBody().getPrice());
    assertEquals(1, response.getBody().getBrandId());
    assertEquals(35455, response.getBody().getProductId());
  }

  @Test
  @DisplayName("Test 4: Petición a las 10:00 del día 15 del producto 35455 para la brand 1 (ZARA)")
  void testFindApplicablePrice_Case4() throws Exception {
    Long productId = 35455L;
    Long brandId = 1L;
    LocalDateTime applicationDate = LocalDateTime.of(2020, 6, 15, 10, 0);

    ResponseEntity<PriceResponseDTO> response = pricesApiDelegate.findFirstApplicablePrice(productId, brandId, applicationDate);

    assertEquals(HttpStatus.OK, response.getStatusCode());
    assertNotNull(response.getBody());
    assertEquals(30.50, response.getBody().getPrice());
    assertEquals(1, response.getBody().getBrandId());
    assertEquals(35455, response.getBody().getProductId());
  }

  @Test
  @DisplayName("Test 5: Petición a las 21:00 del día 16 del producto 35455 para la brand 1 (ZARA)")
  void testFindApplicablePrice_Case5() throws Exception {
    Long productId = 35455L;
    Long brandId = 1L;
    LocalDateTime applicationDate = LocalDateTime.of(2020, 6, 16, 21, 0);

    ResponseEntity<PriceResponseDTO> response = pricesApiDelegate.findFirstApplicablePrice(productId, brandId, applicationDate);

    assertEquals(HttpStatus.OK, response.getStatusCode());
    assertNotNull(response.getBody());
    assertEquals(38.95, response.getBody().getPrice());
    assertEquals(1, response.getBody().getBrandId());
    assertEquals(35455, response.getBody().getProductId());
  }

}