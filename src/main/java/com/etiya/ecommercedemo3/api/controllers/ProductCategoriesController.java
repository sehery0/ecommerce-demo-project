package com.etiya.ecommercedemo3.api.controllers;

import com.etiya.ecommercedemo3.business.abstracts.ProductCategoryService;
import com.etiya.ecommercedemo3.business.constants.Paths;
import com.etiya.ecommercedemo3.business.dtos.request.productCategory.AddProductCategoryRequest;
import com.etiya.ecommercedemo3.business.dtos.response.productCategory.AddProductCategoryResponse;
import com.etiya.ecommercedemo3.entities.concretes.ProductCategory;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(Paths.apiPrefix + "productcategories")
@AllArgsConstructor
public class ProductCategoriesController {
    private ProductCategoryService productCategoryService;

    @PostMapping("/add")
    public ResponseEntity<AddProductCategoryResponse > addProductCategory(@RequestBody @Valid AddProductCategoryRequest addProductCategoryRequest) {
        return new ResponseEntity<AddProductCategoryResponse >(productCategoryService.addProductCategory(addProductCategoryRequest), HttpStatus.CREATED);
    }
}
