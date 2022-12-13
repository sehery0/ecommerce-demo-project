package com.etiya.ecommercedemo3.business.concretes;

import com.etiya.ecommercedemo3.business.abstracts.CustomerService;
import com.etiya.ecommercedemo3.business.constants.Messages;
import com.etiya.ecommercedemo3.core.util.results.DataResult;
import com.etiya.ecommercedemo3.core.util.results.SuccessDataResult;
import com.etiya.ecommercedemo3.entities.concretes.Customer;
import com.etiya.ecommercedemo3.repository.abstracts.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerManager implements CustomerService {
    CustomerRepository customerRepository;

    @Override
    public DataResult<Customer> getById(int id) {
        Customer response = customerRepository.findById(id).orElseThrow();
        return new SuccessDataResult<Customer>(response, Messages.Customer.customerGetAllSuccessMessage);
    }

    @Override
    public SuccessDataResult<List<Customer>> getAll() {
        List<Customer> response = customerRepository.findAll();
        return new SuccessDataResult<List<Customer>>(response, Messages.Customer.customerGetByIdSuccessMessage);
    }
}
