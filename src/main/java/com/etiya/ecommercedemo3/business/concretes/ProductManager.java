package com.etiya.ecommercedemo3.business.concretes;

import com.etiya.ecommercedemo3.business.abstracts.ProductService;
import com.etiya.ecommercedemo3.business.dtos.request.product.AddProductRequest;
import com.etiya.ecommercedemo3.business.dtos.response.product.AddProductResponse;
import com.etiya.ecommercedemo3.entities.concretes.Product;
import com.etiya.ecommercedemo3.repository.abstracts.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductManager implements ProductService {
    private ProductRepository productRepository;
    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Product getById(int id) {
        return productRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Product> getAllByStockGreaterThan(int stock) {
        return productRepository.findAllProductsByStockGreaterThanOrderByStockDesc(stock);
    }

    @Override
    public Product getByName(String name) {
        return productRepository.findByName(name);
    }

    @Override
    public AddProductResponse addProduct(AddProductRequest addProductRequest) {
        Product product = new Product();
        product.setName(addProductRequest.getName());
        product.setStock(addProductRequest.getStock());
        product.setUnit_price(addProductRequest.getUnit_price());
        Product savedProduct = productRepository.save(product);
        AddProductResponse response = new AddProductResponse(savedProduct.getId(), savedProduct.getName(), savedProduct.getUnit_price(), savedProduct.getStock());
        return response;
    }

}
