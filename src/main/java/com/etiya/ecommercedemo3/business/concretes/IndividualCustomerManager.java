package com.etiya.ecommercedemo3.business.concretes;

import com.etiya.ecommercedemo3.business.abstracts.IndividualCustomerService;
import com.etiya.ecommercedemo3.business.constants.Messages;
import com.etiya.ecommercedemo3.business.dtos.request.individualCustomer.AddIndividualCustomerRequest;
import com.etiya.ecommercedemo3.business.dtos.response.individualCustomer.AddIndividualCustomerResponse;
import com.etiya.ecommercedemo3.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemo3.core.util.results.DataResult;
import com.etiya.ecommercedemo3.core.util.results.SuccessDataResult;
import com.etiya.ecommercedemo3.entities.concretes.IndividualCustomer;
import com.etiya.ecommercedemo3.repository.abstracts.IndividualCustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class IndividualCustomerManager implements IndividualCustomerService {
    private IndividualCustomerRepository individualCustomerRepository;
    private ModelMapperService modelMapperService;

    @Override
    public DataResult<List<IndividualCustomer>> getAll() {
        List<IndividualCustomer> response = individualCustomerRepository.findAll();
        return new SuccessDataResult<List<IndividualCustomer>>(response, Messages.IndividualCustomer.individualCustomerGetByIdSuccessMessage);
    }

    @Override
    public DataResult<IndividualCustomer> getById(int id) {
        IndividualCustomer response = individualCustomerRepository.findById(id).orElseThrow();
        return new SuccessDataResult<IndividualCustomer>(response, Messages.IndividualCustomer.individualCustomerGetByIdSuccessMessage) ;
    }

    @Override
    public DataResult<IndividualCustomer> getIndividualCustomerBynationalIdentity(String nationalIdentity) {
        IndividualCustomer response = individualCustomerRepository.findIndividualCustomerBynationalIdentity(nationalIdentity);
        return new SuccessDataResult<IndividualCustomer>(response,Messages.IndividualCustomer.individualCustomerGetByIdentityNumberSuccessMessage);
    }

    @Override
    public DataResult<List<IndividualCustomer>> getIndividualCustomerByFirstName(String firstName) {
        List<IndividualCustomer> response = individualCustomerRepository.findIndividualCustomerByFirstName(firstName);
        return new  SuccessDataResult<List<IndividualCustomer>>(response, Messages.IndividualCustomer.individualCustomerGetByFirstNameSuccessMessage);
    }

    @Override
    public DataResult<AddIndividualCustomerResponse> addIndividualCustomer(AddIndividualCustomerRequest addIndividualCustomerRequest) {
        IndividualCustomer individualCustomer=modelMapperService.getMapperRequest().map(addIndividualCustomerRequest,IndividualCustomer.class);

        IndividualCustomer savedIndividualCustomer = individualCustomerRepository.save(individualCustomer);

        AddIndividualCustomerResponse response=modelMapperService.getMapperResponse().map(savedIndividualCustomer,AddIndividualCustomerResponse.class);
        return new SuccessDataResult<AddIndividualCustomerResponse>(response,Messages.IndividualCustomer.individualCustomerAddSuccessMessage);
    }
}
