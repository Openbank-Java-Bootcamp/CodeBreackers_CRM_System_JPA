package com.ironhack.crmsystem.repository;

import com.ironhack.crmsystem.model.Opportunity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OpportunityRepository extends JpaRepository<Opportunity, Integer> {

     @Query(value = "SELECT MAX(quantity) FROM Opportunity GROUP BY account_id")
     int getMaxQuantity();

     @Query(value = "SELECT MIN(quantity) FROM Opportunity GROUP BY account_id")
     int getMinQuantity();

     @Query(value = "SELECT AVG(quantity) FROM Opportunity GROUP BY account_id")
     double getAvgQuantity();

     //Median
    @Query(value = "SELECT quantity FROM Opportunity ORDER BY quantity LIMIT :row,1",nativeQuery = true)
    Integer medianOfOddDBOpp(@Param("row") int row);
    @Query(value = "SELECT AVG(quantity) FROM (SELECT quantity FROM Opportunity ORDER BY quantity LIMIT :row,2) AS t",nativeQuery = true)
    Double medianOfEvenDBOpp(@Param("row") int row);

    @Query(value = "SELECT COUNT(*) FROM Opportunity",nativeQuery = true)
    Integer sizeOfOpportunityDatabase();

}
