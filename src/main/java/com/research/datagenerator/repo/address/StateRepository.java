package com.research.datagenerator.repo.address;

import com.research.datagenerator.entity.address.SecondaryStreetAddress;
import com.research.datagenerator.entity.address.State;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StateRepository extends JpaRepository<State, Long> {
}