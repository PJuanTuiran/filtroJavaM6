package com.riwi.Performance_test.domain.models;

import com.riwi.Performance_test.utils.enums.Roles;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity(name = "users")
@Getter
@Setter
@Builder
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastName;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private Roles roles;
    @OneToMany(mappedBy = "user")
    private Set<PalletsEntity> pallets;
    @OneToMany(mappedBy = "user")
    private Set<LoadsEntity> loads;
}
