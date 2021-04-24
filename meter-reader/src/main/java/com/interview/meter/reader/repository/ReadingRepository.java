package com.interview.meter.reader.repository;

import com.interview.meter.reader.domain.ReadingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReadingRepository extends JpaRepository<ReadingEntity, Long> {
}
