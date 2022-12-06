package com.etiya.ecommercedemo3.business.concretes;

import com.etiya.ecommercedemo3.business.abstracts.CountryService;
import com.etiya.ecommercedemo3.business.dtos.request.country.AddCountryRequest;
import com.etiya.ecommercedemo3.business.dtos.response.country.AddCountryResponse;
import com.etiya.ecommercedemo3.entities.concretes.Country;
import com.etiya.ecommercedemo3.repository.abstracts.CountryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CountryManager implements CountryService {
    private CountryRepository countryRepository;
    @Override
    public AddCountryResponse addCountry(AddCountryRequest addCountryRequest) {
        Country country = new Country();
        country.setName(addCountryRequest.getName());
        Country savedCountry = countryRepository.save(country);
        AddCountryResponse response = new AddCountryResponse(savedCountry.getId(), savedCountry.getName());
        return response;
    }
}
