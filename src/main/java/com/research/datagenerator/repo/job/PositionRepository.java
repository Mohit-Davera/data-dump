package com.research.datagenerator.repo.job;

import com.research.datagenerator.entity.job.Position;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PositionRepository extends JpaRepository<Position, Long> {
}