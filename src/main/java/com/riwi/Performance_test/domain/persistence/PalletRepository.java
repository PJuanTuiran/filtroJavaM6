package com.riwi.Performance_test.domain.persistence;

import com.riwi.Performance_test.domain.models.PalletsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PalletRepository extends JpaRepository<PalletsEntity, Long> {
}
