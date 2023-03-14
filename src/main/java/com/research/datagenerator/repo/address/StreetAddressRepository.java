package com.research.datagenerator.repo.address;

import com.research.datagenerator.entity.address.State;
import com.research.datagenerator.entity.address.StreetAddress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StreetAddressRepository extends JpaRepository<StreetAddress, Long> {
}