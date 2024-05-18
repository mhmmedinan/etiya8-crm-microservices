package com.etiya.catalogservice.services.abstracts;



import com.etiya.catalogservice.services.dtos.requests.characteristicValueRequests.CreateCharacteristicValueRequest;
import com.etiya.catalogservice.services.dtos.requests.characteristicValueRequests.UpdateCharacteristicValueRequest;
import com.etiya.catalogservice.services.dtos.responses.characteristicValueResponses.*;

import java.util.List;

public interface CharacteristicValueService {
    CreatedCharacteristicValueResponse add(CreateCharacteristicValueRequest createCharacteristicValueRequest);
    UpdatedCharacteristicValueResponse update(UpdateCharacteristicValueRequest updateCharacteristicValueRequest, String id);
    List<GetAllCharacteristicValueResponse> getAll();
    GetCharacteristicValueResponse getById(String id);
    DeletedCharacteristicValueResponse delete(String id);
}
