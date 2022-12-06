package com.etiya.ecommercedemo3.business.abstracts;

import com.etiya.ecommercedemo3.business.dtos.request.paymentType.AddPaymentTypeRequest;
import com.etiya.ecommercedemo3.business.dtos.request.productCategory.AddProductCategoryRequest;
import com.etiya.ecommercedemo3.business.dtos.response.paymentType.AddPaymentTypeResponse;
import com.etiya.ecommercedemo3.business.dtos.response.productCategory.AddProductCategoryResponse;
import com.etiya.ecommercedemo3.entities.concretes.ProductCategory;

public interface ProductCategoryService {
    ProductCategory addProductCategory(AddProductCategoryRequest addProductCategoryRequest);
}
