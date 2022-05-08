package com.ironhack.crmsystem.controller;

import com.ironhack.crmsystem.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactController {

    @Autowired
    private ContactRepository contactRepository;
}
