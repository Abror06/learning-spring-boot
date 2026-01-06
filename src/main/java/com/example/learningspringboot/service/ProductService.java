package com.example.learningspringboot.service;

import com.example.learningspringboot.dto.ProductCreateDto;
import com.example.learningspringboot.dto.ProductDto;
import com.example.learningspringboot.exception.IllegalPriceException;
import com.example.learningspringboot.exception.IllegalQuantityException;
import com.example.learningspringboot.exception.ProductNotFoundException;
import com.example.learningspringboot.mapper.CategoryMapper;
import com.example.learningspringboot.mapper.ProductMapper;
import com.example.learningspringboot.model.Category;
import com.example.learningspringboot.model.Product;
import com.example.learningspringboot.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final CategoryService categoryService;
    private final ProductMapper productMapper;

    public Page<ProductDto> findAll(Pageable pageable) {
        Page<Product> productPage = productRepository.findAll(pageable);

        Page<ProductDto> dtoPage=productPage.map(productMapper::toDto);
        return dtoPage;
    }

    public Product findById(Long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            return optionalProduct.get();
        }
        throw new ProductNotFoundException("Product not found");
    }

    public ProductDto getProductDtoById(Long id) {
        return productMapper.toDto(findById(id));
    }

    public ProductDto createProduct(ProductCreateDto dto) {
        checkQuantity(dto.getQuantity());
        checkPrice(dto.getPricePerOne());

        Category category = categoryService.findById(dto.getCategoryId());

        Product product = productMapper.toEntity(dto, category);
        productRepository.save(product);
        return productMapper.toDto(product);
    }


    public void deleteById(Long id) {
        Product product = findById(id);

        productRepository.delete(product);
    }

    public ProductDto updateById(Long productId, String productName, Long pricePerOne, Long quantity, Long categoryId) {
        Product product = findById(productId);

        productMapper.toUpdateEntity(product, productName, pricePerOne, quantity, categoryId);
        productRepository.save(product);

        return productMapper.toDto(product);
    }


    private void checkQuantity(Long quantity) {
        if (quantity < 1) {
            throw new IllegalQuantityException("Quantity must be more than 0 ");
        }
    }

    private void checkPrice(Long pricePerOne) {
        if (pricePerOne <= 0) {
            throw new IllegalPriceException("price must be more than 0 ");
        }
    }

}
