package com.research.datagenerator.repo.internet;

import com.research.datagenerator.entity.internet.InternetUrl;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InternetUrlRepository extends JpaRepository<InternetUrl, Long> {
}