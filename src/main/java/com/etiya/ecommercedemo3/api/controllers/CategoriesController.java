package com.etiya.ecommercedemo3.api.controllers;

import com.etiya.ecommercedemo3.business.abstracts.CategoryService;
import com.etiya.ecommercedemo3.entities.concretes.Category;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoriesController {
    private CategoryService categoryService;

    @GetMapping("/getAll")
    public List<Category> getAll(){
        return categoryService.getAll();
    }

}
