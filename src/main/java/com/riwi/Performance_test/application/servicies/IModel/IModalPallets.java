package com.riwi.Performance_test.application.servicies.IModel;

import com.riwi.Performance_test.application.servicies.generics.*;
import com.riwi.Performance_test.domain.models.PalletsEntity;
import com.riwi.Performance_test.infrastructure.dtos.request.PalletRequest;

public interface IModalPallets extends Save<PalletsEntity, PalletRequest>, GetAll<PalletsEntity>, GetById<PalletsEntity, Long>, Delete<Long>, Update< PalletRequest, Long> {
}
