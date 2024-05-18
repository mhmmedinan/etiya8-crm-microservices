package com.etiya.catalogservice.controllers;

import com.etiya.catalogservice.services.abstracts.CharacteristicValueService;
import com.etiya.catalogservice.services.dtos.requests.characteristicValueRequests.CreateCharacteristicValueRequest;
import com.etiya.catalogservice.services.dtos.requests.characteristicValueRequests.UpdateCharacteristicValueRequest;
import com.etiya.catalogservice.services.dtos.responses.characteristicValueResponses.*;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin()
@RequestMapping("api/v1/characteristic-value")
public class CharacteristicValueController {
    private CharacteristicValueService characteristicValueService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Add")
    public CreatedCharacteristicValueResponse add (@Valid @RequestBody CreateCharacteristicValueRequest createCharacteristicValueRequest){
        return characteristicValueService.add(createCharacteristicValueRequest);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "getAll")
    public List<GetAllCharacteristicValueResponse> getAll(){
        return characteristicValueService.getAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "getById")
    public GetCharacteristicValueResponse getById(@PathVariable String id){
        return characteristicValueService.getById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Update")
    public UpdatedCharacteristicValueResponse update(@Valid @RequestBody UpdateCharacteristicValueRequest updateCharacteristicValueRequest,
                                                     @PathVariable String id){
        return characteristicValueService.update(updateCharacteristicValueRequest, id);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete")
    @ResponseStatus(HttpStatus.OK)
    public DeletedCharacteristicValueResponse delete(@PathVariable String id){
        return characteristicValueService.delete(id);
    }
}
