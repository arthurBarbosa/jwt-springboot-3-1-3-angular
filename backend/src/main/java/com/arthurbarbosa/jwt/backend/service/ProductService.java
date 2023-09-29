package com.arthurbarbosa.jwt.backend.service;

import com.arthurbarbosa.jwt.backend.dtos.ProductDTO;
import com.arthurbarbosa.jwt.backend.entities.Product;
import com.arthurbarbosa.jwt.backend.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
public class ProductService extends GenericService<Product, ProductDTO, ProductRepository> {
    public ProductService(ProductRepository repository) {
        super(repository);
    }


//    private final ProductRepository productRepository;


    @Override
    protected Product copyDtoToEntity(ProductDTO dto) {
        return null;
    }

    @Override
    protected ProductDTO copyEntityToDto(Product entity) {
        return new ProductDTO(entity);
    }

}
