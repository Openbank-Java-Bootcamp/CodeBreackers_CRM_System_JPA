package com.ironhack.crmsystem.repository;

import com.ironhack.crmsystem.model.SalesRepo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalesRepository extends JpaRepository<SalesRepo, Integer> {

}
