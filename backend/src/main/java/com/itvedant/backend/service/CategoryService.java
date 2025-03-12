package com.itvedant.backend.service;

import com.itvedant.backend.model.Category;
import com.itvedant.backend.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    // Fetch all categories
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    // Add a new category
    public Category addCategory(Category category) {
        return categoryRepository.save(category);
    }
}
