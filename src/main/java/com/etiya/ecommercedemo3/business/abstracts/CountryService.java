package com.etiya.ecommercedemo3.business.abstracts;

import com.etiya.ecommercedemo3.business.dtos.request.country.AddCountryRequest;
import com.etiya.ecommercedemo3.business.dtos.request.customer.AddCustomerRequest;
import com.etiya.ecommercedemo3.business.dtos.response.country.AddCountryResponse;
import com.etiya.ecommercedemo3.business.dtos.response.customer.AddCustomerResponse;

public interface CountryService {
    AddCountryResponse addCountry(AddCountryRequest addCountryRequest);
}
