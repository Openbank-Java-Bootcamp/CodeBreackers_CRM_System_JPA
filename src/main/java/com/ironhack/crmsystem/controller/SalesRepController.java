package com.ironhack.crmsystem.controller;

import com.ironhack.crmsystem.repository.SalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SalesRepController {

    @Autowired
    private SalesRepository salesRepository;

    
}
