package com.ugp.clone_ugp.repository;

import com.ugp.clone_ugp.modules.MissingPerson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MissingPersonRepository extends JpaRepository<MissingPerson, Integer> {
}
