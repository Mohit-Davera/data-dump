package com.research.datagenerator.repo.address;

import com.research.datagenerator.entity.address.Latitude;
import com.research.datagenerator.entity.address.SecondaryAddress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SecondaryAddressRepository extends JpaRepository<SecondaryAddress, Long> {
}