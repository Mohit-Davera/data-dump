package com.research.datagenerator.repo.color;

import com.research.datagenerator.entity.color.Colour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColourRepository extends JpaRepository<Colour,Long> {
}
