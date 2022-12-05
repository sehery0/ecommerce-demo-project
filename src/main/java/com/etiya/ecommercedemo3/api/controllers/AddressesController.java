package com.etiya.ecommercedemo3.api.controllers;

import com.etiya.ecommercedemo3.business.abstracts.AddressService;
import com.etiya.ecommercedemo3.entities.concretes.Address;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/addresses")
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
}
