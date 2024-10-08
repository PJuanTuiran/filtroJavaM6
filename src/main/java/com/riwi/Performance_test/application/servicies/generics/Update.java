package com.riwi.Performance_test.application.servicies.generics;

public interface Update <T, ID> {
    T update(T t, ID id);
}
