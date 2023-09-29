package com.arthurbarbosa.jwt.backend.dtos;

import com.arthurbarbosa.jwt.backend.entities.Product;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDTO implements GenericDTO {

    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private String imgUrl;

    public ProductDTO(Product entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.description = entity.getDescription();
        this.price = entity.getPrice();
        this.imgUrl = entity.getImgUrl();
    }
}
