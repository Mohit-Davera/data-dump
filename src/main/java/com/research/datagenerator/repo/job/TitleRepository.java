package com.research.datagenerator.repo.job;

import com.research.datagenerator.entity.job.Title;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TitleRepository extends JpaRepository<Title, Long> {
}