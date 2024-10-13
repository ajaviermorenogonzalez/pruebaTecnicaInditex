package com.app.precios.infrastructure.output.jpa.mapper;

import com.app.precios.domain.model.Product;
import com.app.precios.infrastructure.output.jpa.entities.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Mapper para convertir entre la entidad {@link ProductEntity}
 * y el modelo de dominio {@link Product}.
 *
 * <p>Utiliza {@link Mapper} para automatizar el proceso de mapeo de propiedades entre objetos
 * de dominio y entidades de persistencia. Este mapper sigue el patrón de componentes de Spring
 * con el parámetro {@code componentModel = "spring"}.</p>
 *
 * <p>El mapeo se realiza entre las siguientes clases:</p>
 * <ul>
 *   <li>{@link ProductEntity}: Representa la entidad de base de datos del producto.</li>
 *   <li>{@link Product}: Representa el modelo de dominio del producto.</li>
 * </ul>
 */
@Mapper(componentModel = "spring")
public interface ProductEntityMapper {

  @Mapping(source = "id", target = "id")
  Product toDomain(ProductEntity productEntity);

  @Mapping(source = "id", target = "id")
  ProductEntity toEntity(Product product);

}
