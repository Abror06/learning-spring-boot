package com.example.learningspringboot.controller;

import com.example.learningspringboot.dto.ProductCreateDto;
import com.example.learningspringboot.dto.ProductDto;
import com.example.learningspringboot.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/product")
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductDto>> getAll() {
        List<ProductDto> allProduct = productService.findAll();
        return ResponseEntity.ok(allProduct);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getById(@PathVariable("id") Long id){
        ProductDto productById = productService.getProductDtoById(id);
        return ResponseEntity.ok(productById);
    }

    @PostMapping
    public ResponseEntity<ProductDto> createProduct(@RequestBody @Valid ProductCreateDto dto){
        ProductDto product = productService.createProduct(dto);
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDto> updateProduct(@PathVariable(value = "id") Long id, @RequestParam(value = "productName", required = false) String productName, @RequestParam(value = "quantity", required = false) Long quantity, @RequestParam(value = "pricePreOne", required = false) Long pricePreOne, @RequestParam(value = "categoryId", required = false)Long categoryId) {
        ProductDto product = productService.updateById(id, productName, pricePreOne, quantity, categoryId);
        return ResponseEntity.ok(product);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable(value = "id") Long id) {
        productService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
