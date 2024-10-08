package com.riwi.Performance_test.application.servicies.impl;

import com.riwi.Performance_test.application.servicies.IModel.IModelLoads;
import com.riwi.Performance_test.domain.models.LoadsEntity;
import com.riwi.Performance_test.domain.persistence.LoadRepository;
import com.riwi.Performance_test.infrastructure.dtos.request.LoadRequest;
import com.riwi.Performance_test.utils.enums.StatusLoads;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class LoadImpl implements IModelLoads {
    @Autowired
    LoadRepository loadRepository;
    @Override
    public void delete(Long id) {
        loadRepository.deleteById(id);

    }

    @Override
    public List<LoadsEntity> getAll() {
        return loadRepository.findAll();
    }

    @Override
    public LoadsEntity getById(Long id) {
        return loadRepository.findById(id).orElse(null);
    }

    @Override
    public LoadsEntity save(LoadRequest loadRequest) {
        LoadsEntity loadsEntity = LoadsEntity.builder()
                .height(loadRequest.getHeight())
                .width(loadRequest.getWidth())
                .length(loadRequest.getLength())
                .status(loadRequest.getStatus())
                .weight(loadRequest.getWeight())
                .build();
        return loadRepository.save(loadsEntity);
    }


    @Override
    public LoadRequest update(LoadRequest loadRequest, Long id) {
        LoadsEntity loadsEntity =  getById(id);
        loadsEntity.setHeight(loadRequest.getHeight());
        loadsEntity.setWidth(loadRequest.getWidth());
        loadsEntity.setLength(loadRequest.getLength());
        loadsEntity.setStatus(loadRequest.getStatus());
        loadsEntity.setWeight(loadRequest.getWeight());

        loadRepository.save(loadsEntity);
        LoadRequest loadRequest1 = LoadRequest.builder()
                .height(loadsEntity.getHeight())
                .width(loadsEntity.getWidth())
                .length(loadsEntity.getLength())
                .status(loadsEntity.getStatus())
                .weight(loadsEntity.getWeight())
                .build();
        return loadRequest1;
    }
    public Set<LoadsEntity> getLoadsByPalletId(Long palletId) {
        return loadRepository.findByPalletsId(palletId);
    }

    public LoadsEntity updateStatus(Long id, StatusLoads status) {
        Optional<LoadsEntity> optionalLoad = loadRepository.findById(id);
        if (optionalLoad.isPresent()) {
            LoadsEntity load = optionalLoad.get();
            load.setStatus(status);
            return loadRepository.save(load); // Guardar el nuevo estado
        } else {
            throw new RuntimeException("Load not found");
        }
    }

}
