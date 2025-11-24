package com.example.learningspringboot.mapper;

import com.example.learningspringboot.dto.CategoryCreateDto;
import com.example.learningspringboot.dto.CategoryDto;
import com.example.learningspringboot.model.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CategoryMapper {
    public CategoryDto toDto(Category category) {
        CategoryDto categoryDto = new CategoryDto();

        category.setCategoryId(category.getCategoryId());
        category.setName(category.getName());
        return categoryDto;
    }

    public List<CategoryDto> toDto(List<Category> categories){
        return categories.stream().map(this::toDto).toList();
    }

    public void toEntity(CategoryCreateDto dto, Category category) {
        category.setName(dto.getName());
    }
}
