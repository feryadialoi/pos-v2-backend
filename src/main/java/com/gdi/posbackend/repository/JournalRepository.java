package com.gdi.posbackend.repository;

import com.gdi.posbackend.entity.Journal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author Feryadialoi
 * @date 8/25/2021 3:55 AM
 */
public interface JournalRepository extends JpaRepository<Journal, String>, JpaSpecificationExecutor<Journal> {
}
