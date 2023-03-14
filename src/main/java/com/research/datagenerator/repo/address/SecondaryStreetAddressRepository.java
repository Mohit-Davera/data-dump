package com.research.datagenerator.repo.address;

import com.research.datagenerator.entity.address.SecondaryAddress;
import com.research.datagenerator.entity.address.SecondaryStreetAddress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SecondaryStreetAddressRepository extends JpaRepository<SecondaryStreetAddress, Long> {
}