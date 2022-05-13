package com.ironhack.crmsystem.model;

import com.ironhack.crmsystem.enums.Industry;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Table(name="accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    private Industry industry;
    private int numberOfEmployees;
    private String city;
    private String country;
    private String name; //take it from lead object

    @OneToMany
    @JoinColumn(name = "account_id")
    private List<Contact> contactList;

    @OneToMany
    @JoinColumn(name = "account_id")
    private List<Opportunity> opportunityList;

    public Account() {
    }

    public Account(Industry industry, int numberOfEmployees, String city, String country, String name, List<Contact> contactList, List<Opportunity> opportunityList) {
        this.industry = industry;
        this.numberOfEmployees = numberOfEmployees;
        this.city = city;
        this.country = country;
        this.name = name;
        this.contactList = contactList;
        this.opportunityList = opportunityList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Contact> getContactList() {
        return contactList;
    }

    public List<Opportunity> getOpportunityList() {
        return opportunityList;
    }

    public Industry getIndustry() {
        return industry;
    }

    public int getNumberOfEmployees() {
        return numberOfEmployees;
    }


    public String getCity() {
        return city;
    }


    public String getCountry() {
        return country;
    }

    public String getName() {
        return name;
    }

    public void setContactList(List<Contact> contactList) {
        this.contactList = contactList;
    }

    public void setOpportunityList(List<Opportunity> opportunityList) {
        this.opportunityList = opportunityList;
    }
}
