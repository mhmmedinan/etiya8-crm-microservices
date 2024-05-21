package com.etiya.authservice.services.dtos;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    private String password;
    private String email;
    private String firstName;
    private String lastName;
}