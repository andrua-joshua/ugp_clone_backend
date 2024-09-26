package com.ugp.clone_ugp.repository;

import com.ugp.clone_ugp.modules.LostAndFound;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LostAndFoundRepository extends JpaRepository<LostAndFound, Integer> {
}
