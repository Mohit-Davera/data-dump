package com.research.datagenerator.repo.internet;

import com.research.datagenerator.entity.internet.EmailAddress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailAddressRepository extends JpaRepository<EmailAddress, Long> {
}