package com.etiya.ecommercedemo3.business.abstracts;

import com.etiya.ecommercedemo3.business.dtos.request.city.AddCityRequest;
import com.etiya.ecommercedemo3.business.dtos.response.city.AddCityResponse;
import com.etiya.ecommercedemo3.entities.concretes.City;
import com.etiya.ecommercedemo3.entities.concretes.Product;

public interface CityService {
    City getById(int id);
    AddCityResponse addCity(AddCityRequest addCityRequest);
}
