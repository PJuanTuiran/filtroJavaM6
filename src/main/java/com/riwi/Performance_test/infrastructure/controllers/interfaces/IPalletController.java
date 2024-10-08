package com.riwi.Performance_test.infrastructure.controllers.interfaces;

import com.riwi.Performance_test.domain.models.PalletsEntity;
import com.riwi.Performance_test.infrastructure.controllers.generics.*;
import com.riwi.Performance_test.infrastructure.dtos.request.PalletRequest;

public interface IPalletController extends Save<PalletRequest> , GetById<PalletsEntity, Long>, GetAll<PalletsEntity>, Delete<Long>, Update<PalletRequest, Long> {
}
