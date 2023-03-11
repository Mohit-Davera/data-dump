package com.research.datagenerator.repo.relationship;

import com.research.datagenerator.entity.relationship.Parent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParentRepository extends JpaRepository<Parent, Long> {
}