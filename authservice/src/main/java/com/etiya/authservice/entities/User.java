package com.etiya.authservice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Set;


@Table(name="users")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User implements UserDetails {
    @Column(name="id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="password")
    private String password;
    @Column(name="email")
    private String email;
    @Column(name="firstName")
    private String firstName;  //user_id => 1   //role_id =>1 name="admin"
    @Column(name="lastName")
    private String lastName;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name="user_roles",
            joinColumns = @JoinColumn(name="user_id"),  //1
            inverseJoinColumns = @JoinColumn(name="role_id")  //1
    )
    private Set<Role> authorities;


    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

