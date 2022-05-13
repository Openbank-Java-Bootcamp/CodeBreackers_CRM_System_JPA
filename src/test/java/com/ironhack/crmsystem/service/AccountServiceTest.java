package com.ironhack.crmsystem.service;

import com.ironhack.crmsystem.enums.Industry;
import com.ironhack.crmsystem.model.Account;
import com.ironhack.crmsystem.repository.AccountRepository;
import nl.altindag.console.ConsoleCaptor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ActiveProfiles("test")
@SpringBootTest
class AccountServiceTest {
    @Autowired
    AccountRepository accountRepository;

    @Autowired
    AccountService accountService;

    @BeforeEach
    void setUp() {
        Account account1 = new Account(Industry.MEDICAL, 50,"Madrid","Spain","Openbank",new ArrayList<>(),new ArrayList<>());
        Account account2 = new Account(Industry.MANUFACTURING, 20,"Madrid","Spain","Openbankia",new ArrayList<>(),new ArrayList<>());
        Account account3 = new Account(Industry.ECOMMERCE, 10,"Madrid","Spain","Openbk",new ArrayList<>(),new ArrayList<>());
        accountRepository.saveAll(List.of(account1, account2, account3));
    }

    @AfterEach
    void tearDown() {
        accountRepository.deleteAll();
    }

    @Test
    public void maxEmployeeCont_JPATest(){
        accountService.maxEmployeeCont();
        StringReader sr = new StringReader("s");
        Scanner scan = new Scanner(sr);
        ConsoleCaptor consoleCaptor = new ConsoleCaptor();
        List<String> s = consoleCaptor.getStandardOutput();
        consoleCaptor.close();
        assertThat(s.contains("50"));
    }

    @Test
    public void minEmployeeContJPATest(){
        accountService.minEmployeeCont();
        StringReader sr = new StringReader("s");
        Scanner scan = new Scanner(sr);
        ConsoleCaptor consoleCaptor = new ConsoleCaptor();
        List<String> s = consoleCaptor.getStandardOutput();
        consoleCaptor.close();
        assertThat(s.contains("10"));
    }
    @Test
    public void meanEmployeeCont(){
        accountService.meanEmployeeCont();
        StringReader sr = new StringReader("s");
        Scanner scan = new Scanner(sr);
        ConsoleCaptor consoleCaptor = new ConsoleCaptor();
        List<String> s = consoleCaptor.getStandardOutput();
        consoleCaptor.close();
        assertThat(s.contains("26"));
    }

    @Test
    public void medianEmployeeCont(){
        accountService.medianEmployeeCont();
        StringReader sr = new StringReader("s");
        Scanner scan = new Scanner(sr);
        ConsoleCaptor consoleCaptor = new ConsoleCaptor();
        List<String> s = consoleCaptor.getStandardOutput();
        consoleCaptor.close();
        assertThat(s.contains("20"));
    }

}