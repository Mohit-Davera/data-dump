package com.research.datagenerator.repo.educator;

import com.research.datagenerator.entity.educator.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}