package com.research.datagenerator.repo.company;

import com.research.datagenerator.entity.company.Url;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UrlRepository extends JpaRepository<Url, Long> {
}