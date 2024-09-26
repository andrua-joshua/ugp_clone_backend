package com.ugp.clone_ugp.repository;

import com.ugp.clone_ugp.modules.Station;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StationRepository extends JpaRepository<Station, Integer> {
}
