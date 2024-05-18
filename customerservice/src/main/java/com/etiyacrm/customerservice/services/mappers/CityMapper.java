package com.etiyacrm.customerservice.services.mappers;

import com.etiyacrm.customerservice.entities.City;
import com.etiyacrm.customerservice.services.dtos.requests.cityRequests.CreateCityRequest;
import com.etiyacrm.customerservice.services.dtos.requests.cityRequests.UpdateCityRequest;
import com.etiyacrm.customerservice.services.dtos.responses.cityresponses.*;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CityMapper {
    CityMapper INSTANCE = Mappers.getMapper(CityMapper.class);

    GetAllCityResponse getAllCityResponseFromCity(City city);
    City cityFromCreateCityRequest(CreateCityRequest createCityRequest);
    CreatedCityResponse createdCityResponseFromCity(City city);
    City cityFromUpdateCityRequest(UpdateCityRequest updateCityRequest);
    UpdatedCityResponse updatedCityResponseFromCity(City city);
    DeletedCityResponse deletedCityResponseFromCity(City city);
    GetCityResponse getCityResponseFromCity(City city);

}