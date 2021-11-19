package com.example.blogspring.data;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Setter
@Getter
@Entity
@Table(name = "Users")
public class User{

    @Id
    @GeneratedValue
    @Column(columnDefinition = "VARCHAR(36)", updatable = false)
    @Type(type = "uuid-char")
    private UUID id;
    private String name;
    private String surname;
    private String userName;
    private String password;
    private String repeatPassword;
}
