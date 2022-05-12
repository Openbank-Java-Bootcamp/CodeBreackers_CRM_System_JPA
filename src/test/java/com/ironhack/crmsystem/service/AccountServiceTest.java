package com.ironhack.crmsystem.service;

import com.ironhack.crmsystem.enums.Industry;
import com.ironhack.crmsystem.model.Account;
import com.ironhack.crmsystem.repository.AccountRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class AccountServiceTest {
    @Autowired
    AccountRepository accountRepository;

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
        List<Object[]> result = accountRepository.findMaxEmployeeCount();
        assertEquals(50,result.get(0)[1]);
    }


}