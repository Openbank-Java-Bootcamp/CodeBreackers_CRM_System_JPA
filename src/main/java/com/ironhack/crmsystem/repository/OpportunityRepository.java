package com.ironhack.crmsystem.repository;

import com.ironhack.crmsystem.model.Opportunity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OpportunityRepository extends JpaRepository<Opportunity, Integer> {
}
