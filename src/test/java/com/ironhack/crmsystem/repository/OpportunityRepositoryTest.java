package com.ironhack.crmsystem.repository;

import com.ironhack.crmsystem.enums.Industry;
import com.ironhack.crmsystem.enums.Product;
import com.ironhack.crmsystem.enums.Status;
import com.ironhack.crmsystem.model.Account;
import com.ironhack.crmsystem.model.Contact;
import com.ironhack.crmsystem.model.Opportunity;
import com.ironhack.crmsystem.model.SalesRep;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class OpportunityRepositoryTest {

    @Autowired
    OpportunityRepository opportunityRepository;
    @Autowired
    ContactRepository contactRepository;
    @Autowired
    AccountRepository accountRepository;

    @Autowired
    SalesRepRepository salesRepRepository;

    @BeforeEach
    void setUp() {
        SalesRep s = new SalesRep("Pedro");
        SalesRep s2 = new SalesRep("Paula");
        salesRepRepository.save(s);
        salesRepRepository.save(s2);
        Contact c = new Contact("Juan","987654321","juanpp98@gmail.com", "Maujn");
        contactRepository.save(c);
        Opportunity o1 = new Opportunity(Product.HYBRID, 100,c, Status.CLOSED_LOST,s);
        opportunityRepository.save(o1);
        Opportunity o2 = new Opportunity(Product.BOX, 10,c, Status.OPEN, s);
        opportunityRepository.save(o2);
        Opportunity o3 = new Opportunity(Product.HYBRID, 1,c, Status.CLOSED_LOST, s2);
        opportunityRepository.save(o3);
        Account ac1 = new Account(Industry.ECOMMERCE, 9,"Spain", "Madrid", "Matucos", List.of(c) , List.of(o1, o2));
        accountRepository.save(ac1);
        Account ac2 = new Account(Industry.ECOMMERCE, 3,"Spain", "Barcelona", "Cancun", List.of(c), List.of(o3));
        accountRepository.save(ac2);
    }

    @AfterEach
    void tearDown() {
       accountRepository.deleteAll();
       opportunityRepository.deleteAll();
       contactRepository.deleteAll();
       salesRepRepository.deleteAll();
    }

    @Test
    void findBySalesRepo_WORKS(){
        List<Object[]> result = opportunityRepository.findBySalesRepo();
        assertEquals(2, result.size());
    }

    @Test
    void findBySalesRepoANDSTATUS_WORKS(){
        List<Object[]> result = opportunityRepository.findBySalesRepoAndStatus("OPEN");
        assertEquals(1, result.size());
    }
    @Test
    void findBySalesQuantity_WORKS(){
        List<Object[]> result = opportunityRepository.findByQuantity();
        assertEquals(3, result.size());
    }
    @Test
    void findBySalesQuantityANDState_WORKS(){
        List<Object[]> result = opportunityRepository.findByQuantityAndStatus("CLOSE");
        assertEquals(2, result.size());
    }
    @Test
    void findByProdcut_WORK(){
        List<Object[]> result = opportunityRepository.findByProduct();
        assertEquals(2, result.size());
    }
    @Test
    void findByProdcutANDStatus_WORK(){
        List<Object[]> result = opportunityRepository.findByProductAndState("OPEN");
        assertEquals(1, result.size());
    }
    @Test
    void findByCountry_WORK(){
        List<Object[]> result = opportunityRepository.findByCountry();
        assertEquals(1, result.size());
    }
    @Test
    void findByCountryANdstatus_WORK(){
        List<Object[]> result = opportunityRepository.findByCountryAndStatus("OPEN");
        assertEquals(1, result.size());
    }
    @Test
    void findByCity_WORK(){
        List<Object[]> result = opportunityRepository.findByCity();
        assertEquals(1, result.size());
    }
    @Test
    void findByCityAndStatus_WORK(){
        List<Object[]> result = opportunityRepository.findByCityAndStatus("OPEN");
        assertEquals(1, result.size());
    }

    @Test
    void findByIndustry_WORK(){
        List<Object[]> result = opportunityRepository.findByIndustry();
        assertEquals(1, result.size());
    }

    @Test
    void findByIndustryAndStatus_WORK(){
        List<Object[]> result = opportunityRepository.findByIndustryAndStatus("OPEN");
        assertEquals(1, result.size());
    }
}
