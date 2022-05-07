package com.ironhack.crmsystem.model;

import com.ironhack.crmsystem.enums.Product;
import com.ironhack.crmsystem.enums.Status;
import jakarta.persistence.*;

@Entity
@Table(name = "opportunity")
public class Opportunity {
    private Product product;
    private int quantity;
    @OneToOne
    @JoinColumn(name = "contact_id", referencedColumnName = "id")
    private Contact decisionMaker;
    @Enumerated
    private Status status;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    //public static int idCount = 1;

    @ManyToOne
    @JoinColumn(name="sales_rep_id", nullable=false)
    private SalesRepo salesRepo;

    public Opportunity(Product product, int quantity, Contact decisionMaker, Status status) {
        this.product = product;
        this.quantity = quantity;
        this.decisionMaker = decisionMaker;
        this.status = status;
        //this.id = idCount++;
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

}
