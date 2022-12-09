package com.etiya.ecommercedemo3.api.controllers;

import com.etiya.ecommercedemo3.business.abstracts.StreetService;
import com.etiya.ecommercedemo3.business.constants.Paths;
import com.etiya.ecommercedemo3.business.dtos.request.country.AddCountryRequest;
import com.etiya.ecommercedemo3.business.dtos.request.street.AddStreetRequest;
import com.etiya.ecommercedemo3.business.dtos.response.country.AddCountryResponse;
import com.etiya.ecommercedemo3.business.dtos.response.street.AddStreetResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Paths.apiPrefix + "streets")
@AllArgsConstructor
public class StreetsController {
    private StreetService streetService;

    @PostMapping("/add")
    public ResponseEntity<AddStreetResponse> addStreet(@RequestBody AddStreetRequest addStreetRequest)
    {
        return new ResponseEntity<AddStreetResponse>(streetService.addStreet(addStreetRequest), HttpStatus.CREATED);
    }
}
