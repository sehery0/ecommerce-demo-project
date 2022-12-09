package com.etiya.ecommercedemo3.api.controllers;

import com.etiya.ecommercedemo3.business.abstracts.PaymentTypeService;
import com.etiya.ecommercedemo3.business.constants.Paths;
import com.etiya.ecommercedemo3.business.dtos.request.paymentType.AddPaymentTypeRequest;
import com.etiya.ecommercedemo3.business.dtos.response.paymentType.AddPaymentTypeResponse;
import com.etiya.ecommercedemo3.entities.concretes.PaymentType;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Paths.apiPrefix + "paymentTypes")
@AllArgsConstructor
public class PaymentTypesController {
    PaymentTypeService paymentTypeService;

    @GetMapping("/getAll")
    public List<PaymentType> getAll(){
        return paymentTypeService.getAll();
    }

    @GetMapping("{id}")
    public PaymentType getById(@PathVariable int id){
        return paymentTypeService.getById(id);
    }

    @GetMapping("/name")
    public PaymentType getByName(@RequestParam("name") String name){
        return paymentTypeService.getByName(name);
    }

    @GetMapping("/description")
    public PaymentType getByDescription(@RequestParam("description") String description){
        return paymentTypeService.getByDescription(description);
    }

    @PostMapping("/add")
    public ResponseEntity<AddPaymentTypeResponse> addPaymentType(@RequestBody AddPaymentTypeRequest addPaymentTypeRequest)
    {
        return  new ResponseEntity<AddPaymentTypeResponse>(paymentTypeService.addPaymentType(addPaymentTypeRequest), HttpStatus.CREATED);
    }
}
