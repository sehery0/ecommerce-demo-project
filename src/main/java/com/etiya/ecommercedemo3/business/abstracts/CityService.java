package com.etiya.ecommercedemo3.business.abstracts;

import com.etiya.ecommercedemo3.business.dtos.request.city.AddCityRequest;
import com.etiya.ecommercedemo3.business.dtos.response.city.AddCityResponse;
import com.etiya.ecommercedemo3.core.util.results.DataResult;
import com.etiya.ecommercedemo3.entities.concretes.City;
import com.etiya.ecommercedemo3.entities.concretes.Product;

public interface CityService {
    DataResult<City> getById(int id);
    DataResult<AddCityResponse> addCity(AddCityRequest addCityRequest);
}
