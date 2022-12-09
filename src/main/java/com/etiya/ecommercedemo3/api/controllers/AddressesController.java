package com.etiya.ecommercedemo3.api.controllers;

import com.etiya.ecommercedemo3.business.abstracts.AddressService;
import com.etiya.ecommercedemo3.business.constants.Paths;
import com.etiya.ecommercedemo3.business.dtos.request.address.AddAddressRequest;
import com.etiya.ecommercedemo3.business.dtos.request.productCategory.AddProductCategoryRequest;
import com.etiya.ecommercedemo3.business.dtos.response.address.AddAddressResponse;
import com.etiya.ecommercedemo3.business.dtos.response.productCategory.AddProductCategoryResponse;
import com.etiya.ecommercedemo3.entities.concretes.Address;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(Paths.apiPrefix + "addresses")
@AllArgsConstructor
public class AddressesController {
    AddressService addressService;

    @GetMapping("/getAll")
    public List<Address> getAll() {
        return addressService.getAll();
    }

    @GetMapping("{id}")
    public Address getById(@PathVariable int id) {
        return addressService.getById(id);
    }

    @GetMapping("/title")
    public List<Address> getAllAddressByTitle(@RequestParam("title") String title) {
        return addressService.getAllAddressByTitle(title);
    }

    @GetMapping("/description")
    public Address findByDescription(@RequestParam("description") String description) {
        return addressService.findByDescription(description);
    }

    @PostMapping("/add")
    public ResponseEntity<AddAddressResponse> addAddress(@RequestBody @Valid AddAddressRequest addAddressRequest) {
        return new ResponseEntity<AddAddressResponse >(addressService.addAddress(addAddressRequest), HttpStatus.CREATED);
    }
}
