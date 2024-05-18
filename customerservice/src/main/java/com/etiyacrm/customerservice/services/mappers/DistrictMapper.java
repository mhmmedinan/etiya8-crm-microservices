package com.etiyacrm.customerservice.services.mappers;

import com.etiyacrm.customerservice.entities.District;
import com.etiyacrm.customerservice.services.dtos.requests.districtRequests.CreateDistrictRequest;
import com.etiyacrm.customerservice.services.dtos.requests.districtRequests.UpdateDistrictRequest;
import com.etiyacrm.customerservice.services.dtos.responses.districtResponses.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DistrictMapper {

    DistrictMapper INSTANCE = Mappers.getMapper(DistrictMapper.class);

    @Mapping(source = "city.id", target = "cityId")
    GetAllDistrictResponse getAllDistrictResponse(District district);
    District districtFromCreateDistrictRequest(CreateDistrictRequest createDistrictRequest);
    CreatedDistrictResponse createdDistrictResponseFromDistrict(District district);
    @Mapping(source = "cityId", target = "city.name")
    District districtFromUpdateDistrictRequest(UpdateDistrictRequest updateDistrictRequest);
    @Mapping(source = "city.id", target = "cityId")
    UpdatedDistrictResponse updatedDistrictResponseFromDistrict(District district);
    DeletedDistrictResponse deletedDistrictResponseFromDistrict(District district);
    GetDistrictResponse getDistrictResponseFromDistrict(District district);
}
