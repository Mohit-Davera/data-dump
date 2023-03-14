package com.research.datagenerator.repo.address;

import com.research.datagenerator.entity.address.Country;
import com.research.datagenerator.entity.address.FullAddress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FullAddressRepository extends JpaRepository<FullAddress, Long> {
}