package com.etiya.catalogservice.services.concretes;

import com.etiya.catalogservice.entities.CharacteristicValue;
import com.etiya.catalogservice.repositories.CharacteristicValueRepository;
import com.etiya.catalogservice.services.abstracts.CharacteristicValueService;
import com.etiya.catalogservice.services.dtos.requests.characteristicValueRequests.CreateCharacteristicValueRequest;
import com.etiya.catalogservice.services.dtos.requests.characteristicValueRequests.UpdateCharacteristicValueRequest;
import com.etiya.catalogservice.services.dtos.responses.characteristicValueResponses.*;
import com.etiya.catalogservice.services.mappers.CharacteristicValueMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CharacteristicValueServiceImpl implements CharacteristicValueService {
    private CharacteristicValueRepository characteristicValueRepository;

    @Override
    public CreatedCharacteristicValueResponse add(CreateCharacteristicValueRequest createCharacteristicValueRequest) {
        CharacteristicValue characteristicValue =
                CharacteristicValueMapper.INSTANCE.characteristicValueFromCreateCharacteristicValueRequest(createCharacteristicValueRequest);
        CharacteristicValue createdCharacteristicValue = characteristicValueRepository.save(characteristicValue);

        CreatedCharacteristicValueResponse createdCharacteristicValueResponse =
                CharacteristicValueMapper.INSTANCE.createdCharacteristicValueResponseFromCharacteristicValue(createdCharacteristicValue);

        return createdCharacteristicValueResponse;
    }

    @Override
    public UpdatedCharacteristicValueResponse update(UpdateCharacteristicValueRequest updateCharacteristicValueRequest, String id) {
        CharacteristicValue characteristicValue =
                CharacteristicValueMapper.INSTANCE.characteristicValueFromUpdateCharacteristicValueRequest(updateCharacteristicValueRequest);
        characteristicValue.setId(id);
        characteristicValue.setUpdatedDate(LocalDateTime.now());
        CharacteristicValue updatedCharacteristicValue = characteristicValueRepository.save(characteristicValue);

        UpdatedCharacteristicValueResponse updatedCharacteristicValueResponse =
                CharacteristicValueMapper.INSTANCE.updatedCharacteristicValueResponseFromCharacteristicValue(updatedCharacteristicValue);

        return updatedCharacteristicValueResponse;
    }

    @Override
    public List<GetAllCharacteristicValueResponse> getAll() {
        List<CharacteristicValue> characteristicValueList = characteristicValueRepository.findAll();
        List<GetAllCharacteristicValueResponse> getAllCharacteristicValueResponseList =
                characteristicValueList.stream().map(CharacteristicValueMapper.INSTANCE::getAllCharacteristicValueResponseFromCharacteristicValue)
                        .collect(Collectors.toList());

        return getAllCharacteristicValueResponseList;
    }

    @Override
    public GetCharacteristicValueResponse getById(String id) {
        CharacteristicValue characteristicValue = characteristicValueRepository.findById(id).get();
        GetCharacteristicValueResponse getCharacteristicValueResponse =
                CharacteristicValueMapper.INSTANCE.getCharacteristicValueResponseFromCharacteristicValue(characteristicValue);

        return getCharacteristicValueResponse;
    }

    @Override
    public DeletedCharacteristicValueResponse delete(String id) {
        CharacteristicValue characteristicValue = characteristicValueRepository.findById(id).get();
        characteristicValue.setId(id);
        characteristicValue.setDeletedDate(LocalDateTime.now());
        CharacteristicValue deletedCharacteristicValue = characteristicValueRepository.save(characteristicValue);
        DeletedCharacteristicValueResponse deletedCharacteristicValueResponse =
                CharacteristicValueMapper.INSTANCE.deletedCharacteristicValueResponseFromCharacteristicValue(deletedCharacteristicValue);

        return deletedCharacteristicValueResponse;
    }
}
