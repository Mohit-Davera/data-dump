package com.research.datagenerator.repo.company;

import com.research.datagenerator.entity.company.Logo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogoRepository extends JpaRepository<Logo, Long> {
}