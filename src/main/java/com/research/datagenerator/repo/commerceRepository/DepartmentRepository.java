package com.research.datagenerator.repo.commerceRepository;

import com.research.datagenerator.entity.Commerce.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department,Long> {
}
