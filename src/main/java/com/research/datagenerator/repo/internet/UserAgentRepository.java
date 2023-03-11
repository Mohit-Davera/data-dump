package com.research.datagenerator.repo.internet;

import com.research.datagenerator.entity.internet.UserAgent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAgentRepository extends JpaRepository<UserAgent, Long> {
}