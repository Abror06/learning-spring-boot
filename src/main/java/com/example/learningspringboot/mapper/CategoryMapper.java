package com.example.learningspringboot.mapper;

import com.example.learningspringboot.dto.CategoryCreateDto;
import com.example.learningspringboot.dto.CategoryDto;
import com.example.learningspringboot.model.Category;

import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface CategoryMapper {
    CategoryDto toDto(Category category);

    List<CategoryDto> toDto(List<Category> categories);

    Category toEntity(CategoryCreateDto categoryCreateDto);

}
