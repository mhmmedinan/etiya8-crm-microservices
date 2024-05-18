package com.etiyacrm.customerservice.services.concretes;

import com.etiyacrm.customerservice.core.business.paging.PageInfo;
import com.etiyacrm.customerservice.core.business.paging.PageInfoResponse;
import com.etiyacrm.customerservice.entities.City;
import com.etiyacrm.customerservice.entities.District;
import com.etiyacrm.customerservice.repositories.DistrictRepository;
import com.etiyacrm.customerservice.services.abstracts.DistrictService;
import com.etiyacrm.customerservice.services.dtos.requests.districtRequests.CreateDistrictRequest;
import com.etiyacrm.customerservice.services.dtos.requests.districtRequests.UpdateDistrictRequest;
import com.etiyacrm.customerservice.services.dtos.responses.districtResponses.*;
import com.etiyacrm.customerservice.services.mappers.DistrictMapper;
import com.etiyacrm.customerservice.services.rules.DistrictBusinessRules;
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
public class DistrictServiceImpl implements DistrictService {
    private DistrictRepository districtRepository;
    private DistrictBusinessRules districtBusinessRules;

    @Override
    public PageInfoResponse<GetAllDistrictResponse> getAllPage(PageInfo pageInfo) {
        Pageable pageable = PageRequest.of(pageInfo.getPage(), pageInfo.getSize());
        Page<District> response = districtRepository.findAll(pageable);
        Page<GetAllDistrictResponse> responsePage = response
                .map(district -> DistrictMapper.INSTANCE.getAllDistrictResponse(district));
        return new PageInfoResponse<>(responsePage);
    }

    @Override
    public List<GetAllDistrictResponse> getAll() {
        List<District> districtList = districtRepository.findAll();
        List<GetAllDistrictResponse> getAllDistrictResponseList =
                districtList.stream().map(DistrictMapper.INSTANCE::getAllDistrictResponse)
                        .collect(Collectors.toList());
        return getAllDistrictResponseList;
    }

    @Override
    public GetDistrictResponse getById(String id) {
        District district = districtRepository.findById(id).get();
        System.out.println(id);
        GetDistrictResponse response = DistrictMapper.INSTANCE.getDistrictResponseFromDistrict(district);
        response.setCityId(district.getCity().getId());
        return response;
    }

    @Override
    public CreatedDistrictResponse add(CreateDistrictRequest createDistrictRequest) {
        District district = DistrictMapper.INSTANCE.districtFromCreateDistrictRequest(createDistrictRequest);

        City city = new City();
        city.setId(createDistrictRequest.getCityId());
        district.setCity(city);
        District createdDistrict = districtRepository.save(district);

        CreatedDistrictResponse createdDistrictResponse = DistrictMapper.INSTANCE.createdDistrictResponseFromDistrict(createdDistrict);
        createdDistrictResponse.setCityId(city.getId());
        return createdDistrictResponse;
    }

    @Override
    public UpdatedDistrictResponse update(UpdateDistrictRequest updateDistrictRequest, String id) {
        //rule eklenecek

        District district =DistrictMapper.INSTANCE.districtFromUpdateDistrictRequest(updateDistrictRequest);
        district.setId(id);
        district.setUpdatedDate(LocalDateTime.now());
        District updatedDistrict = districtRepository.save(district);

        UpdatedDistrictResponse updatedDistrictResponse = DistrictMapper.INSTANCE.updatedDistrictResponseFromDistrict(updatedDistrict);
        return updatedDistrictResponse;
    }

    @Override
    public DeletedDistrictResponse delete(String id) {

        District district = districtRepository.findById(id).get();
        districtBusinessRules.checkIfDistrictDeleted(district.getDeletedDate());
        district.setId(id);
        district.setDeletedDate(LocalDateTime.now());
        District deletedDistrict = districtRepository.save(district);

        DeletedDistrictResponse deletedDistrictResponse = DistrictMapper.INSTANCE.deletedDistrictResponseFromDistrict(deletedDistrict);
        deletedDistrictResponse.setDeletedDate(deletedDistrict.getDeletedDate());
        return deletedDistrictResponse;
    }



}
