package com.ironhack.crmsystem.service;

import com.ironhack.crmsystem.components.Colors;
import com.ironhack.crmsystem.components.Menu;
import com.ironhack.crmsystem.components.Utilities;
import com.ironhack.crmsystem.enums.Industry;
import com.ironhack.crmsystem.enums.Product;
import com.ironhack.crmsystem.enums.Status;
import com.ironhack.crmsystem.model.*;
import com.ironhack.crmsystem.repository.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service
public class LeadService {

    private Utilities utilities = new Utilities();
    private Menu menu = new Menu();
    @Autowired
    private SalesRepRepository salesRepRepository;

    @Autowired
    private SalesRepService salesRepService;

    @Autowired
    private LeadRepository leadRepository;

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private OpportunityRepository opportunityRepository;

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
    @Transactional
    public void convertLead(Scanner scanner) {
        //Header of the method
        System.out.println();
        System.out.println(Colors.GREEN_BOLD_BRIGHT + "You have selected the \"Convert a Lead into an Opportunity\" option");
        System.out.println(Colors.YELLOW_BOLD_BRIGHT + "You must enter the data that will be requested below");
        System.out.println(Colors.RESET);

        Lead l = new Lead();
        Contact c = new Contact();
        Opportunity o = new Opportunity();

            if (leadRepository.getCount() == 0) {
            System.out.println("The company has no Leads");
            System.out.println();
            Menu.enterToContinue(Colors.YELLOW_BOLD_BRIGHT + "Press ENTER to continue...");
            System.out.println();
            System.out.println(Colors.RESET + "---------------------------------------------------------------------------------");
            System.out.println();
            menu.displayPrincipalMenu(scanner);
            } else {
            //selection of the LEAD
            System.out.println("These are the leads available: ");
            LeadsList();
            System.out.println("Please introduce the ID of the lead you would like to convert");
            }

            //int id = Integer.parseInt(scanner.toString());
            //if (leadRepository.findById().isPresent()) {

                l = leadId(scanner);

                System.out.println("Now we will ask you some information to create the Opportunity");
                //creation of the opportunity
                SalesRep s = l.getSalesRep();
                System.out.println("Select the type of product: ");
                utilities.printEnum("product");
                scanner.nextLine();
                Product p = utilities.productSelection(scanner);
                System.out.println("Quantity you want to purchase: ");
                int quantity = utilities.quantityNumber(scanner);
                c = new Contact(l.getName(), l.getPhoneNumber(), l.getEmailAddress(), l.getCompanyName());
                contactRepository.save(c);
                 o = new Opportunity(p, quantity, c, Status.OPEN, s);
                leadRepository.deleteById(l.getId());
                opportunityRepository.save(o);
                List<Account> acc = accountRepository.findAll();

                //creation of the account
                if (!createNewAccount(scanner) && acc.size()  != 0) {
                        System.out.println("These are the actual accounts");
                        List<Account> accounts = accountRepository.findAll();
                        utilities.printAccount(accounts);
                        System.out.println("Input the ID of you account: ");
                        Account a = validAccountId(scanner);
                        List<Opportunity> listopp = a.getOpportunityList();
                        listopp.add(o);
                        a.setOpportunityList(listopp);
                        List<Contact> listcont = a.getContactList();
                        listcont.add(c);
                        a.setContactList(listcont);
                        accountRepository.save(a);
                } else {
                    System.out.println("Maybe you chose to or maybe you have to create an account bc there are not any");
                    System.out.println("Now we will ask you some information to create the Account: ");
                    System.out.println("Number of employees of your company:");
                    int employees = utilities.quantityNumber(scanner);
                    System.out.println("Select a type of industry");
                    utilities.printEnum("industry");
                    Industry i = utilities.industrySelection(scanner);
                    String country = utilities.countryInput(scanner);
                    System.out.println("Write the city please");
                    String city = scanner.nextLine();
                    List<Contact> contacts = new ArrayList<>();
                    contacts.add(c);
                    List<Opportunity> opportunities = new ArrayList<>();
                    opportunities.add(o);
                    Account ac = new Account(i, employees, city, country, l.getCompanyName(), contacts, opportunities);
                    accountRepository.save(ac);
                }

                //Foot of the method
                System.out.println();
                System.out.println(Colors.YELLOW_BOLD_BRIGHT + "You have converted the Lead suscesfully!!");
                Menu.enterToContinue(Colors.YELLOW_BOLD_BRIGHT + "Press ENTER to continue...");
                System.out.println();
                System.out.println(Colors.RESET + "---------------------------------------------------------------------------------");
                System.out.println();

            }



    public Account validAccountId(Scanner scanner){
        Account account = new Account();
        int id = 0;
        try{
            id = scanner.nextInt();
            while(!accountRepository.findById(id).isPresent()){
                System.err.println("That Account doesn't exits. Try again please");
                id = scanner.nextInt();
            }
            account = accountRepository.findById(id).get();
        }catch(Exception e){
            System.err.println("Thats not a number please try again");
            scanner.next();
            account = validAccountId(scanner);
        }
        System.out.println("Successful account selection!");
        return account;
    }
    public boolean createNewAccount(Scanner scanner){
        boolean createAccount = false;
        System.out.println("Would you like to create a new Account[yes/no]:");
        String s = scanner.nextLine();
        switch (s.toLowerCase()){
            case "yes":
                createAccount = true;
                System.out.println("You have selected create a new account");
                break;
            case "no":
                System.out.println("You have selected not to create a new account");
                break;
            default:
                System.err.println("Invalid answer. Write only yes/no");
                createAccount= createNewAccount(scanner);
        }
        return createAccount;

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
        //Header of the method
        System.out.println();
        System.out.println(Colors.GREEN_BOLD_BRIGHT + "You have selected the \"Leads By SalesRep\" option");
        System.out.println(Colors.RESET);

        List<Object[]> objectList = leadRepository.countOfLeadsBySalesRep();
        System.out.println("Count of leads by salesRep:");
        for (Object[] obj : objectList) {
            System.out.println("SalesRep: " +obj[0].toString() +"  ------> Count of Leads: "+ obj[1].toString());
        }

        System.out.println();
        Menu.enterToContinue(Colors.YELLOW_BOLD_BRIGHT + "Press ENTER to continue...");
        System.out.println();
        System.out.println(Colors.RESET + "---------------------------------------------------------------------------------");
        System.out.println();

    }
}
