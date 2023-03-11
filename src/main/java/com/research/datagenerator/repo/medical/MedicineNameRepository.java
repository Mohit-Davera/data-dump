package com.research.datagenerator.repo.medical;

import com.research.datagenerator.entity.medical.MedicineName;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicineNameRepository extends JpaRepository<MedicineName, Long> {
}