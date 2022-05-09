package com.ironhack.crmsystem.repository;

import com.ironhack.crmsystem.model.Opportunity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OpportunityRepository extends JpaRepository<Opportunity, Integer> {

     @Query(value = "SELECT MAX(quantity) FROM Opportunity GROUP BY account_id")
     int getMaxQuantity();

     @Query(value = "SELECT MIN(quantity) FROM Opportunity GROUP BY account_id")
     int getMinQuantity();

     @Query(value = "SELECT AVG(quantity) FROM Opportunity GROUP BY account_id")
     double getAvgQuantity();

    //@Query(value = "SELECT TOP 1 PERCENTILE_COUNT (0.5) WITHIN GROUP (ORDER BY quantity) as median FROM Opportunity")
    //double getMedianQuantity();

}
