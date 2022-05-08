package com.ironhack.crmsystem.controller;

import com.ironhack.crmsystem.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @Autowired
    private AccountRepository accountRepository;
}
