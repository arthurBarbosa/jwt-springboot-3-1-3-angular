package com.arthurbarbosa.jwt.backend.controllers;

import com.arthurbarbosa.jwt.backend.dtos.ProductDTO;
import com.arthurbarbosa.jwt.backend.service.ProductService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class ProductController {


    private final ProductService service;

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> findById(@PathVariable Long id) {
        ProductDTO dto = service.findById(id);
        return ResponseEntity.ok(dto);
    }


    @GetMapping()
    public ResponseEntity<Page<ProductDTO>> findAll(Pageable pageable) {
        return ResponseEntity.ok(service.findAll(pageable));
    }

    @PostMapping()
    public ResponseEntity<ProductDTO> insert(@RequestBody @Valid ProductDTO dto) {
        return ResponseEntity.ok(service.insert(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDTO> update(@PathVariable Long id, @RequestBody @Valid ProductDTO dto) {
        ProductDTO response = service.update(id, dto);
        return ResponseEntity.ok(response);
    }

}
