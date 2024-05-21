package com.etiya.authservice.services.concretes;

import com.etiya.authservice.entities.User;
import com.etiya.authservice.repositories.UserRepository;
import com.etiya.authservice.services.abstracts.UserService;
import com.etiya.authservice.services.dtos.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username).orElseThrow(() -> new AccessDeniedException("Giriş başarısız."));
    }

    @Override
    public void add(RegisterRequest request) {
        User user = new User();
        user.setEmail(request.getEmail());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        userRepository.save(user);
    }
}
