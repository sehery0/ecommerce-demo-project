package com.etiya.ecommercedemo3.business.concretes;

import com.etiya.ecommercedemo3.business.abstracts.StreetService;
import com.etiya.ecommercedemo3.business.dtos.request.street.AddStreetRequest;
import com.etiya.ecommercedemo3.business.dtos.response.street.AddStreetResponse;
import com.etiya.ecommercedemo3.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemo3.entities.concretes.Street;
import com.etiya.ecommercedemo3.repository.abstracts.StreetRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class StreetManager implements StreetService {
    private StreetRepository streetRepository;
    private ModelMapperService modelMapperService;

    @Override
    public Street getById(int id) {
        return streetRepository.findById(id).orElseThrow();
    }

    @Override
    public AddStreetResponse addStreet(AddStreetRequest addStreetRequest) {
//        Street street = new Street();
//        street.setName(addStreetRequest.getName());
        Street street=modelMapperService.getMapperRequest().map(addStreetRequest,Street.class);
        Street savedStreet = streetRepository.save(street);
//        AddStreetResponse response = new AddStreetResponse(savedStreet.getId(),
//                savedStreet.getName());
        AddStreetResponse response=modelMapperService.getMapperResponse().map(savedStreet,AddStreetResponse.class);
        return response;
    }
}
