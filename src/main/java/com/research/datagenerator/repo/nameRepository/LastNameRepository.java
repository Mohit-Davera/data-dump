package com.research.datagenerator.repo.nameRepository;

import com.research.datagenerator.entity.name.LastName;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LastNameRepository extends JpaRepository<LastName,Long> {
}
