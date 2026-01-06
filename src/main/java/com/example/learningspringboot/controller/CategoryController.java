package com.example.learningspringboot.controller;

import com.example.learningspringboot.dto.CategoryCreateDto;
import com.example.learningspringboot.dto.CategoryDto;
import com.example.learningspringboot.service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/category")
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping
    public ResponseEntity<Page<CategoryDto>> getAll(Pageable pageable) {
        Page<CategoryDto> categoryList = categoryService.findAll(pageable);
        return ResponseEntity.ok(categoryList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDto> getById(@PathVariable("id") Long id) {
        CategoryDto categoryDto = categoryService.findCategoryDtoById(id);
        return ResponseEntity.ok(categoryDto);
    }

    @PostMapping
    public ResponseEntity<CategoryDto> createCategory(@RequestBody @Valid CategoryCreateDto dto) {
        CategoryDto category = categoryService.createCategory(dto);
        return new ResponseEntity<>(category, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    ResponseEntity<CategoryDto> updateCategory(@PathVariable(value = "id") Long id, @RequestParam(value = "name") String name) {
        CategoryDto categoryDto = categoryService.updateById(id, name);
        return ResponseEntity.ok(categoryDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable(value = "id") Long id){
        categoryService.deleteCategoryById(id);
        return ResponseEntity.ok().build();
    }
}
