package com.ugp.clone_ugp.repository;

import com.ugp.clone_ugp.modules.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UerRepository extends JpaRepository<User, Integer> {
}
