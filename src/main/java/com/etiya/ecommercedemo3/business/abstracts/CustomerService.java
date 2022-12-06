package com.etiya.ecommercedemo3.business.abstracts;

import com.etiya.ecommercedemo3.business.dtos.request.customer.AddCustomerRequest;
import com.etiya.ecommercedemo3.business.dtos.response.customer.AddCustomerResponse;
import com.etiya.ecommercedemo3.entities.concretes.Customer;
import com.etiya.ecommercedemo3.entities.concretes.Product;

public interface CustomerService {
    AddCustomerResponse addCustomer(AddCustomerRequest addCustomerRequest);
    Customer getById(int id);
}
