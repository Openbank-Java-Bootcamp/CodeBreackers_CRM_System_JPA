package com.ironhack.crmsystem.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "sales_repo")
public class SalesRepo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer salesRepoId;

    private String salesRepo_name;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "sales_repo", cascade = CascadeType.ALL)
    private Set<Lead> leads;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "sales_repo", cascade = CascadeType.ALL)
    private Set<Opportunity> opportunities;

    public SalesRepo(String salesRepo_name, Set<Lead> leads, Set<Opportunity> opportunities) {
        this.salesRepo_name = salesRepo_name;
        this.leads = leads;
        this.opportunities = opportunities;
    }

    public Integer getSalesRepoId() {
        return salesRepoId;
    }

    public void setId(Integer salesRepo_id) {
        this.salesRepoId = salesRepoId;
    }

    public String getSalesRepo_name() {
        return salesRepo_name;
    }

    public void setSalesRepo_name(String salesRepo_name) {
        this.salesRepo_name = salesRepo_name;
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
}
