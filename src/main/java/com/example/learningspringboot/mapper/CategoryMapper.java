package com.example.learningspringboot.mapper;

import com.example.learningspringboot.dto.CategoryCreateDto;
import com.example.learningspringboot.dto.CategoryDto;
import com.example.learningspringboot.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    CategoryDto toDto(Category category);

    List<CategoryDto> toDto(List<Category> categories);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "name", source = "name")
    Category toEntity(CategoryCreateDto dto);
}
