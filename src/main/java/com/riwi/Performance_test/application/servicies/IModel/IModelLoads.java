package com.riwi.Performance_test.application.servicies.IModel;

import com.riwi.Performance_test.application.servicies.generics.*;
import com.riwi.Performance_test.domain.models.LoadsEntity;
import com.riwi.Performance_test.infrastructure.dtos.request.LoadRequest;
import com.riwi.Performance_test.utils.enums.StatusLoads;

import java.util.List;
import java.util.Set;

public interface IModelLoads extends Save<LoadsEntity, LoadRequest>, GetAll<LoadsEntity>, GetById<LoadsEntity, Long>, Delete<Long> , Update< LoadRequest, Long> {
    Set<LoadsEntity> getLoadsByPalletId(Long palletId);
    public LoadsEntity updateStatus(Long id, StatusLoads status);
}
