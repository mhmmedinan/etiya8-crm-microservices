package com.etiya.authservice.services.dtos;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest {
    private String password;
    private String email;
}
