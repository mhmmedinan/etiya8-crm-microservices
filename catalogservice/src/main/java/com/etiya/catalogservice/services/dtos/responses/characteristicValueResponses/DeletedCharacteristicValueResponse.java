package com.etiya.catalogservice.services.dtos.responses.characteristicValueResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeletedCharacteristicValueResponse {
    private String id;
    private LocalDateTime deletedDate;
}
