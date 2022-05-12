package com.ironhack.crmsystem.service;

import com.ironhack.crmsystem.enums.Product;
import com.ironhack.crmsystem.enums.Status;
import com.ironhack.crmsystem.model.Contact;
import com.ironhack.crmsystem.model.Opportunity;
import com.ironhack.crmsystem.model.SalesRep;
import com.ironhack.crmsystem.repository.OpportunityRepository;
import nl.altindag.console.ConsoleCaptor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.StringReader;
import java.util.List;
import java.util.Scanner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OpportunityServiceTest {

    @Autowired
    private OpportunityRepository opportunityRepository;
    @Autowired
    private OpportunityService opportunityService;

    @BeforeEach
    void setUp() {
        Opportunity opportunity1 = opportunityRepository.save(new Opportunity(Product.HYBRID, 100, new Contact("Juan","987654321","juanpp98@gmail.com", "Maujn"), Status.CLOSED_LOST, new SalesRep("Pedro") ));
        Opportunity opportunity2 = opportunityRepository.save(new Opportunity(Product.FLATBED, 50, new Contact("Ana","983657144","ana998@gmail.com", "Bimb55"), Status.CLOSED_WON, new SalesRep("Carmen") ));
        Opportunity opportunity3 = opportunityRepository.save(new Opportunity(Product.BOX, 17, new Contact("Luis","123456789","luis98@gmail.com", "dc34"), Status.OPEN, new SalesRep("Tomas")));
        opportunityRepository.saveAll(List.of(opportunity1, opportunity2, opportunity3));

    }

    @AfterEach
    void tearDown() {
        opportunityRepository.deleteAll();
    }

    @Test
    void maxQuantity_JPATest(){
        opportunityService.maxQuantity();
        StringReader sr = new StringReader("s");
        Scanner scan = new Scanner(sr);
        ConsoleCaptor consoleCaptor = new ConsoleCaptor();
        List<String> s = consoleCaptor.getStandardOutput();
        consoleCaptor.close();
        assertThat(s.contains("100"));
    }
    @Test
    void minQuantity_JPATest(){
        opportunityService.minQuantity();
        StringReader sr = new StringReader("s");
        Scanner scan = new Scanner(sr);
        ConsoleCaptor consoleCaptor = new ConsoleCaptor();
        List<String> s = consoleCaptor.getStandardOutput();
        consoleCaptor.close();
        assertThat(s.contains("17"));
    }
    @Test
    void meanQuantity_JPATest(){

        opportunityService.meanQuantity();
        StringReader sr = new StringReader("s");
        Scanner scan = new Scanner(sr);
        ConsoleCaptor consoleCaptor = new ConsoleCaptor();
        List<String> s = consoleCaptor.getStandardOutput();
        consoleCaptor.close();
        assertThat(s.contains("55.66"));
    }
   @Test
    void medianQuantity_JPATest(){
       opportunityService.medianQuantity();
       StringReader sr = new StringReader("s");
       Scanner scan = new Scanner(sr);
       ConsoleCaptor consoleCaptor = new ConsoleCaptor();
       List<String> s = consoleCaptor.getStandardOutput();
       consoleCaptor.close();
       assertThat(s.contains("50"));
    }
}