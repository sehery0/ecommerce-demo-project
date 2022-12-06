package com.etiya.ecommercedemo3.business.concretes;

import com.etiya.ecommercedemo3.business.abstracts.CategoryService;
import com.etiya.ecommercedemo3.business.dtos.request.category.AddCategoryRequest;
import com.etiya.ecommercedemo3.business.dtos.response.category.AddCategoryResponse;
import com.etiya.ecommercedemo3.entities.concretes.Category;
import com.etiya.ecommercedemo3.repository.abstracts.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryManager implements CategoryService {
    private CategoryRepository categoryRepository;
    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getById(int id) {
        return categoryRepository.findById(id).orElseThrow();
    }

    @Override
    public AddCategoryResponse addCategory(AddCategoryRequest addCategoryRequest) {
        Category category = new Category();
        category.setName(addCategoryRequest.getName());
        categoryCanNotExistWithSameName(addCategoryRequest.getName());
        Category savedCategory = categoryRepository.save(category);
        AddCategoryResponse response =
                new AddCategoryResponse(savedCategory.getId(), savedCategory.getName());
        return response;
    }

    private void categoryCanNotExistWithSameName(String name){
        // Exception fırlatma
        boolean isExists = categoryRepository.existsCategoryByName(name);
        if(!isExists)
            throw new RuntimeException("Bu isimle bir kategori zaten mevcut!");
    }

}
