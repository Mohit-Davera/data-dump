package com.research.datagenerator.repo.nameRepository;

import com.research.datagenerator.entity.name.Name;
import com.research.datagenerator.entity.name.Suffix;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NameRepository extends JpaRepository<Name,Long> {
}
