package com.research.datagenerator.repo.file;

import com.research.datagenerator.entity.file.Extension;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExtensionRepository extends JpaRepository<Extension, Long> {
}