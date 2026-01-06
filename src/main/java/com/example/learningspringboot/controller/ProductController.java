package com.example.learningspringboot.controller;

import com.example.learningspringboot.dto.ProductCreateDto;
import com.example.learningspringboot.dto.ProductDto;
import com.example.learningspringboot.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public ResponseEntity<Page<ProductDto>> getAll(Pageable pageable) {
        Page<ProductDto> allProduct = productService.findAll(pageable);
        return ResponseEntity.ok(allProduct);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getById(@PathVariable("id") Long id){
        ProductDto productById = productService.getProductDtoById(id);
        return ResponseEntity.ok(productById);
    }

    @PostMapping
    public ResponseEntity<ProductDto> createProduct(@RequestBody @Valid ProductCreateDto dto){
        ProductDto productDto = productService.createProduct(dto);
        return new ResponseEntity<>(productDto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDto> updateProduct(@PathVariable(value = "id") Long id,
                                                    @RequestParam(value = "productName", required = false) String productName,
                                                    @RequestParam(value = "quantity", required = false) Long quantity,
                                                    @RequestParam(value = "pricePerOne", required = false) Long pricePreOne,
                                                    @RequestParam(value = "categoryId", required = false)Long categoryId) {
        ProductDto productDto = productService.updateById(id, productName, pricePreOne, quantity, categoryId);
        return ResponseEntity.ok(productDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable(value = "id") Long id) {
        productService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
