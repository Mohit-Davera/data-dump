package com.research.datagenerator.repo.nation;

import com.research.datagenerator.entity.nation.Nationality;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NationalityRepository extends JpaRepository<Nationality, Long> {
}