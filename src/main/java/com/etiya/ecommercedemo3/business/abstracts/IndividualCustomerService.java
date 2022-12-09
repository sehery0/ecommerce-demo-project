package com.etiya.ecommercedemo3.business.abstracts;

import com.etiya.ecommercedemo3.business.dtos.request.individualCustomer.AddIndividualCustomerRequest;
import com.etiya.ecommercedemo3.business.dtos.response.individualCustomer.AddIndividualCustomerResponse;
import com.etiya.ecommercedemo3.entities.concretes.IndividualCustomer;

import java.util.List;

public interface IndividualCustomerService {
    List<IndividualCustomer> getAll();
    IndividualCustomer getById(int id);
    IndividualCustomer getIndividualCustomerBynationalIdentity(String nationalIdentity);
    List<IndividualCustomer> getIndividualCustomerByFirstName(String firstName);
    AddIndividualCustomerResponse addIndividualCustomer(AddIndividualCustomerRequest addIndividualCustomerRequest);
}
