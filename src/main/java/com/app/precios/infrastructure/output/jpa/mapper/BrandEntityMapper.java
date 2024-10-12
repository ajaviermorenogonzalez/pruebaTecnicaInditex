package com.app.precios.infrastructure.output.jpa.mapper;

import com.app.precios.domain.model.Brand;
import com.app.precios.infrastructure.output.jpa.entities.BrandEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 * Mapper para convertir entre la entidad {@link BrandEntity} y el modelo de dominio {@link Brand}.
 *
 * <p>Utiliza {@link Mapper} para automatizar el proceso de mapeo de propiedades entre objetos
 * de dominio y entidades de persistencia. Este mapper sigue el patrón de componentes de Spring
 * con el parámetro {@code componentModel = "spring"}.</p>
 *
 * <p>El mapeo se realiza entre las siguientes clases:</p>
 * <ul>
 *   <li>{@link BrandEntity}: Representa la entidad de base de datos de la marca.</li>
 *   <li>{@link Brand}: Representa el modelo de dominio de la marca.</li>
 * </ul>
 */
@Mapper(componentModel = "spring")
public interface BrandEntityMapper {

  BrandEntityMapper INSTANCE = Mappers.getMapper(BrandEntityMapper.class);

  @Mappings({@Mapping(source = "id", target = "id"), @Mapping(source = "name", target = "name")})
  Brand toDomain(BrandEntity brandEntity);

  @Mappings({@Mapping(source = "id", target = "id"), @Mapping(source = "name", target = "name")})
  BrandEntity toEntity(Brand brand);

}
