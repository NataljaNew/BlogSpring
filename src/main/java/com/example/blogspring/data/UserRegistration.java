package com.example.blogspring.data;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
//@FieldComparator(firstField = "password", secondField = "repeatPassword")
public class UserRegistration {
    @NotBlank
    private String name;
    @NotBlank
    private String surname;
    @NotBlank
    private String username;
    @NotBlank
    private String country;
    @NotBlank
    private String city;
    @NotBlank
    private String street;
    @NotBlank
    private String zipCode;
    @NotBlank
    private String phone;
    @NotBlank
    @Min(8)
    private String password;
    @NotBlank
    @Min(8)
    private String repeatPassword;
}
