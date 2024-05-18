package com.etiya.common.events.customers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDeletedEvent {
    private String id;
    private LocalDateTime deletedDate;
}
