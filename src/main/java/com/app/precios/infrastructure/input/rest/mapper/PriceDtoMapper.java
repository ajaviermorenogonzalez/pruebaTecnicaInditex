package com.app.precios.infrastructure.input.rest.mapper;

import com.app.precios.domain.model.Price;
import com.app.precios.infrastructure.input.rest.dto.PriceResponseDTO;
import com.app.precios.infrastructure.output.jpa.entities.PriceEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 * Mapper para convertir entre la entidad {@link Price} y los DTOs de entrada/salida.
 *
 * <p>Utiliza {@link Mapper} para automatizar el proceso de mapeo de propiedades entre objetos
 * de dominio y entidades de persistencia. Este mapper sigue el patrón de componentes de Spring
 * con el parámetro {@code componentModel = "spring"}.</p>
 *
 * <p>El mapeo se realiza entre las siguientes clases:</p>
 * <ul>
 *   <li>{@link Price}: Representa la entidad de base de datos del precio.</li>
 *   <li>{@link PriceResponseDTO}: Representa el objeto de respuesta de un precio.</li>
 * </ul>
 */

@Mapper(componentModel = "spring")
public interface PriceDtoMapper {

  PriceDtoMapper INSTANCE = Mappers.getMapper(PriceDtoMapper.class);

  @Mappings({
      @Mapping(source = "product.id", target = "productId"),
      @Mapping(source = "brand.id", target = "brandId"),
      @Mapping(source = "priceList", target = "priceList"),
      @Mapping(source = "price", target = "price"),
      @Mapping(source = "startDate", target = "startDate"),
      @Mapping(source = "endDate", target = "endDate")
  })
  PriceResponseDTO toPriceResponseDto(Price price);

}
