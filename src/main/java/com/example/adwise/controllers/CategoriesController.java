package com.example.adwise.controllers;

import com.example.adwise.entities.Category;
import com.example.adwise.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
public class CategoriesController {
    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/list")
    public Iterable<Category> getCategories() {
        return categoryRepository.findAll();
    }

    @GetMapping("/find/{id}")
    public Category findCategoryById(@PathVariable Integer id) {
        return categoryRepository.findCategoryByCategoryId(id);
    }
}
