package com.ironhack.crmsystem.controller;

import com.ironhack.crmsystem.repository.LeadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LeadController {

    @Autowired
    private LeadRepository leadRepository;


}
