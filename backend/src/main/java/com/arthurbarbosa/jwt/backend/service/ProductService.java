package com.arthurbarbosa.jwt.backend.service;

import com.arthurbarbosa.jwt.backend.dtos.ProductDTO;
import com.arthurbarbosa.jwt.backend.entities.Product;
import com.arthurbarbosa.jwt.backend.mappers.ProductMapper;
import com.arthurbarbosa.jwt.backend.repositories.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService extends GenericService<Product, ProductDTO, ProductRepository> {

    private final ProductMapper productMapper;

    public ProductService(ProductRepository repository, ProductMapper mapper) {
        super(repository);
        this.productMapper = mapper;
    }

    @Override
    protected Product copyDtoToEntity(ProductDTO dto) {
        return productMapper.toDtoProduct(dto);
    }

    @Override
    protected ProductDTO copyEntityToDto(Product entity) {
        return productMapper.toProductDto(entity);
    }
}
