package com.etiya.ecommercedemo3.business.abstracts;

import com.etiya.ecommercedemo3.business.dtos.request.street.AddStreetRequest;
import com.etiya.ecommercedemo3.business.dtos.response.street.AddStreetResponse;
import com.etiya.ecommercedemo3.entities.concretes.Street;

public interface StreetService {
    Street getById(int id);
    AddStreetResponse addStreet(AddStreetRequest addStreetRequest);
}
