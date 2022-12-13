package com.etiya.ecommercedemo3.business.abstracts;

import com.etiya.ecommercedemo3.business.dtos.request.individualCustomer.AddIndividualCustomerRequest;
import com.etiya.ecommercedemo3.business.dtos.response.individualCustomer.AddIndividualCustomerResponse;
import com.etiya.ecommercedemo3.core.util.results.DataResult;
import com.etiya.ecommercedemo3.entities.concretes.IndividualCustomer;

import java.util.List;

public interface IndividualCustomerService {
    DataResult<List<IndividualCustomer>> getAll();
    DataResult<IndividualCustomer> getById(int id);
    DataResult<IndividualCustomer> getIndividualCustomerBynationalIdentity(String nationalIdentity);
    DataResult<List<IndividualCustomer>> getIndividualCustomerByFirstName(String firstName);
    DataResult<AddIndividualCustomerResponse> addIndividualCustomer(AddIndividualCustomerRequest addIndividualCustomerRequest);
}
