package com.etiya.catalogservice.services.dtos.responses.characteristicResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeletedCharacteristicResponse {
    private String id;
    private LocalDateTime deletedDate;
}
