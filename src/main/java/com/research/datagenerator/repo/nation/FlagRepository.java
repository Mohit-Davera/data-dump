package com.research.datagenerator.repo.nation;

import com.research.datagenerator.entity.nation.Flag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlagRepository extends JpaRepository<Flag, Long> {
}