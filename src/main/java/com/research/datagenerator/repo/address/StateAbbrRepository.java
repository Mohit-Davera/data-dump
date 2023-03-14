package com.research.datagenerator.repo.address;

import com.research.datagenerator.entity.address.State;
import com.research.datagenerator.entity.address.StateAbbr;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StateAbbrRepository extends JpaRepository<StateAbbr, Long> {
}