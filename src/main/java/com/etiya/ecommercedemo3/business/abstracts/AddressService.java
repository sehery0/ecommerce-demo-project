package com.etiya.ecommercedemo3.business.abstracts;

import com.etiya.ecommercedemo3.entities.concretes.Address;

import java.util.List;

public interface AddressService {
    List<Address> getAll();
    Address getById(int id);
    List<Address> getAllAddressByTitle(String title);
    Address findByDescription(String description);
}
