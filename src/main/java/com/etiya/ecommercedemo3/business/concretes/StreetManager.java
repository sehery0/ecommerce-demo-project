package com.etiya.ecommercedemo3.business.concretes;

import com.etiya.ecommercedemo3.business.abstracts.StreetService;
import com.etiya.ecommercedemo3.business.constants.Messages;
import com.etiya.ecommercedemo3.business.dtos.request.street.AddStreetRequest;
import com.etiya.ecommercedemo3.business.dtos.response.street.AddStreetResponse;
import com.etiya.ecommercedemo3.business.dtos.response.street.GetAllStreetsResponse;
import com.etiya.ecommercedemo3.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemo3.core.util.results.DataResult;
import com.etiya.ecommercedemo3.core.util.results.SuccessDataResult;
import com.etiya.ecommercedemo3.entities.concretes.Street;
import com.etiya.ecommercedemo3.repository.abstracts.StreetRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StreetManager implements StreetService {
    private StreetRepository streetRepository;
    private ModelMapperService modelMapperService;

    @Override
    public DataResult<Street> getById(int id) {
        Street response = streetRepository.findById(id).orElseThrow();
        return new SuccessDataResult<Street>(response, Messages.Street.streetGetByIdSuccessMessage);
    }

    @Override
    public DataResult<AddStreetResponse> addStreet(AddStreetRequest addStreetRequest) {
//        Street street = new Street();
//        street.setName(addStreetRequest.getName());
        Street street=modelMapperService.getMapperRequest().map(addStreetRequest,Street.class);
        Street savedStreet = streetRepository.save(street);
//        AddStreetResponse response = new AddStreetResponse(savedStreet.getId(),
//                savedStreet.getName());
        AddStreetResponse response=modelMapperService.getMapperResponse().map(savedStreet,AddStreetResponse.class);
        return new SuccessDataResult<AddStreetResponse>(response, Messages.Street.streetAddSuccessMessage);
    }

    @Override
    public DataResult<List<GetAllStreetsResponse>> getAllDto() {
        List<GetAllStreetsResponse> response= streetRepository.getAllDto();
        return new SuccessDataResult<List<GetAllStreetsResponse>>(response,"Sokak listelendi");
    }
}
