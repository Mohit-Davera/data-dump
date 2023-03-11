package com.research.datagenerator.repo.relationship;

import com.research.datagenerator.entity.relationship.Spouse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpouseRepository extends JpaRepository<Spouse, Long> {
}