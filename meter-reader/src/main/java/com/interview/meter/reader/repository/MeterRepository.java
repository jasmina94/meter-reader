package com.interview.meter.reader.repository;

import com.interview.meter.reader.domain.MeterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeterRepository extends JpaRepository<MeterEntity, Long> {
}
