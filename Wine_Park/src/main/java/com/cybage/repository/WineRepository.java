package com.cybage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cybage.model.Wine;

@Repository
public interface WineRepository extends JpaRepository<Wine, Integer> {

}
