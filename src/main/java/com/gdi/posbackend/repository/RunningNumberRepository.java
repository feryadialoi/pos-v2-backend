package com.gdi.posbackend.repository;

import com.gdi.posbackend.entity.RunningNumber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.LockModeType;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

/**
 * @author Feryadialoi
 * @date 8/4/2021 2:07 PM
 */
public interface RunningNumberRepository extends JpaRepository<RunningNumber, String> {

    @Lock(LockModeType.PESSIMISTIC_READ)
    Optional<RunningNumber> findByPrefix(String prefix);

    @Transactional
    @Modifying
    @Query("UPDATE RunningNumber rn SET rn.number = 0")
    void resetRunningNumber();

    long countByNumberIsGreaterThan(Integer number);

    long countByPrefixIn(List<String> prefix);
}
