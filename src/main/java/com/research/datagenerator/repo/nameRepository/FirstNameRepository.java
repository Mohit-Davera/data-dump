package com.research.datagenerator.repo.nameRepository;

import com.research.datagenerator.entity.name.FirstName;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FirstNameRepository extends JpaRepository<FirstName,Long> {
}
