package com.research.datagenerator.repo.file;

import com.research.datagenerator.entity.file.FileName;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileNameRepository extends JpaRepository<FileName, Long> {
}