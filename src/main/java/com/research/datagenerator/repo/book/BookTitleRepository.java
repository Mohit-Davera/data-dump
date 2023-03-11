package com.research.datagenerator.repo.book;

import com.research.datagenerator.entity.book.BookTitle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookTitleRepository extends JpaRepository<BookTitle,Long> {
}
