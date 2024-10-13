package com.app.precios.infrastructure.output.jpa.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.app.precios.infrastructure.output.jpa.entities.BrandEntity;
import com.app.precios.infrastructure.output.jpa.entities.PriceEntity;
import com.app.precios.infrastructure.output.jpa.entities.ProductEntity;
import jakarta.persistence.EntityManager;
import java.time.LocalDateTime;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class PriceJpaRepositoryTest {

  @Autowired
  private PriceJpaRepository priceJpaRepository;

  @Autowired
  private EntityManager entityManager;

  @BeforeEach
  void setUp() {
  }

  @Test
  @DisplayName("Test findFirstApplicablePrice: Petición a las 10:00 del día 14 del producto 35455 para la brand 1 (ZARA)")
  void testFindFirstApplicablePrice_Case1() {
    LocalDateTime applicationDate = LocalDateTime.of(2020, 6, 14, 10, 0);
    Optional<PriceEntity> result = priceJpaRepository.findFirstApplicablePrice(35455L, 1L, applicationDate);

    assertTrue(result.isPresent());
    assertEquals(35.50, result.get().getPrice());
    assertEquals(0, result.get().getPriority());
  }

  @Test
  @DisplayName("Test findFirstApplicablePrice: Petición a las 16:00 del día 14 del producto 35455 para la brand 1 (ZARA)")
  void testFindFirstApplicablePrice_Case2() {
    LocalDateTime applicationDate = LocalDateTime.of(2020, 6, 14, 16, 0);
    Optional<PriceEntity> result = priceJpaRepository.findFirstApplicablePrice(35455L, 1L, applicationDate);

    assertTrue(result.isPresent());
    assertEquals(25.45, result.get().getPrice());
    assertEquals(1, result.get().getPriority());
  }

  @Test
  @DisplayName("Test findFirstApplicablePrice: Petición a las 21:00 del día 14 del producto 35455 para la brand 1 (ZARA)")
  void testFindFirstApplicablePrice_Case3() {
    LocalDateTime applicationDate = LocalDateTime.of(2020, 6, 14, 21, 0);
    Optional<PriceEntity> result = priceJpaRepository.findFirstApplicablePrice(35455L, 1L, applicationDate);

    assertTrue(result.isPresent());
    assertEquals(35.50, result.get().getPrice());
    assertEquals(0, result.get().getPriority());
  }

  @Test
  @DisplayName("Test findFirstApplicablePrice: Petición a las 10:00 del día 15 del producto 35455 para la brand 1 (ZARA)")
  void testFindFirstApplicablePrice_Case4() {
    LocalDateTime applicationDate = LocalDateTime.of(2020, 6, 15, 10, 0);
    Optional<PriceEntity> result = priceJpaRepository.findFirstApplicablePrice(35455L, 1L, applicationDate);

    assertTrue(result.isPresent());
    assertEquals(30.50, result.get().getPrice());
    assertEquals(1, result.get().getPriority());
  }

  @Test
  @DisplayName("Test findFirstApplicablePrice: Petición a las 21:00 del día 16 del producto 35455 para la brand 1 (ZARA)")
  void testFindFirstApplicablePrice_Case5() {
    LocalDateTime applicationDate = LocalDateTime.of(2020, 6, 16, 21, 0);
    Optional<PriceEntity> result = priceJpaRepository.findFirstApplicablePrice(35455L, 1L, applicationDate);

    assertTrue(result.isPresent());
    assertEquals(38.95, result.get().getPrice());
    assertEquals(1, result.get().getPriority());
  }


}