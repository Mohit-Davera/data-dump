package com.research.datagenerator.repo.nameRepository;

import com.research.datagenerator.entity.name.BloodGroup;
import com.research.datagenerator.entity.name.Suffix;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BloodGroupRepository extends JpaRepository<BloodGroup,Long> {
}
