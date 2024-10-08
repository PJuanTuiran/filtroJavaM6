package com.riwi.Performance_test.domain.models;

import com.riwi.Performance_test.utils.enums.StatusLoads;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity(name = "Loads")
@Getter
@Setter
@Builder
public class LoadsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double weight;
    private Double height;
    private Double width;
    private Double length;
    @Enumerated(EnumType.STRING)
    private StatusLoads status;
    @ManyToOne
    @JoinColumn(name = "pallets_id")
    private PalletsEntity pallets;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity user;
}
