package com.ironhack.crmsystem.service;
import com.ironhack.crmsystem.enums.Industry;
import com.ironhack.crmsystem.enums.Product;
import com.ironhack.crmsystem.enums.Status;
import com.ironhack.crmsystem.model.Account;
import com.ironhack.crmsystem.model.Contact;
import com.ironhack.crmsystem.model.Opportunity;
import com.ironhack.crmsystem.model.SalesRep;
import com.ironhack.crmsystem.repository.AccountRepository;
import com.ironhack.crmsystem.repository.ContactRepository;
import com.ironhack.crmsystem.repository.OpportunityRepository;
import com.ironhack.crmsystem.repository.SalesRepRepository;
import nl.altindag.console.ConsoleCaptor;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.io.StringReader;
import java.text.DecimalFormat;
import java.util.*;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("test")
@SpringBootTest
class OpportunityServiceTest {

    private Scanner s;

    @Autowired
    private OpportunityRepository opportunityRepository;

    @Autowired
    private SalesRepRepository salesRepRepository;

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private OpportunityService opportunityService;


    @Autowired
    private AccountRepository accountRepository;

    List<Opportunity> ops;

    @BeforeEach
    void setUp() {

        SalesRep sR1 = new SalesRep("Yadira");
        SalesRep sR2 = new SalesRep("Paula");
        SalesRep sR3 = new SalesRep("Maria");
        SalesRep sR4 = new SalesRep("Pilar");
        salesRepRepository.saveAll(Set.of(sR1, sR2, sR3, sR4));

        Contact c1 = new Contact("Matucos", "634234234", "rodrigo@gmail.com", "Rodrigo");
        Contact c2 = new Contact("Caixa", "634234234", "carlos@gmail.com", "Carlos");
        Contact c3 = new Contact("OpenBank", "634234234", "sonia@gmail.com", "Sonia");
        Contact c4 = new Contact("Loreal", "634234234", "rodolfo@gmail.com", "Rodolfo");
        contactRepository.saveAll(Set.of(c1, c2, c3, c4));

        Opportunity opp1 = new Opportunity(Product.BOX, 10, c1, Status.OPEN, sR1);
        Opportunity opp2 = new Opportunity(Product.BOX, 3, c1, Status.OPEN, sR2);
        Opportunity opp3 = new Opportunity(Product.BOX, 4, c1, Status.OPEN, sR1);
        Opportunity opp4 = new Opportunity(Product.BOX, 20, c1, Status.OPEN, sR3);
        Opportunity opp5 = new Opportunity(Product.BOX, 30, c1, Status.OPEN, sR1);
        Opportunity opp6 = new Opportunity(Product.BOX, 1, c1, Status.OPEN, sR4);
        this.ops = opportunityRepository.saveAll(Set.of(opp1, opp2, opp3, opp4, opp5, opp6));

        Account acc1 = new Account(Industry.ECOMMERCE, 13, "Madrid", "Spain", "Banks", List.of(c3, c2), List.of(opp1, opp2, opp3));
        Account acc2 = new Account(Industry.OTHER, 30, "Madrid", "Spain", "Wines", List.of(c1), List.of(opp4, opp5));
        Account acc3 = new Account(Industry.OTHER, 30, "Madrid", "Spain", "Perf", List.of(c1), List.of(opp6));
        accountRepository.saveAll(Set.of(acc1, acc2, acc3));

    }

    @AfterEach
    void tearDown() {
        salesRepRepository.deleteAll();
        contactRepository.deleteAll();
        opportunityRepository.deleteAll();
        accountRepository.deleteAll();
    }

    @Test
    void changeOppStatus_Validate_Ok() {

        Integer id = this.ops.get(0).getId();
        Scanner scanner = new Scanner(new StringReader("close-lost " + id));
        opportunityService.changeNewStatus(scanner);

        Optional<Opportunity> op = opportunityRepository.findById(id);
        assertEquals(Status.CLOSED_LOST, op.get().getStatus());
    }

    @Test
    void changeNewStatus() {
        Integer id = this.ops.get(0).getId();
        Scanner scanner = new Scanner(new StringReader("close-lost " + id));
        opportunityService.changeNewStatus(scanner);

        Optional<Opportunity> op = opportunityRepository.findById(id);
        assertEquals(Status.CLOSED_LOST, op.get().getStatus());
    }

    @Test
    public void maxOpp_Validate(){
        Object[] maxOpp = opportunityService.maxOpp();
        String nameAcc = maxOpp[0].toString();
        String max = maxOpp[1].toString();

        assertEquals("Banks", nameAcc);
        assertEquals("3", max);
    }

    @Test
    public void minOpp_Validate(){
        Object[] minOpp = opportunityService.minOpp();
        String nameAcc = minOpp[0].toString();
        String min = minOpp[1].toString();

        assertEquals("Perf", nameAcc);
        assertEquals("1", min);
    }

    @Test
    public void meanOpp_Validate(){
        List<Object[]> opportunities = opportunityRepository.findOpportunitiesByAccount();
        double totalOpp = 0;
        int totalAcc = opportunities.size();

        for (Object[] opp : opportunities) {
            totalOpp += Integer.parseInt(opp[1].toString());
        }

        double mean = totalOpp / totalAcc;
        DecimalFormat df = new DecimalFormat("#.00");

        assertEquals("2,00", df.format(mean));
    }

    @Test
    public void medianOpp_Validate() {
        List<Object[]> opportunities = opportunityRepository.findOpportunitiesByAccount();
        double median = 0;
        if (opportunities.size() % 2 != 0) {
            Object[] medianOpp = opportunities.get(opportunities.size() / 2);
            median = Double.parseDouble(medianOpp[1].toString());
        } else {
            Object[] medianOpp1 = opportunities.get(opportunities.size() / 2);
            double med1 = Double.parseDouble(medianOpp1[1].toString());
            Object[] medianOpp2 = opportunities.get(opportunities.size() / 2);
            double med2 = Double.parseDouble(medianOpp1[1].toString());
            median = (med1 + med2) / 2;
        }
        DecimalFormat df = new DecimalFormat("#.00");

        assertEquals("2,00", df.format(median));
    }

    @Test
    void maxQuantity_JPATest(){
        opportunityService.maxQuantity();
        StringReader sr = new StringReader("s");
        Scanner scan = new Scanner(sr);
        ConsoleCaptor consoleCaptor = new ConsoleCaptor();
        List<String> s = consoleCaptor.getStandardOutput();
        consoleCaptor.close();
        assertThat(s.contains("30"));
    }
    @Test
    void minQuantity_JPATest(){
        opportunityService.minQuantity();
        StringReader sr = new StringReader("s");
        ConsoleCaptor consoleCaptor = new ConsoleCaptor();
        List<String> s = consoleCaptor.getStandardOutput();
        consoleCaptor.close();
        assertThat(s.contains("1"));
    }
    @Test
    void meanQuantity_JPATest(){
        opportunityService.meanQuantity();
        StringReader sr = new StringReader("s");
        Scanner scan = new Scanner(sr);
        ConsoleCaptor consoleCaptor = new ConsoleCaptor();
        List<String> s = consoleCaptor.getStandardOutput();
        consoleCaptor.close();
        assertThat(s.contains("11"));
    }
    @Test
    void medianQuantity_JPATest(){
        opportunityService.medianQuantity();
        StringReader sr = new StringReader("s");
        Scanner scan = new Scanner(sr);
        ConsoleCaptor consoleCaptor = new ConsoleCaptor();
        List<String> s = consoleCaptor.getStandardOutput();
        consoleCaptor.close();
        assertThat(s.contains("7"));
    }

    @Test
    public void findBySalesRepo_WORK(){
        StringReader sr = new StringReader("s");
        Scanner scan = new Scanner(sr);
        ConsoleCaptor consoleCaptor = new ConsoleCaptor();
        opportunityService.opportunitiesBySalesRep(scan);
        List<String> s = consoleCaptor.getStandardOutput();
        consoleCaptor.close();
        assertThat(s.contains("7"));
    }

    @Test
    void findByQuantity_WORKS(){
        StringReader sr = new StringReader("s");
        Scanner scan = new Scanner(sr);
        ConsoleCaptor consoleCaptor = new ConsoleCaptor();
        opportunityService.opportunitiesByQuantity(scan);
        List<String> s = consoleCaptor.getStandardOutput();
        consoleCaptor.close();
        assertThat(s.contains("7"));
    }

    @Test
    void findByProduct_WORKS(){
        StringReader sr = new StringReader("s");
        Scanner scan = new Scanner(sr);
        ConsoleCaptor consoleCaptor = new ConsoleCaptor();
        opportunityService.opportunitiesByProduct(scan);
        List<String> s = consoleCaptor.getStandardOutput();
        consoleCaptor.close();
        assertThat(s.contains("7"));
    }

    @Test
    void findByCountry_WORKS(){
        StringReader sr = new StringReader("s");
        Scanner scan = new Scanner(sr);
        ConsoleCaptor consoleCaptor = new ConsoleCaptor();
        opportunityService.opportunitiesByCountry(scan);
        List<String> s = consoleCaptor.getStandardOutput();
        consoleCaptor.close();
        assertThat(s.contains("7"));
    }

    @Test
    void findByCity_WORKS(){
        StringReader sr = new StringReader("s");
        Scanner scan = new Scanner(sr);
        ConsoleCaptor consoleCaptor = new ConsoleCaptor();
        opportunityService.opportunitiesByCity(scan);
        List<String> s = consoleCaptor.getStandardOutput();
        consoleCaptor.close();
        assertThat(s.contains("7"));
    }

    @Test
    void findByIndustry_WORKS(){
        StringReader sr = new StringReader("s");
        Scanner scan = new Scanner(sr);
        ConsoleCaptor consoleCaptor = new ConsoleCaptor();
        opportunityService.opportunitiesByIndustry(scan);
        List<String> s = consoleCaptor.getStandardOutput();
        consoleCaptor.close();
        assertThat(s.contains("7"));
    }


}

