package com.ironhack.crmsystem.repository;

import com.ironhack.crmsystem.enums.Status;
import com.ironhack.crmsystem.model.Opportunity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

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


     //Display Opportunity by SalesRepo (funciona)
     @Query(nativeQuery = true, value = "SELECT sales_reps.name, COUNT(*) FROM opportunities JOIN sales_reps ON sales_reps.id = opportunities.sales_rep_id GROUP BY sales_rep_id")
     List<Object[]> findBySalesRepo();
     //Display Opportunity by SalesRepoAndState
     @Query(nativeQuery = true, value= "SELECT sales_reps.name, COUNT(*) FROM opportunities JOIN sales_reps ON sales_reps.id = opportunities.sales_rep_id WHERE status = :s GROUP BY sales_rep_id")
     List<Object[]> findBySalesRepoAndStatus(String s);
     //Display Opportunity by Quantity
     @Query(nativeQuery = true, value = "SELECT quantity, COUNT(*) FROM opportunities GROUP BY quantity")
     List<Object[]> findByQuantity();
     //Display Opportunity by QuantityAndState
     @Query(nativeQuery = true, value ="SELECT quantity, COUNT(*) FROM opportunities WHERE status = :s GROUP BY  quantity")
     List<Object[]> findByQuantityAndStatus(String s);
     //Display Opportunity by Product (funciona)
     @Query(nativeQuery = true, value ="SELECT product, COUNT(*) FROM opportunities GROUP BY  product")
     List<Object[]> findByProduct();
     //Display Opportunity by ProductAndState
     @Query(nativeQuery = true, value ="SELECT product, COUNT(*) FROM opportunities WHERE status = :s GROUP BY  product")
     List<Object[]> findByProductAndState(String s);
     //Display Opportunity by Country (funciona)
     @Query(nativeQuery = true, value= "SELECT accounts.country, COUNT(*) FROM opportunities JOIN accounts ON opportunities.account_id = accounts.id GROUP BY country" )
     List<Object[]> findByCountry();
     //Display Opportunity by CountryAndState
     @Query(nativeQuery = true, value="SELECT accounts.country, COUNT(*) FROM opportunities JOIN accounts ON opportunities.account_id = accounts.id WHERE opportunities.status = :s GROUP BY country" )
     List<Object[]> findByCountryAndStatus( String s);
     //Display Opportunity by City (funicona)
     @Query(nativeQuery = true, value="SELECT accounts.city, COUNT(*) FROM opportunities JOIN accounts ON opportunities.account_id = accounts.id GROUP BY city")
     List<Object[]> findByCity();
     //Display Opportunity by CityAndState
     @Query(nativeQuery = true, value="SELECT accounts.city, COUNT(*) FROM opportunities JOIN accounts ON opportunities.account_id = accounts.id WHERE opportunities.status = :s GROUP BY city" )
     List<Object[]> findByCityAndStatus( String s);

     @Query(nativeQuery = true, value="SELECT accounts.industry, COUNT(*) FROM opportunities JOIN accounts ON opportunities.account_id = accounts.id GROUP BY accounts.industry")
     List<Object[]> findByIndustry();
     //Display Opportunity by CityAndState
     @Query(nativeQuery = true, value="SELECT accounts.industry, COUNT(*) FROM opportunities JOIN accounts ON opportunities.account_id = accounts.id WHERE opportunities.status = :s GROUP BY accounts.industry" )
     List<Object[]> findByIndustryAndStatus( String s);




}
