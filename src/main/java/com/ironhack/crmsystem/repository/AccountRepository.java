package com.ironhack.crmsystem.repository;

import com.ironhack.crmsystem.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

    @Query("SELECT name, numberOfEmployees FROM Account WHERE numberOfEmployees = (SELECT MAX(numberOfEmployees) FROM Account)")
    List<Object[]> findMaxEmployeeCount();

    @Query("SELECT id, numberOfEmployees FROM Account WHERE numberOfEmployees = (SELECT MIN(numberOfEmployees) FROM Account)")
    List<Object[]> findMinEmployee();

    @Query("SELECT AVG(numberOfEmployees) FROM Account")
    Integer findMeanEmployee();

    @Query(value = "SELECT number_of_employees FROM accounts ORDER BY number_of_employees LIMIT :row,1",nativeQuery = true)
    Integer medianOfOddDB(@Param("row") int row);
    @Query(value = "SELECT AVG(number_of_employees) FROM (SELECT number_of_employees FROM accounts ORDER BY number_of_employees LIMIT :row,2) AS t",nativeQuery = true)
    Double medianOfEvenDB(@Param("row") int row);

    @Query(value = "SELECT COUNT(*) FROM accounts",nativeQuery = true)
    Integer sizeOfAccountsDatabase();
}
