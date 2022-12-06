package com.etiya.ecommercedemo3.business.abstracts;

import com.etiya.ecommercedemo3.business.dtos.request.country.AddCountryRequest;
import com.etiya.ecommercedemo3.business.dtos.request.street.AddStreetRequest;
import com.etiya.ecommercedemo3.business.dtos.response.country.AddCountryResponse;
import com.etiya.ecommercedemo3.business.dtos.response.street.AddStreetResponse;

public interface StreetService {
    AddStreetResponse addStreet(AddStreetRequest addStreetRequest);
}
