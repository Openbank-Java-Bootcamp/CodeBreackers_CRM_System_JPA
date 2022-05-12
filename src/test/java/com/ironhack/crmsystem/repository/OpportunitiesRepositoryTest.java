package com.ironhack.crmsystem.repository;

import com.ironhack.crmsystem.enums.Industry;
import com.ironhack.crmsystem.enums.Product;
import com.ironhack.crmsystem.enums.Status;
import com.ironhack.crmsystem.model.Account;
import com.ironhack.crmsystem.model.Contact;
import com.ironhack.crmsystem.model.Opportunity;
import com.ironhack.crmsystem.model.SalesRep;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OpportunityRepositoryTest {

    @Autowired
    private OpportunityRepository opportunityRepository;

    @Autowired
    SalesRepRepository salesRepRepository;

    @Autowired
    ContactRepository contactRepository;

    @Autowired
    AccountRepository accountRepository;

    @BeforeEach
    void setUp() {

        SalesRep sR1 = new SalesRep("Yadira");
        SalesRep sR2 = new SalesRep("Paula");
        SalesRep sR3 = new SalesRep("Maria");
        SalesRep sR4 = new SalesRep("Pilar");
        salesRepRepository.saveAll(Set.of(sR1,sR2,sR3,sR4));

        Contact c1 = new Contact("Matucos","634234234", "rodrigo@gmail.com","Rodrigo");
        Contact c2 = new Contact("Caixa","634234234", "carlos@gmail.com","Carlos");
        Contact c3 = new Contact("OpenBank","634234234", "sonia@gmail.com","Sonia");
        Contact c4 = new Contact("Loreal","634234234", "rodolfo@gmail.com","Rodolfo");
        contactRepository.saveAll(Set.of(c1,c2,c3,c4));

        Opportunity opp1 = new Opportunity(Product.BOX,3,c1, Status.OPEN,sR1);
        Opportunity opp2 = new Opportunity(Product.BOX,3,c1, Status.OPEN,sR2);
        Opportunity opp3 = new Opportunity(Product.BOX,3,c1, Status.OPEN,sR1);
        Opportunity opp4 = new Opportunity(Product.BOX,3,c1, Status.OPEN,sR3);
        Opportunity opp5 = new Opportunity(Product.BOX,3,c1, Status.OPEN,sR1);
        Opportunity opp6 = new Opportunity(Product.BOX,3,c1, Status.OPEN,sR4);
        opportunityRepository.saveAll(Set.of(opp1,opp2,opp3,opp4,opp5,opp6));

        Account acc1 = new Account(Industry.ECOMMERCE, 13, "Madrid", "Spain", "Banks", List.of(c3,c2), List.of(opp1, opp2, opp3));
        Account acc2 = new Account(Industry.OTHER, 30, "Madrid", "Spain", "Wines", List.of(c1), List.of(opp4, opp5));
        Account acc3 = new Account(Industry.OTHER, 30, "Madrid", "Spain", "Wines", List.of(c1), List.of(opp6));
        accountRepository.saveAll(Set.of(acc1,acc2,acc3));
    }

    @AfterEach
    void tearDown() {
        salesRepRepository.deleteAll();
        contactRepository.deleteAll();
        opportunityRepository.deleteAll();
        accountRepository.deleteAll();
    }

    @Test
    public void changeNewStatus_validate() throws Exception{
            /*Product prod = Product.BOX;
            Contact contact = new Contact("Pedro Lopez", "675345829", "pedro@yahho.es", "Movil Phone");
            Status status = Status.OPEN;
            Opportunity op = new Opportunity(prod,3,contact,status);
            Map<Integer,Opportunity> mapOp = new HashMap<>();
            mapOp.put(op.getId(),op);
            OldCRM.setOpportunityMap(mapOp);

            Scanner scanner = new Scanner(new StringReader("close-lost 1"));
            OldCRM.changeNewStatus(scanner);

            assertEquals(mapOp.get(1).getStatus(), Status.CLOSED_LOST);*/
    }

    /*
    changeOppStatus

    maxOpportunityByAccount

    minOpportunityByAccount

    meanOpportunityByAccount

    medianOpportunityByAccount

     */
}