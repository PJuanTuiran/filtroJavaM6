package com.riwi.Performance_test.domain.models;

import com.riwi.Performance_test.utils.enums.StatusPallets;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity(name = "pallets")
@Getter
@Setter
@Builder
public class PalletsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int maxCapacity;

    private String location;

    @Enumerated(EnumType.STRING)
    private StatusPallets status;

    @OneToMany(mappedBy = "pallets")
    private Set<LoadsEntity> loads;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity user;
}
