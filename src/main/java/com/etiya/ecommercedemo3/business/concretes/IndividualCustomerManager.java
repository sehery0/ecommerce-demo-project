package com.etiya.ecommercedemo3.business.concretes;

import com.etiya.ecommercedemo3.business.abstracts.IndividualCustomerService;
import com.etiya.ecommercedemo3.entities.concretes.IndividualCustomer;
import com.etiya.ecommercedemo3.repository.abstracts.IndividualCustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class IndividualCustomerManager implements IndividualCustomerService {
    private IndividualCustomerRepository individualCustomerRepository;

    @Override
    public List<IndividualCustomer> getAll() {
        return individualCustomerRepository.findAll();
    }

    @Override
    public IndividualCustomer getById(int id) {
        return individualCustomerRepository.findById(id).orElseThrow();
    }

    @Override
    public IndividualCustomer getIndividualCustomerBynationalIdentity(String nationalIdentity) {
        return individualCustomerRepository.findIndividualCustomerBynationalIdentity(nationalIdentity);
    }

    @Override
    public List<IndividualCustomer> getIndividualCustomerByFirstName(String firstName) {
        return individualCustomerRepository.findIndividualCustomerByFirstName(firstName);
    }
}
