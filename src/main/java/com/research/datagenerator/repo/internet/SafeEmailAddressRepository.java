package com.research.datagenerator.repo.internet;

import com.research.datagenerator.entity.internet.SafeEmailAddress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SafeEmailAddressRepository extends JpaRepository<SafeEmailAddress, Long> {
}