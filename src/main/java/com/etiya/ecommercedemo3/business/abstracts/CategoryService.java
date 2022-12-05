package com.etiya.ecommercedemo3.business.abstracts;

import com.etiya.ecommercedemo3.business.dtos.request.category.AddCategoryRequest;
import com.etiya.ecommercedemo3.business.dtos.response.category.AddCategoryResponse;
import com.etiya.ecommercedemo3.entities.concretes.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAll();
    Category getById(int id);
     AddCategoryResponse addCategory(AddCategoryRequest addCategoryRequest);
}
