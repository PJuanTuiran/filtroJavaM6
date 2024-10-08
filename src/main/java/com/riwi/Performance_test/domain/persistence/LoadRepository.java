package com.riwi.Performance_test.domain.persistence;

import com.riwi.Performance_test.domain.models.LoadsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface LoadRepository extends JpaRepository<LoadsEntity, Long> {
    Set<LoadsEntity> findByPalletsId(Long palletId);
}
