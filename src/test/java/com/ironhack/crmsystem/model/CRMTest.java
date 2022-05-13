package com.ironhack.crmsystem.model;
import com.ironhack.crmsystem.enums.Industry;
import com.ironhack.crmsystem.enums.Product;
import com.ironhack.crmsystem.enums.Status;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import org.junit.jupiter.api.Test;


import org.junit.After;
import org.junit.jupiter.api.BeforeEach;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

import nl.altindag.console.ConsoleCaptor;


class CRMTest {
    /*private OldCRM crm;
    private Scanner s;

    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalErr = System.err;


    @BeforeEach
    public void setUp(){
        crm = new OldCRM();
        System.setErr(new PrintStream(errContent));
    }
    @After
    public void restoreStreams() {
        System.setErr(originalErr);
    }


    @Test
    public void quantityNumber_Throw_notINT(){
        StringReader sr = new StringReader("s");
        Scanner scan = new Scanner(sr);
        ConsoleCaptor consoleCaptor = new ConsoleCaptor();
        List<String> s = consoleCaptor.getErrorOutput();
        consoleCaptor.close();
        assertThat(s.contains("That´s not a number. Please try again"));

    }




    //check if we can add shaun ideas
    @Test
    public void countryInput_err(){
        StringReader sr = new StringReader("Spain");
        Scanner scan = new Scanner(sr);
        ConsoleCaptor consoleCaptor = new ConsoleCaptor();
        crm.countryInput(scan);
        List<String> s = consoleCaptor.getErrorOutput();
        consoleCaptor.close();
        assertThat(s.contains("Thats not a valid country. Please try again"));
    }


    @Test
    public void changeNewStatus_PermittedCommand(){
        //Opportunity
        Product prod = Product.BOX;
        Contact contact = new Contact("Pedro Lopez", "675345829", "pedro@yahho.es", "Movil Phone");
        Status status = Status.OPEN;
        Opportunity op = new Opportunity(prod,3,contact,status);
        Map<Integer,Opportunity> mapOp = new HashMap<>();
        mapOp.put(op.getId(),op);
        OldCRM.setOpportunityMap(mapOp);

        Scanner scanner = new Scanner(new StringReader("close-lost 1"));
        OldCRM.changeNewStatus(scanner);

        assertEquals(mapOp.get(1).getStatus(), Status.CLOSED_LOST);
    }


    @Test
    public void ContactFromLead_Works(){
        Lead l = new Lead("Paula", "662092398", "paula@gmail.com", "Matucos");
        Map<Integer,Lead> leadMap = new HashMap<>();
        leadMap.put(l.getId(), l);
        OldCRM.setLeadMap(leadMap);
        Contact c = new Contact("Paula", "662092398", "paula@gmail.com", "Matucos");
        assertThat(c.equals(OldCRM.ContactFromLead(l.getId())));
        assertEquals(1, OldCRM.getContactMap().size());
    }

    @Test
    public void OpportunityFromLead_Works(){
        Contact c = new Contact("Paula", "662092398", "paula@gmail.com", "Matucos");
        Opportunity o = new Opportunity(Product.FLATBED, 2,c, Status.OPEN);
        assertThat(o.equals(crm.OpportunityFromLead(Product.FLATBED, 2,c)));
        assertEquals(1, crm.getOpportunityMap().size());
    }





    //================= CREATE A LEAD TEST==================

    @Test
    public void nameLead_Works() throws Exception {
        StringReader sr = new StringReader("pepe");
        Scanner scan = new Scanner(sr);
        assertEquals("pepe", crm.nameLead(scan) );
    }
    @Test
    public void phoneNumberLead_Works(){
        StringReader sr = new StringReader("675345829");
        Scanner scan = new Scanner(sr);
        assertEquals("675345829", crm.phoneNumberLead(scan) );
    }
    @Test
    public void emailLead_Works(){
        StringReader sr = new StringReader("paula@gmail.com");
        Scanner scan = new Scanner(sr);
        assertEquals("paula@gmail.com", crm.emailLead(scan) );
    }
    @Test
    public void companyLead_Works(){
        StringReader sr = new StringReader("Matucos");
        Scanner scan = new Scanner(sr);
        assertEquals("Matucos", crm.companyNameLead(scan) );
    }*/

}