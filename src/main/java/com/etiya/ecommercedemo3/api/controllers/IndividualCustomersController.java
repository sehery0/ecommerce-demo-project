package com.etiya.ecommercedemo3.api.controllers;

import com.etiya.ecommercedemo3.business.abstracts.IndividualCustomerService;
import com.etiya.ecommercedemo3.business.constants.Paths;
import com.etiya.ecommercedemo3.business.dtos.request.individualCustomer.AddIndividualCustomerRequest;
import com.etiya.ecommercedemo3.business.dtos.response.individualCustomer.AddIndividualCustomerResponse;
import com.etiya.ecommercedemo3.core.util.results.DataResult;
import com.etiya.ecommercedemo3.entities.concretes.IndividualCustomer;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(Paths.apiPrefix + "individualCustomers")
@AllArgsConstructor
public class IndividualCustomersController {
    IndividualCustomerService individualCustomerService;

    @GetMapping("/getAll")
    public DataResult<List<IndividualCustomer>> getAll(){
        return individualCustomerService.getAll();
    }

    @GetMapping("/getById")
    public DataResult<IndividualCustomer> getById(@RequestParam("id") int id){
        return individualCustomerService.getById(id);
    }

    @GetMapping("/firstName")
    public DataResult<List<IndividualCustomer>> getIndividualCustomerByFirstName(@RequestParam("firstName") String firstName){
        return individualCustomerService.getIndividualCustomerByFirstName(firstName);
    }

    @GetMapping("/nationalIdentity")
    public DataResult<IndividualCustomer> getIndividualCustomerBynationalIdentity(@RequestParam("nationalIdentity") String nationalIdentity){
        return individualCustomerService.getIndividualCustomerBynationalIdentity(nationalIdentity);
    }

    @PostMapping("/add")
    public ResponseEntity<DataResult<AddIndividualCustomerResponse>> addIndividualCustomer(@RequestBody AddIndividualCustomerRequest addIndividualCustomerRequest)
    {
        return  new ResponseEntity<>(individualCustomerService.addIndividualCustomer(addIndividualCustomerRequest), HttpStatus.CREATED);
    }
}
