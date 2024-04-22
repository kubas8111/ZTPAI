package com.example.adwise.services;

import com.example.adwise.DTO.CategoryDTO;
import com.example.adwise.entities.Category;
import com.example.adwise.exceptions.ResourceNotFoundException;
import com.example.adwise.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Iterable<CategoryDTO> getAllCategories() {
        Iterable<Category> categories = categoryRepository.findAll();
        List<CategoryDTO> categoryDTOs = new ArrayList<>();
        categories.forEach(category -> categoryDTOs.add(convertToDto(category)));
        return categoryDTOs;
    }

    public CategoryDTO getCategoryById(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found with id: " + id));
        return convertToDto(category);
    }


    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
        Category category = convertToEntity(categoryDTO);
        Category createdCategory = categoryRepository.save(category);
        return convertToDto(createdCategory);
    }

    public CategoryDTO updateCategory(Long id, CategoryDTO categoryDTO) {
        Category existingCategory = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found with id: " + id));

        existingCategory.setName(categoryDTO.getName());

        Category updatedCategory = categoryRepository.save(existingCategory);
        return convertToDto(updatedCategory);
    }

    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }

    private CategoryDTO convertToDto(Category category) {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setCategoryId(category.getCategoryId());
        categoryDTO.setName(category.getName());
        return categoryDTO;
    }

    private Category convertToEntity(CategoryDTO categoryDTO) {
        Category category = new Category();
        category.setCategoryId(categoryDTO.getCategoryId());
        category.setName(categoryDTO.getName());
        return category;
    }
}