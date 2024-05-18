package com.etiyacrm.customerservice.services.concretes;

import com.etiyacrm.customerservice.core.business.paging.PageInfo;
import com.etiyacrm.customerservice.core.business.paging.PageInfoResponse;
import com.etiyacrm.customerservice.entities.City;
import com.etiyacrm.customerservice.repositories.CityRepository;
import com.etiyacrm.customerservice.services.abstracts.CityService;
import com.etiyacrm.customerservice.services.dtos.requests.cityRequests.CreateCityRequest;
import com.etiyacrm.customerservice.services.dtos.requests.cityRequests.UpdateCityRequest;
import com.etiyacrm.customerservice.services.dtos.responses.cityresponses.*;
import com.etiyacrm.customerservice.services.mappers.CityMapper;
import com.etiyacrm.customerservice.services.rules.CityBusinessRules;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CityServiceImpl implements CityService {
    private CityRepository cityRepository;
    private CityBusinessRules cityBusinessRules;
    @Override
    public PageInfoResponse<GetAllCityResponse> getAllPage(PageInfo pageInfo) {
        Pageable pageable = PageRequest.of(pageInfo.getPage(), pageInfo.getSize());
        Page<City> response =  cityRepository.findAll(pageable);
        Page<GetAllCityResponse> responsePage = response
                .map(city -> CityMapper.INSTANCE.getAllCityResponseFromCity(city));
        return new PageInfoResponse<>(responsePage);
    }

    @Override
    public List<GetAllCityResponse> getAll() {
        List<City> cityList = cityRepository.findAll();
        List<GetAllCityResponse> getAllCityResponseList =
                cityList.stream().map(CityMapper.INSTANCE::getAllCityResponseFromCity)
                        .collect(Collectors.toList());

        return getAllCityResponseList;
    }

    @Override
    public GetCityResponse getById(String id) {
        City city = cityRepository.findById(id).get();
        cityBusinessRules.checkIfCityDeleted(city.getDeletedDate());
        GetCityResponse getCityResponse =
                CityMapper.INSTANCE.getCityResponseFromCity(city);

        return getCityResponse;
    }

    @Override
    public CreatedCityResponse add(CreateCityRequest createCityRequest) {
        cityBusinessRules.cityNameCanNotBeDuplicatedWhenInserted(createCityRequest.getName());

        City city =
                CityMapper.INSTANCE.cityFromCreateCityRequest(createCityRequest);
        City createdCity = cityRepository.save(city);

        CreatedCityResponse createdCityResponse =
                CityMapper.INSTANCE.createdCityResponseFromCity(createdCity);

        return  createdCityResponse;
    }

    @Override
    public UpdatedCityResponse update(UpdateCityRequest updateCityRequest, String id) {
        cityBusinessRules.cityNameCanNotBeDuplicatedWhenInserted(updateCityRequest.getName());

        City city =
                CityMapper.INSTANCE.cityFromUpdateCityRequest(updateCityRequest);
        city.setId(id);
        city.setUpdatedDate(LocalDateTime.now());
        City updatedCity = cityRepository.save(city);

        UpdatedCityResponse updatedCityResponse =
                CityMapper.INSTANCE.updatedCityResponseFromCity(updatedCity);

        return updatedCityResponse;
    }

    @Override
    public DeletedCityResponse delete(String id) {
        City city = cityRepository.findById(id).get();
        cityBusinessRules.checkIfCityDeleted(city.getDeletedDate());
        city.setId(id);
        city.setDeletedDate(LocalDateTime.now());
        City deletedCity = cityRepository.save(city);

        DeletedCityResponse deletedCityResponse =
                CityMapper.INSTANCE.deletedCityResponseFromCity(deletedCity);

        deletedCityResponse.setDeletedDate(deletedCity.getDeletedDate());
        return deletedCityResponse;
    }


}