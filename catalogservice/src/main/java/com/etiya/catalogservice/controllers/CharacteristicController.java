package com.etiya.catalogservice.controllers;

import com.etiya.catalogservice.services.abstracts.CharacteristicService;
import com.etiya.catalogservice.services.dtos.requests.characteristicRequests.CreateCharacteristicRequest;
import com.etiya.catalogservice.services.dtos.requests.characteristicRequests.UpdateCharacteristicRequest;
import com.etiya.catalogservice.services.dtos.responses.characteristicResponses.*;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin()
@RequestMapping("api/v1/characteristic")
public class CharacteristicController {
    private CharacteristicService characteristicService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Add")
    public CreatedCharacteristicResponse add (@Valid @RequestBody CreateCharacteristicRequest createCharacteristicRequest){
        return characteristicService.add(createCharacteristicRequest);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "getAll")
    public List<GetAllCharacteristicResponse> getAll(){
        return characteristicService.getAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "getById")
    public GetCharacteristicResponse getById(@PathVariable String id){
        return characteristicService.getById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Update")
    public UpdatedCharacteristicResponse update(@Valid @RequestBody UpdateCharacteristicRequest updateCharacteristicRequest,
                                                @PathVariable String id){
        return characteristicService.update(updateCharacteristicRequest, id);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete")
    @ResponseStatus(HttpStatus.OK)
    public DeletedCharacteristicResponse delete(@PathVariable String id){
        return characteristicService.delete(id);
    }
}
