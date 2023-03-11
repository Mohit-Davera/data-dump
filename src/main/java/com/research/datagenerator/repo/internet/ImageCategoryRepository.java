package com.research.datagenerator.repo.internet;

import com.research.datagenerator.entity.internet.ImageCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageCategoryRepository extends JpaRepository<ImageCategory, Long> {
}