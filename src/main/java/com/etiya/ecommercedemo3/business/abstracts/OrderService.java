package com.etiya.ecommercedemo3.business.abstracts;

import com.etiya.ecommercedemo3.business.dtos.request.order.AddOrderRequest;
import com.etiya.ecommercedemo3.business.dtos.response.order.AddOrderResponse;
import com.etiya.ecommercedemo3.core.util.results.DataResult;
import com.etiya.ecommercedemo3.entities.concretes.Product;

import java.util.List;

public interface OrderService {
    DataResult<AddOrderResponse> addOrder(AddOrderRequest addOrderRequest);
    List<Product> getProductsAtOrderWithCartId(int identity);
}
