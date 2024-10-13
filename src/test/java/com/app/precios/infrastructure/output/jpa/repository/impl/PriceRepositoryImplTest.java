package com.app.precios.infrastructure.output.jpa.repository.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import com.app.precios.domain.model.Brand;
import com.app.precios.domain.model.Price;
import com.app.precios.domain.model.Product;
import com.app.precios.infrastructure.output.jpa.entities.BrandEntity;
import com.app.precios.infrastructure.output.jpa.entities.PriceEntity;
import com.app.precios.infrastructure.output.jpa.entities.ProductEntity;
import com.app.precios.infrastructure.output.jpa.mapper.PriceEntityMapper;
import com.app.precios.infrastructure.output.jpa.repository.PriceJpaRepository;
import java.time.LocalDateTime;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class PriceRepositoryImplTest {

  @Mock
  private PriceJpaRepository priceJpaRepository;

  @Mock
  private PriceEntityMapper priceEntityMapper;

  @InjectMocks
  private PriceRepositoryImpl priceRepositoryImpl;

  @Test
  @DisplayName("OK_FindApplicablePrice")
  void test_when_valid_data_returns_price() {

    LocalDateTime applicationDate = LocalDateTime.of(2020, 6, 14, 13, 0);
    Long productId = 35455L;
    Long brandId = 1L;

    PriceEntity mockPriceEntity = PriceEntity.builder()
        .id(1L)
        .brand(new BrandEntity(1L, "ZARA"))
        .product(new ProductEntity(35455L))
        .price(35.50)
        .startDate(LocalDateTime.of(2020, 6, 14, 0, 0))
        .endDate(LocalDateTime.of(2020, 12, 31, 23, 59, 59))
        .build();

    Price mockPrice = Price.builder()
        .id(1L)
        .brand(new Brand(1L, "ZARA"))
        .product(new Product(35455L))
        .price(35.50)
        .startDate(LocalDateTime.of(2020, 6, 14, 0, 0))
        .endDate(LocalDateTime.of(2020, 12, 31, 23, 59, 59))
        .build();

    // Configurar el mock del repositorio y del mapper
    when(priceJpaRepository.findFirstApplicablePrice(anyLong(), anyLong(), any()))
        .thenReturn(Optional.of(mockPriceEntity));
    when(priceEntityMapper.toDomain(any(PriceEntity.class))).thenReturn(mockPrice);

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
  void test_when_non_existent_brand_returns_empty_price() {

    LocalDateTime applicationDate = LocalDateTime.of(2020, 6, 14, 13, 0);
    Long productId = 35455L;
    Long brandId = 2L;

    // Configurar el mock para devolver un resultado vacío
    when(priceJpaRepository.findFirstApplicablePrice(productId, brandId, applicationDate))
        .thenReturn(Optional.empty());

    Optional<Price> result = priceRepositoryImpl.findFirstApplicablePrice(productId, brandId,
        applicationDate);

    // Verificar que el resultado sea vacío
    assertTrue(result.isEmpty());
  }


}
