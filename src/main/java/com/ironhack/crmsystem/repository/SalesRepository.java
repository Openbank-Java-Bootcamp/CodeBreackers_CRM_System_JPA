package com.ironhack.crmsystem.repository;

import com.ironhack.crmsystem.model.SalesRep;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesRepository extends JpaRepository<SalesRep, Integer> {

}
