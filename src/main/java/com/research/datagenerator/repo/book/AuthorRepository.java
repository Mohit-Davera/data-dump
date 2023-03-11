package com.research.datagenerator.repo.book;

import com.research.datagenerator.entity.book.AuthorName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<AuthorName,Long> {
}
