package com.etiya.ecommercedemo3.business.concretes;

import com.etiya.ecommercedemo3.business.abstracts.*;
import com.etiya.ecommercedemo3.business.constants.Messages;
import com.etiya.ecommercedemo3.business.dtos.request.address.AddAddressRequest;
import com.etiya.ecommercedemo3.business.dtos.response.address.AddAddressResponse;
import com.etiya.ecommercedemo3.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemo3.entities.concretes.*;
import com.etiya.ecommercedemo3.repository.abstracts.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AddressManager implements AddressService {
    private AddressRepository addressRepository;
    private StreetRepository streetRepository;
    private CustomerRepository customerRepository;
    private ModelMapperService modelMapperService;


    @Override
    public List<Address> getAll() {
        return addressRepository.findAll();
    }

    @Override
    public Address getById(int id) {
        return addressRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Address> getAllAddressByTitle(String title) {
        return addressRepository.findAllAddressByTitle(title);
    }

    @Override
    public Address findByDescription(String description) {
        return addressRepository.findByDescription(description);
    }

    @Override
    public AddAddressResponse addAddress(AddAddressRequest addAddressRequest) {
//        Address address = new Address();
//        address.setTitle(addAddressRequest.getTitle());
//        address.setDescription(addAddressRequest.getDescription());
//        checkIfCityExists(addAddressRequest.getCityId());
//        City city = cityService.getById(addAddressRequest.getCityId());
//        address.setCity(city);
//        checkIfCountryExists(addAddressRequest.getCountryId());
//        Country country = countryService.getById(addAddressRequest.getCountryId());
//        address.setCountry(country);
        checkIfStreetExists(addAddressRequest.getStreetId());
//        Street street = streetService.getById(addAddressRequest.getStreetId());
//        address.setStreet(street);
        checkIfCustomerExists(addAddressRequest.getCustomerId());
        Address address= modelMapperService.getMapperRequest().map(addAddressRequest,Address.class);
//        Customer customer = customerService.getById(addAddressRequest.getCustomerId());
//        address.setCustomer(customer);

        Address savedAddress = addressRepository.save(address);
//        AddAddressResponse response = new AddAddressResponse(savedAddress.getId(), savedAddress.getTitle(), savedAddress.getDescription(), savedAddress.getCity().getId(),savedAddress.getCountry().getId(),savedAddress.getStreet().getId(),savedAddress.getCustomer().getId());
        AddAddressResponse response= modelMapperService.getMapperResponse().map(savedAddress,AddAddressResponse.class);
        return response;
    }

    private void checkIfStreetExists(int id){
        boolean isExists = streetRepository.existsById(id);
        if(!isExists) {
            throw new RuntimeException(Messages.Street.StreetNotExistWithId);
        }
    }

    private void checkIfCustomerExists(int id){
        boolean isExists = customerRepository.existsById(id);
        if(!isExists) {
            throw new RuntimeException(Messages.Customer.CustomerNotExistWithId);
        }
    }

    //    private void checkIfCityExists(int id){
//        boolean isExists = cityRepository.existsById(id);
//        if(!isExists) {
//            throw new RuntimeException(Messages.City.CityNotExistWithId);
//        }
//    }

//    private void checkIfCountryExists(int id){
//        boolean isExists = countryRepository.existsById(id);
//        if(!isExists) {
//            throw new RuntimeException(Messages.Country.CountryNotExistWithId);
//        }
//    }


}
