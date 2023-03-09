package com.research.datagenerator.repo;

import com.research.datagenerator.entity.Colour;
import com.research.datagenerator.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {
}
