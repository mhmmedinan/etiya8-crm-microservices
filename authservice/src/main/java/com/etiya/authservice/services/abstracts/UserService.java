package com.etiya.authservice.services.abstracts;

import com.etiya.authservice.services.dtos.RegisterRequest;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    void add(RegisterRequest request);
}
