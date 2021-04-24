package com.interview.meter.reader.repository;

import com.interview.meter.reader.domain.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<ClientEntity, Long> {

    ClientEntity findFirstByFirstName(String firstName);
}
