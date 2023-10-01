package com.arthurbarbosa.jwt.backend.mappers;

import com.arthurbarbosa.jwt.backend.dtos.ProductDTO;
import com.arthurbarbosa.jwt.backend.entities.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductDTO toProductDto(Product entity);
    Product toDtoProduct(ProductDTO dto);

}
