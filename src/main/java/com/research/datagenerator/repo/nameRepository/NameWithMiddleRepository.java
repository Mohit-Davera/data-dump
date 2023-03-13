package com.research.datagenerator.repo.nameRepository;

import com.research.datagenerator.entity.name.NameWithMiddle;
import com.research.datagenerator.entity.name.Suffix;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NameWithMiddleRepository extends JpaRepository<NameWithMiddle,Long> {
}
