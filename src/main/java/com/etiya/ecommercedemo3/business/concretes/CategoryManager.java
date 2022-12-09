package com.etiya.ecommercedemo3.business.concretes;

import com.etiya.ecommercedemo3.business.abstracts.CategoryService;
import com.etiya.ecommercedemo3.business.constants.Messages;
import com.etiya.ecommercedemo3.business.dtos.request.category.AddCategoryRequest;
import com.etiya.ecommercedemo3.business.dtos.response.category.AddCategoryResponse;
import com.etiya.ecommercedemo3.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemo3.entities.concretes.Category;
import com.etiya.ecommercedemo3.repository.abstracts.CategoryRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryManager implements CategoryService {
    private CategoryRepository categoryRepository;
    private ModelMapperService modelMapperService;
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
//        Category category = new Category();
//        category.setName(addCategoryRequest.getName());
//        categoryCanNotExistWithSameName(addCategoryRequest.getName());
        Category category = modelMapperService.getMapperRequest().map(addCategoryRequest, Category.class);
        Category savedCategory = categoryRepository.save(category);
//        AddCategoryResponse response =
//                new AddCategoryResponse(savedCategory.getId(), savedCategory.getName());
        AddCategoryResponse response=modelMapperService.getMapperResponse().map(savedCategory,AddCategoryResponse.class);
        return response;
    }

    private void categoryCanNotExistWithSameName(String name){
        // Exception fırlatma
        boolean isExists = categoryRepository.existsCategoryByName(name);
        if(!isExists)
            throw new RuntimeException(Messages.Category.CategoryExistWithSameName);
    }

}
