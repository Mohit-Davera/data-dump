package com.research.datagenerator.repo.file;

import com.research.datagenerator.entity.file.MimeType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MimeTypeRepository extends JpaRepository<MimeType, Long> {
}