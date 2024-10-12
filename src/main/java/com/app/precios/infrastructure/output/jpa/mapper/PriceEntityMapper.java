package com.app.precios.infrastructure.output.jpa.mapper;

import com.app.precios.domain.enums.Currency;
import com.app.precios.domain.model.Price;
import com.app.precios.infrastructure.output.jpa.entities.PriceEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 * Mapper para convertir entre la entidad {@link PriceEntity} y el modelo de dominio {@link Price}.
 *
 * <p>Utiliza {@link Mapper} para automatizar el proceso de mapeo de propiedades entre objetos
 * de dominio y entidades de persistencia. Este mapper sigue el patrón de componentes de Spring
 * con el parámetro {@code componentModel = "spring"}.</p>
 *
 * <p>El mapeo se realiza entre las siguientes clases:</p>
 * <ul>
 *   <li>{@link PriceEntity}: Representa la entidad de base de datos del precio.</li>
 *   <li>{@link Price}: Representa el modelo de dominio del precio.</li>
 * </ul>
 */
@Mapper(componentModel = "spring",
    imports = Currency.class,
    uses = {BrandEntityMapper.class, ProductEntityMapper.class})
public interface PriceEntityMapper {

  PriceEntityMapper INSTANCE = Mappers.getMapper(PriceEntityMapper.class);

  @Mappings({
      @Mapping(source = "product", target = "product"),
      @Mapping(source = "brand", target = "brand"),
      @Mapping(source = "price", target = "price"),
      @Mapping(source = "priority", target = "priority"),
      @Mapping(source = "currency", target = "currency"),
      @Mapping(source = "priceList", target = "priceList"),
      @Mapping(source = "startDate", target = "startDate"),
      @Mapping(source = "endDate", target = "endDate")
  })
  Price toDomain(PriceEntity priceEntity);

  @Mappings({
      @Mapping(source = "product", target = "product"),
      @Mapping(source = "brand", target = "brand"),
      @Mapping(source = "price", target = "price"),
      @Mapping(source = "priority", target = "priority"),
      @Mapping(source = "currency", target = "currency"),
      @Mapping(source = "priceList", target = "priceList"),
      @Mapping(source = "startDate", target = "startDate"),
      @Mapping(source = "endDate", target = "endDate")
  })
  PriceEntity toEntity(Price price);

  default String map(Currency currency) {
    return currency != null ? currency.name() : null;
  }

  default Currency map(String currency) {
    return currency != null ? Currency.valueOf(currency) : null;
  }
}
