package com.example.learningspringboot.mapper;

import com.example.learningspringboot.dto.CategoryCreateDto;
import com.example.learningspringboot.dto.CategoryDto;
import com.example.learningspringboot.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS
)
public interface CategoryMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    CategoryDto toDto(Category category);

    List<CategoryDto> toDto(List<Category> categories);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "name", source = "name")
    Category toEntity(CategoryCreateDto dto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "name", source = "name")
    void toUpdateEntity(@MappingTarget Category category, String name);
}
