package com.ironhack.crmsystem.model;

import com.ironhack.crmsystem.enums.Product;
import com.ironhack.crmsystem.enums.Status;
import jakarta.persistence.*;

@Entity
@Table(name = "opportunities")
public class Opportunity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    private  Product product;

    private int quantity;

    @OneToOne
    @JoinColumn(name = "contact_id")
    private Contact decisionMaker;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    @JoinColumn(name="sales_rep_id", referencedColumnName = "id")
    private SalesRep salesRep;

    public Opportunity(Product product, int quantity, Contact decisionMaker, Status status, SalesRep salesRep) {
        this.product = product;
        this.quantity = quantity;
        this.decisionMaker = decisionMaker;
        this.status = status;
        this.salesRep = salesRep;
    }

    public Opportunity() {
    }

    public int getId() {
        return id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Contact getDecisionMaker() {
        return decisionMaker;
    }

    public void setDecisionMaker(Contact decisionMaker) {
        this.decisionMaker = decisionMaker;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public SalesRep getSalesRep() {
        return salesRep;
    }

    public void setSalesRep(SalesRep salesRep) {
        this.salesRep = salesRep;
    }
}
