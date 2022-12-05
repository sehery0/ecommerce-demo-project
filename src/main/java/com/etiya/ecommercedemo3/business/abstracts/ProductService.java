package com.etiya.ecommercedemo3.business.abstracts;

import com.etiya.ecommercedemo3.business.dtos.request.product.AddProductRequest;
import com.etiya.ecommercedemo3.business.dtos.response.product.AddProductResponse;
import com.etiya.ecommercedemo3.entities.concretes.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAll();
    Product getById(int id);
    List<Product> getAllByStockGreaterThan(int stock);
    Product getByName(String name);
    AddProductResponse addProduct(AddProductRequest addProductRequest);
}
