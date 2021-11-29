package com.example.blogspring.data;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Setter
@Getter
@Entity
@NoArgsConstructor
@Table(name="users")
public class User implements UserDetails {
    private String username;
    private String name;
    private String surname;
    private String country;
    private String city;
    private String street;
    private String zipCode;
    private String phone;
    private String password;
    @Id
    @GeneratedValue
    @Column(columnDefinition = "VARCHAR(36)", updatable = false)
    @Type(type = "uuid-char")
    private UUID id;


    public User(String username, String password, String name, String surname, String country, String city, String street, String zipCode, String phone, Set<Role> roles) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.country = country;
        this.city = city;
        this.street = street;
        this.zipCode = zipCode;
        this.phone = phone;
        this.roles = roles;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("USER"));
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
    public String getFullName(){
        return String.format("%s %s", name, surname);
    }
}
