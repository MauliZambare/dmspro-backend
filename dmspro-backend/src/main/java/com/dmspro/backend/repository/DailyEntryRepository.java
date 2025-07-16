package com.dmspro.backend.repository;

import com.dmspro.backend.model.DailyEntry;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DailyEntryRepository extends JpaRepository<DailyEntry, Long> {
    List<DailyEntry> findByCustomerId(Long customerId);
}
