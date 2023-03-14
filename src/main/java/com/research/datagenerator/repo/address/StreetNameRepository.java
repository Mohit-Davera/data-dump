package com.research.datagenerator.repo.address;

import com.research.datagenerator.entity.address.StreetAddress;
import com.research.datagenerator.entity.address.StreetName;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StreetNameRepository extends JpaRepository<StreetName, Long> {
}