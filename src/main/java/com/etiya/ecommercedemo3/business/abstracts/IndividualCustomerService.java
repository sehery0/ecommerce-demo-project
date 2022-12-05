package com.etiya.ecommercedemo3.business.abstracts;

import com.etiya.ecommercedemo3.entities.concretes.IndividualCustomer;

import java.util.List;

public interface IndividualCustomerService {
    List<IndividualCustomer> getAll();
    IndividualCustomer getById(int id);
    IndividualCustomer getIndividualCustomerBynationalIdentity(String nationalIdentity);
    List<IndividualCustomer> getIndividualCustomerByFirstName(String firstName);
}
