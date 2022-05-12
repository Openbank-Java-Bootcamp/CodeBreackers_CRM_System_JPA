package com.ironhack.crmsystem.repository;

import com.ironhack.crmsystem.model.Lead;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeadRepository extends JpaRepository<Lead, Integer> {
    @Query(nativeQuery = true, value = "SELECT COUNT(*) FROM leads")
    int getCount();

}
