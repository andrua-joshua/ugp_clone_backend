package com.ugp.clone_ugp.repository;

import com.ugp.clone_ugp.modules.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<Location, Integer> {
}
