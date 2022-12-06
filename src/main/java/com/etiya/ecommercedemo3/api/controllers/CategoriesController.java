package com.etiya.ecommercedemo3.api.controllers;

import com.etiya.ecommercedemo3.business.abstracts.CategoryService;
import com.etiya.ecommercedemo3.business.dtos.request.category.AddCategoryRequest;
import com.etiya.ecommercedemo3.business.dtos.response.category.AddCategoryResponse;
import com.etiya.ecommercedemo3.entities.concretes.Category;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@AllArgsConstructor
public class CategoriesController {
    private CategoryService categoryService;

    @GetMapping("/getAll")
    public List<Category> getAll(){
        return categoryService.getAll();
    }

    @PostMapping("/add")
    public ResponseEntity<AddCategoryResponse> addCategory(@RequestBody AddCategoryRequest addCategoryRequest){
        return new ResponseEntity<AddCategoryResponse>(categoryService.addCategory(addCategoryRequest), HttpStatus.CREATED);
    }
}
