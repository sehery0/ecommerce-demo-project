package com.etiya.ecommercedemo3.api.controllers;

import com.etiya.ecommercedemo3.business.abstracts.CityService;
import com.etiya.ecommercedemo3.business.constants.Paths;
import com.etiya.ecommercedemo3.business.dtos.request.city.AddCityRequest;
import com.etiya.ecommercedemo3.business.dtos.response.city.AddCityResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Paths.apiPrefix + "cities")
@AllArgsConstructor
public class CitiesController {
    CityService cityService;
    @PostMapping("/add")
    public ResponseEntity<AddCityResponse> addCity(@RequestBody AddCityRequest addCityRequest)
    {
        return  new ResponseEntity<>(cityService.addCity(addCityRequest), HttpStatus.CREATED);
    }
}
