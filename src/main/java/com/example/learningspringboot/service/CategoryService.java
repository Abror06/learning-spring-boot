package com.example.learningspringboot.service;

import com.example.learningspringboot.dto.CategoryCreateDto;
import com.example.learningspringboot.dto.CategoryDto;
import com.example.learningspringboot.exception.CategoryNotFoundException;
import com.example.learningspringboot.exception.CategoryUniqueExecption;
import com.example.learningspringboot.mapper.CategoryMapper;
import com.example.learningspringboot.model.Category;
import com.example.learningspringboot.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public List<CategoryDto> findAll() {
        List<Category> allCategories = categoryRepository.findAll();
        return categoryMapper.toDto(allCategories);
    }

    public Category findById(Long categoryId) {
        Optional<Category> optionalCategory =
                categoryRepository.findById(categoryId);

        if (optionalCategory.isPresent()) {
            return optionalCategory.get();
        }
        throw new CategoryNotFoundException("Category not found by this id: " + categoryId);
    }

    public CategoryDto findCategoryDtoById(Long categoryId) {
    return categoryMapper.toDto(findById(categoryId));
    }

    public CategoryDto createCategory(CategoryCreateDto dto) {
        checkName(dto.getName());

        Category category = new Category();
        category.setName(dto.getName());
        categoryRepository.save(category);

        return categoryMapper.toDto(category);
    }

    public void deleteCategoryById(Long id) {
        Category category = findById(id);

        categoryRepository.delete(category);
    }

    public Category updateById(Long id, String name) {
        Category category = findById(id);
        if (name != null) {
            category.setName(name);
        }
        return categoryRepository.save(category);
    }

    private void checkName(String name) {
        if (categoryRepository.existsCategoryByName(name)) {
            throw new CategoryUniqueExecption("This category already exists: " + name);
        }
    }
}
