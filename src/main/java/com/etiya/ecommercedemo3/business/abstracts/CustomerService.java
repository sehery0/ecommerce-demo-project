package com.etiya.ecommercedemo3.business.abstracts;

import com.etiya.ecommercedemo3.core.util.results.DataResult;
import com.etiya.ecommercedemo3.core.util.results.SuccessDataResult;
import com.etiya.ecommercedemo3.entities.concretes.Customer;

import java.util.List;

public interface CustomerService {
    DataResult<Customer> getById(int id);
    SuccessDataResult<List<Customer>> getAll();
}
