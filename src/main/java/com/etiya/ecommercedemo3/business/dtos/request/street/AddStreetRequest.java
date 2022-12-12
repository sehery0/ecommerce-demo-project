package com.etiya.ecommercedemo3.business.dtos.request.street;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Positive;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AddStreetRequest {
    private String name;
    private int cityId;
}
