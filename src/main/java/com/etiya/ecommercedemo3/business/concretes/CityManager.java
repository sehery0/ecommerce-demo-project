package com.etiya.ecommercedemo3.business.concretes;

import com.etiya.ecommercedemo3.business.abstracts.CityService;
import com.etiya.ecommercedemo3.business.dtos.request.city.AddCityRequest;
import com.etiya.ecommercedemo3.business.dtos.response.city.AddCityResponse;
import com.etiya.ecommercedemo3.entities.concretes.City;
import com.etiya.ecommercedemo3.repository.abstracts.CityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CityManager implements CityService {
    private CityRepository cityRepository;

    @Override
    public City getById(int id) {
        return cityRepository.findById(id).orElseThrow();
    }

    @Override
    public AddCityResponse addCity(AddCityRequest addCityRequest) {
        City city = new City();
        city.setName(addCityRequest.getName());
        City savedCity = cityRepository.save(city);
        AddCityResponse response = new AddCityResponse(savedCity.getId(), savedCity.getName());
        return response;
    }
}
