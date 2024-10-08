package com.riwi.Performance_test.application.servicies.generics;

public interface GetById<T,ID> {

    T getById(ID id);
}
