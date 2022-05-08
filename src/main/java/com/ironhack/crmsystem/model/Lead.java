package com.ironhack.crmsystem.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "leads")
public class Lead {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String phoneNumber;
    private String emailAddress;
    private String companyName;

    @ManyToOne
    @JoinColumn(name="sales_rep_id", referencedColumnName = "id")
    private SalesRep salesRep;

    public Lead() {
    }

    public Lead(String name, String phoneNumber, String emailAddress, String companyName, SalesRep salesRep) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.companyName = companyName;
        this.salesRep = salesRep;
    }

    public Lead(String nameLead, String phoneNumberLead, String emailLead, String companyNameLead) {
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public SalesRep getSalesRep() {
        return salesRep;
    }

    public void setSalesRep(SalesRep salesRep) {
        this.salesRep = salesRep;
    }

    @Override
    public String toString() {
        return id + ". "+ name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lead lead = (Lead) o;
        return id == lead.id && Objects.equals(name, lead.name) && Objects.equals(phoneNumber, lead.phoneNumber) && Objects.equals(emailAddress, lead.emailAddress) && Objects.equals(companyName, lead.companyName) && Objects.equals(salesRep, lead.salesRep);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, phoneNumber, emailAddress, companyName, salesRep);
    }
}
