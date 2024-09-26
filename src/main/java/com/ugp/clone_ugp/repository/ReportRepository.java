package com.ugp.clone_ugp.repository;

import com.ugp.clone_ugp.modules.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportRepository extends JpaRepository<Report, Integer> {
}
