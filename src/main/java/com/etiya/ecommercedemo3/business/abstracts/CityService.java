package com.etiya.ecommercedemo3.business.abstracts;

import com.etiya.ecommercedemo3.business.dtos.request.city.AddCityRequest;
import com.etiya.ecommercedemo3.business.dtos.response.city.AddCityResponse;

public interface CityService {
    AddCityResponse addCity(AddCityRequest addCityRequest);
}
