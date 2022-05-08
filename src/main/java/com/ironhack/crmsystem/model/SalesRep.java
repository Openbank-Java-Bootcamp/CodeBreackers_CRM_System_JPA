package com.ironhack.crmsystem.model;

import jakarta.persistence.*;

import java.util.Set;


@Entity
@Table(name = "sales_reps")
public class SalesRep {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "salesRep", cascade = CascadeType.ALL)
    private Set<Lead> leads;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "salesRep", cascade = CascadeType.ALL)
    private Set<Opportunity> opportunities;

    public SalesRep() {
    }

    public SalesRep(String name, Set<Lead> leads, Set<Opportunity> opportunities) {
        this.name = name;
        this.leads = leads;
        this.opportunities = opportunities;
    }

    public Integer getId() {
        return this.id;
    }


    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Lead> getLeads() {
        return leads;
    }

    public void setLeads(Set<Lead> leads) {
        this.leads = leads;
    }

    public Set<Opportunity> getOpportunities() {
        return opportunities;
    }

    public void setOpportunities(Set<Opportunity> opportunities) {
        this.opportunities = opportunities;
    }

    //============= Additional Methods ======================


}
