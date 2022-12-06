package com.etiya.ecommercedemo3.business.abstracts;

import com.etiya.ecommercedemo3.business.dtos.request.country.AddCountryRequest;
import com.etiya.ecommercedemo3.business.dtos.response.country.AddCountryResponse;
import com.etiya.ecommercedemo3.entities.concretes.Country;


public interface CountryService {
    Country getById(int id);
    AddCountryResponse addCountry(AddCountryRequest addCountryRequest);
}
