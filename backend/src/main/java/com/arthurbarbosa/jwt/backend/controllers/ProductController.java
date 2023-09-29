package com.arthurbarbosa.jwt.backend.controllers;

import com.arthurbarbosa.jwt.backend.dtos.ProductDTO;
import com.arthurbarbosa.jwt.backend.entities.Product;
import com.arthurbarbosa.jwt.backend.repositories.ProductRepository;
import com.arthurbarbosa.jwt.backend.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class ProductController {


    private final ProductService service;

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> messages(@PathVariable Long id) {
        ProductDTO dto = service.findById(id);
        return ResponseEntity.ok(dto);
    }

}
