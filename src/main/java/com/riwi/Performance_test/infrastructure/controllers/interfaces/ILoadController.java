package com.riwi.Performance_test.infrastructure.controllers.interfaces;

import com.riwi.Performance_test.domain.models.LoadsEntity;
import com.riwi.Performance_test.infrastructure.controllers.generics.*;
import com.riwi.Performance_test.infrastructure.dtos.request.LoadRequest;

public interface ILoadController extends Save<LoadRequest>, GetAll<LoadsEntity>, GetById<LoadsEntity, Long>, Delete<Long>, Update<LoadRequest, Long> {

}

