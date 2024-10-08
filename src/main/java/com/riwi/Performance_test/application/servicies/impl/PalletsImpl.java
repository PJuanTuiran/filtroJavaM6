package com.riwi.Performance_test.application.servicies.impl;

import com.riwi.Performance_test.application.servicies.IModel.IModalPallets;
import com.riwi.Performance_test.domain.models.PalletsEntity;
import com.riwi.Performance_test.domain.persistence.PalletRepository;
import com.riwi.Performance_test.infrastructure.dtos.request.PalletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PalletsImpl implements IModalPallets {
    @Autowired
    PalletRepository palletRepository;

    @Override
    public void delete(Long id) {
        palletRepository.deleteById(id);


    }

    @Override
    public List<PalletsEntity> getAll() {
        return palletRepository.findAll();
    }

    @Override
    public PalletsEntity getById(Long id) {
        return palletRepository.findById(id).orElseThrow(() -> new RuntimeException("Pallet not found"));
    }

    @Override
    public PalletsEntity save(PalletRequest palletRequest) {
        PalletsEntity palletsEntity = PalletsEntity.builder()
                .maxCapacity(palletRequest.getMaxWeight())
                .location(palletRequest.getLocation())
                .status(palletRequest.getStatus())
                .build();
        return palletRepository.save(palletsEntity);
    }

    @Override
    public PalletRequest update(PalletRequest palletRequest, Long id) {
        PalletsEntity palletsEntity = getById(id);
        palletsEntity.setMaxCapacity(palletRequest.getMaxWeight());
        palletsEntity.setLocation(palletRequest.getLocation());
        palletsEntity.setStatus(palletRequest.getStatus());

        palletRepository.save(palletsEntity);
        PalletRequest palletRequest1 = PalletRequest.builder()
                .maxWeight(palletsEntity.getMaxCapacity())
                .location(palletsEntity.getLocation())
                .status(palletsEntity.getStatus())
                .build();
        return palletRequest1;
    }
}

