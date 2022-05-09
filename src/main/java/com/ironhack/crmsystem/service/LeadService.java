package com.ironhack.crmsystem.service;

import com.ironhack.crmsystem.components.Colors;
import com.ironhack.crmsystem.components.Menu;
import com.ironhack.crmsystem.components.Utilities;
import com.ironhack.crmsystem.model.Lead;
import com.ironhack.crmsystem.model.SalesRep;
import com.ironhack.crmsystem.repository.LeadRepository;
import com.ironhack.crmsystem.repository.SalesRepRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@Service
public class LeadService {

    private Utilities utilities = new Utilities();
    @Autowired
    private SalesRepRepository salesRepRepository;

    @Autowired
    private SalesRepService salesRepService;

    @Autowired
    private LeadRepository leadRepository;

    public void createLead(Scanner scanner){
        //Header of the method
        System.out.println();
        System.out.println(Colors.GREEN_BOLD_BRIGHT + "You have selected the \"NewLead\" option");
        System.out.println(Colors.YELLOW_BOLD_BRIGHT + "You must enter the data that will be requested below");
        System.out.println(Colors.RESET);

        String name = Utilities.nameLead(scanner);
        String phone = Utilities.phoneNumberLead(scanner);
        String email = Utilities.emailLead(scanner);
        String company = Utilities.companyNameLead(scanner);
        System.out.println("The are the available SalesRep");
        salesRepService.SalesRepList(scanner);
        System.out.println(Colors.YELLOW_BOLD_BRIGHT + "Enter the ID of the SalesRep");
        SalesRep s = LeadSalesRep(scanner);
        Lead lead = new Lead(name, phone, email, company,s);
        leadRepository.save(lead);

        //Foot of the method
        System.out.println();
        System.out.println(Colors.YELLOW_BOLD_BRIGHT + "You have inserted a Lead");
        Menu.enterToContinue(Colors.YELLOW_BOLD_BRIGHT + "Press ENTER to continue...");
        System.out.println();
        System.out.println(Colors.RESET + "---------------------------------------------------------------------------------");
        System.out.println();

    }

    public SalesRep LeadSalesRep(Scanner Scanner){
        SalesRep s = new SalesRep();
        int id = 0;
        try{
            id = Scanner.nextInt();
            while(!salesRepRepository.findById(id).isPresent()){
                System.err.println("That salesRep doesn't exits. Try again please");
                id = Scanner.nextInt();
            }
            s = salesRepRepository.findById(id).get();
        }catch(Exception e){
            System.err.println("Thats not a number please try again");
            Scanner.next();
            s = LeadSalesRep(Scanner);
        }
        return s;
    }

    public void convertLead(Scanner scanner){
    }

    public void LeadsList(){
        List<Lead> leads = leadRepository.findAll();
        utilities.printLead(leads);
    }


    public void showLeads(Scanner scanner){
        //Header of the method
        System.out.println();
        System.out.println(Colors.GREEN_BOLD_BRIGHT + "You have selected the \"Show Leads\" option");
        System.out.println(Colors.RESET);

        LeadsList();

        System.out.println();
        Menu.enterToContinue(Colors.YELLOW_BOLD_BRIGHT + "Press ENTER to continue...");
        System.out.println();
        System.out.println(Colors.RESET + "---------------------------------------------------------------------------------");
        System.out.println();
    }

    public void leadDetail(Scanner scanner){
        //Header of the method
        System.out.println();
        System.out.println(Colors.GREEN_BOLD_BRIGHT + "You have selected the \"Lead Detail\" option");
        System.out.println(Colors.RESET);

        System.out.println("This are the available leads:");
        LeadsList();
        System.out.println();
        System.out.println("Please introduce the ID you want to lookup: ");
        Lead d = leadId(scanner);

        System.out.println(Colors.GREEN_BOLD_BRIGHT + "NAME: " + Colors.RESET + d.getName());
        System.out.println(Colors.GREEN_BOLD_BRIGHT + "PHONE NUMBER: " + Colors.RESET + d.getPhoneNumber());
        System.out.println(Colors.GREEN_BOLD_BRIGHT + "EMAIL: " + Colors.RESET + d.getEmailAddress());
        System.out.println(Colors.GREEN_BOLD_BRIGHT + "COMPANY: " + Colors.RESET + d.getCompanyName());
        System.out.println(Colors.GREEN_BOLD_BRIGHT + "SALES REP: " + Colors.RESET + d.getSalesRep().getName());


        System.out.println();
        Menu.enterToContinue(Colors.YELLOW_BOLD_BRIGHT + "Press ENTER to continue...");
        System.out.println();
        System.out.println(Colors.RESET + "---------------------------------------------------------------------------------");
        System.out.println();
    }

    public Lead leadId(Scanner scanner){
        Lead lead = new Lead();
        int id = 0;
        try{
            id = scanner.nextInt();
            while(!leadRepository.findById(id).isPresent()){
                System.err.println("That Lead doesn't exits. Try again please");
                id = scanner.nextInt();
            }
            lead = leadRepository.findById(id).get();
        }catch(Exception e){
            System.err.println("Thats not a number please try again");
            scanner.next();
            lead = leadId(scanner);
        }
        return lead;
    }

    public void countOfLeadsBySalesRep(){

    }
}
