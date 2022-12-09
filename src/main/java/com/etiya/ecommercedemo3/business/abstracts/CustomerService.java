package com.etiya.ecommercedemo3.business.abstracts;

import com.etiya.ecommercedemo3.business.dtos.request.customer.AddCustomerRequest;
import com.etiya.ecommercedemo3.business.dtos.response.customer.AddCustomerResponse;
import com.etiya.ecommercedemo3.entities.concretes.Customer;
import com.etiya.ecommercedemo3.entities.concretes.Product;

import java.util.List;

public interface CustomerService {
    Customer getById(int id);
    List<Customer> getAll();
}
