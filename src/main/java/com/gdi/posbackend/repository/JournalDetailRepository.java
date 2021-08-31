package com.gdi.posbackend.repository;

import com.gdi.posbackend.entity.JournalDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author Feryadialoi
 * @date 8/25/2021 3:56 AM
 */
public interface JournalDetailRepository extends JpaRepository<JournalDetail, String>, JpaSpecificationExecutor<JournalDetail> {
}
