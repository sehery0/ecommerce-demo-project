package com.etiya.ecommercedemo3.business.concretes;

import com.etiya.ecommercedemo3.business.abstracts.CategoryService;
import com.etiya.ecommercedemo3.business.abstracts.ProductCategoryService;
import com.etiya.ecommercedemo3.business.abstracts.ProductService;
import com.etiya.ecommercedemo3.business.dtos.request.productCategory.AddProductCategoryRequest;
import com.etiya.ecommercedemo3.entities.concretes.Category;
import com.etiya.ecommercedemo3.entities.concretes.Product;
import com.etiya.ecommercedemo3.entities.concretes.ProductCategory;
import com.etiya.ecommercedemo3.repository.abstracts.CategoryRepository;
import com.etiya.ecommercedemo3.repository.abstracts.ProductCategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductCategoryManager implements ProductCategoryService {
    private ProductCategoryRepository productCategoryRepository;
    private CategoryService categoryService;
    private ProductService productService;
    private final CategoryRepository categoryRepository;

    @Override
    public ProductCategory addProductCategory(AddProductCategoryRequest addProductCategoryRequest) {
        ProductCategory productCategory = new ProductCategory();
        checkIfCategoryById(addProductCategoryRequest.getCategoryId());
        Category category = categoryService.getById(addProductCategoryRequest.getCategoryId());
        productCategory.setCategory(category);
        Product product = productService.getById(addProductCategoryRequest.getProductId());
        productCategory.setProduct(product);
        ProductCategory savedProductCategory = productCategoryRepository.save(productCategory);

        return productCategoryRepository.save(productCategory);
    }

    private void checkIfCategoryById(int id){
        Category category = categoryRepository.checkIfCategoryById(id);
        if(category == null)
            throw new RuntimeException("Bu id'ye sahip bir kategori mevcut değil!");
    }


}
