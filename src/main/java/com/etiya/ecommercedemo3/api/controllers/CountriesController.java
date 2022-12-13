package com.etiya.ecommercedemo3.api.controllers;

import com.etiya.ecommercedemo3.business.abstracts.CountryService;
import com.etiya.ecommercedemo3.business.constants.Paths;
import com.etiya.ecommercedemo3.business.dtos.request.country.AddCountryRequest;
import com.etiya.ecommercedemo3.business.dtos.response.country.AddCountryResponse;
import com.etiya.ecommercedemo3.core.util.results.DataResult;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Paths.apiPrefix + "countries")
@AllArgsConstructor
public class CountriesController {
    private CountryService countryService;

    @PostMapping("/add")
    public ResponseEntity<DataResult<AddCountryResponse>> addCountry(@RequestBody AddCountryRequest addCountryRequest)
    {
        return new ResponseEntity<>(countryService.addCountry(addCountryRequest), HttpStatus.CREATED);
    }
}
