package com.example.adwise.repositories;

import com.example.adwise.entities.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Integer> {
    Category findCategoryByCategoryId(Integer categoryId);
}
