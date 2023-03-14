package com.research.datagenerator.repo.address;

import com.research.datagenerator.entity.address.StreetAddress;
import com.research.datagenerator.entity.address.StreetAddressNumber;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StreetAddressNumberRepository extends JpaRepository<StreetAddressNumber, Long> {
}