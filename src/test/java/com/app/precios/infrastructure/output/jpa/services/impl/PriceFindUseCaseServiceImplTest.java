package com.app.precios.infrastructure.output.jpa.services.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import com.app.precios.domain.exceptions.PriceNotFoundException;
import com.app.precios.domain.model.Brand;
import com.app.precios.domain.model.Price;
import com.app.precios.domain.model.Product;
import com.app.precios.domain.repository.PriceRepository;
import java.time.LocalDateTime;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class PriceFindUseCaseServiceImplTest {

  @Mock
  private PriceRepository priceRepository; // Cambiado a PriceRepository para alinearlo con tu implementación

  @InjectMocks
  private PriceFindUseCaseServiceImpl priceFindUseCaseServiceImpl;

  @Test
  @DisplayName("OK_findAplicablePrice")
  void testFindApplicablePrice_Success() {

    Long priceId = 1L;
    Double price = 35.50;

    Long productId = 35455L;
    Long brandId = 1L;
    String brandName = "ZARA";
    LocalDateTime applicationDate = LocalDateTime.of(2020, 6, 14, 16, 0);

    Product product = Product.builder().id(productId).build();
    Brand brand = Brand.builder().id(brandId).name(brandName).build();

    // Creamos un Price ficticio para el test
    Price mockPrice = Price.builder()
        .id(priceId)
        .product(product)
        .brand(brand)
        .price(price)
        .build();

    // Simulamos que el repositorio devuelve un Optional con el PriceEntity
    when(priceRepository.findFirstApplicablePrice(product.getId(), brand.getId(),
        applicationDate)).thenReturn(Optional.of(mockPrice));

    // Ejecutamos el caso de uso
    Price result = priceFindUseCaseServiceImpl.findApplicablePrice(productId, brandId,
        applicationDate);

    // Aseguramos que el resultado es el esperado
    assertNotNull(result);
    assertEquals(price, result.getPrice());
  }

  @Test
  @DisplayName("KO_PriceNotFoundException")
  void testFindApplicablePrice_PriceNotFound() {
    Long productId = 35455L;
    Long brandId = 1L;
    LocalDateTime applicationDate = LocalDateTime.of(2020, 6, 14, 16, 0);

    // Simulamos que el repositorio no encuentra ningún precio
    when(priceRepository.findFirstApplicablePrice(productId, brandId,
        applicationDate)).thenReturn(Optional.empty());

    // Verificamos que se lanza la excepción PriceNotFoundException
    assertThrows(PriceNotFoundException.class, () -> {
      priceFindUseCaseServiceImpl.findApplicablePrice(productId, brandId, applicationDate);
    });
  }

}
