package com.ironhack.crmsystem.components;

import com.ironhack.crmsystem.model.Account;
import com.ironhack.crmsystem.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class Menu {

    @Autowired
    private SalesRepService salesRepService;

    @Autowired
    private LeadService leadService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private OpportunityService opportunityService;

    public static void welcome() {
        System.out.println();
        System.out.println(Colors.YELLOW_BOLD_BRIGHT + "||       ||ººº\\\\   ||        " + Colors.GREEN_BOLD_BRIGHT + "ººººººººº  ||ºººº\\\\  ||      ||   //ººº\\\\  ||   //  ºº||ºº  ||\\\\    ||   //ººº\\\\");
        System.out.println(Colors.YELLOW_BOLD_BRIGHT + "||       ||   //   ||           " + Colors.GREEN_BOLD_BRIGHT + "TT      ||    //  ||      ||  //        ||  //     ||    || \\\\   ||  // ");
        System.out.println(Colors.YELLOW_BOLD_BRIGHT + "||       ||==||    ||           " + Colors.GREEN_BOLD_BRIGHT + "||      ||___//   ||      ||  ||        ||=||      ||    ||  \\\\  ||  ||    ____");
        System.out.println(Colors.YELLOW_BOLD_BRIGHT + "||____   ||   \\\\   ||____      " + Colors.GREEN_BOLD_BRIGHT + " ||      ||   \\\\    \\\\____//   \\\\        ||  \\\\     ||    ||   \\\\ ||  \\\\     //");
        System.out.println(Colors.YELLOW_BOLD_BRIGHT + "||____|  ||___//   ||____|      " + Colors.GREEN_BOLD_BRIGHT + "||      ||    \\\\    \\\\__//     \\\\___//  ||   \\\\  __||__  ||    \\\\||   \\\\___//");
        System.out.println();
        System.out.println("                                 //ººº\\\\   //ººº\\\\   ||\\\\   //||  ||ºººº\\\\    //\\\\       ||\\\\    ||   \\\\    //");
        System.out.println("                                //        //     \\\\  || \\\\ // ||  ||    //   //  \\\\      || \\\\   ||    \\\\  //");
        System.out.println("                                ||        ||     ||  ||  \\=/  ||  ||___//   //____\\\\     ||  \\\\  ||     \\\\//");
        System.out.println("                                \\\\        \\\\     //  ||       ||  ||       //======\\\\    ||   \\\\ ||      ||");
        System.out.println("                                 \\\\___//   \\\\___//   ||       ||  ||      //        \\\\   ||    \\\\||      ||");

        System.out.println(Colors.YELLOW_BRIGHT);
        System.out.println("                                                                                              @codebreakers");
        System.out.println(Colors.RESET);

        System.out.println();
        System.out.println("                                       Welcome to LBL Trucking Company CRM. Press ENTER to start the program");
        enterToContinue("------------------------------------------------------------------------------------------------------------");
    }

    public static void enterToContinue(String enter) {
        System.out.println(enter);
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }


    public void displayPrincipalMenu(Scanner scanner) {
        System.out.print(Colors.GREEN_BOLD_BRIGHT);
        System.out.println("You have the following options:");
        System.out.println("Please, type the command indicated [in brackets] for the action you want to perform");
        System.out.println(Colors.RESET);
        System.out.println("  - Create a SalesRep" + Colors.YELLOW_BRIGHT + " [New SalesRep]" + Colors.RESET); //New
        System.out.println("  - Display list of SalesRep" + Colors.YELLOW_BRIGHT + " [Show SalesReps]" + Colors.RESET); //New
        System.out.println("  - Create a Lead" + Colors.YELLOW_BRIGHT + " [New Lead]" + Colors.RESET); //Modify
        System.out.println("  - Turn a Lead into an Opportunity" + Colors.YELLOW_BRIGHT + " [convert]" + Colors.RESET); //Modify
        System.out.println("  - Change Opportunity status" + Colors.YELLOW_BRIGHT + " [change status]" + Colors.RESET);
        System.out.println("  - Access to Lead reports" + Colors.YELLOW_BRIGHT + " [Lead reports]" + Colors.RESET); //New
        System.out.println("  - Access to Opportunity reports" + Colors.YELLOW_BRIGHT + " [Opportunity reports]" + Colors.RESET); //New
        System.out.println("  - Access to quantities of product orders stats" + Colors.YELLOW_BRIGHT + " [Quantity]" + Colors.RESET); //New
        System.out.println("  - Access to Opportunities per account stats" + Colors.YELLOW_BRIGHT + " [Account]" + Colors.RESET); //New
        System.out.println("  - Close the program" + Colors.YELLOW_BRIGHT + " [exit]" + Colors.RESET);
        scanner = new Scanner(System.in);
        selectOptionPrincipalMenu(scanner);
    }

    public void selectOptionPrincipalMenu(Scanner scanner) {
        boolean selected = false;
        String option = "";
        while (option.isEmpty()) {
            option = scanner.nextLine().toLowerCase();
            switch (option) {
                case "new salesrep" ->
                        salesRepService.createSalesRep(scanner);
                case "show salesreps" -> salesRepService.showSalesRep(scanner);
                case "new lead" -> leadService.createLead(scanner);
                case "convert" -> leadService.convertLead(scanner);
                case "change status" -> opportunityService.changeOppStatus(scanner);
                case "lead reports" -> displayOptionLeadsMenu(scanner);
                case "opportunity reports" -> displayOptionOpportunityMenu(scanner);
                case "quantity" -> selectOptionQuantityMenu(scanner);
                case "account" -> selectOptionAccountMenu(scanner);
                case "exit" -> {
                    System.out.println();
                    System.out.println(Colors.GREEN_BOLD_BRIGHT + "The program is shutting down");
                    System.out.println(Colors.YELLOW_BOLD_BRIGHT + "See you soon......");
                    System.exit(0);
                }
                default -> {
                    System.out.println("Wrong command. Please, try again");
                }
            }
        }
        displayPrincipalMenu(scanner);
    }


    public void displayOptionLeadsMenu(Scanner scanner) {
        System.out.print(Colors.GREEN_BOLD_BRIGHT);
        System.out.println("You are in the Leads reports section");
        System.out.println("You have the following options:");
        System.out.println("Please, type the command indicated [in brackets] for the action you want to perform");
        System.out.println(Colors.RESET);
        System.out.println("  - Display list of Leads" + Colors.YELLOW_BRIGHT + " [Show Leads]" + Colors.RESET);
        System.out.println("  - Show details of a Lead" + Colors.YELLOW_BRIGHT + " [Lookup Lead]" + Colors.RESET);
        System.out.println("  - Count of Leads by SalesRep" + Colors.YELLOW_BRIGHT + " [Leads by SalesRep]" + Colors.RESET);
        System.out.println("  - Return to principal menu " + Colors.YELLOW_BRIGHT + " [exit]" + Colors.RESET);
        boolean selected = false;
        String option = "";
        while (option.isEmpty()) {
            option = scanner.nextLine().toLowerCase();
            switch (option) {
                case "show leads" -> leadService.showLeads(scanner);
                case "lookup lead" -> leadService.leadDetail(scanner);
                case "Leads by salesrep" -> leadService.countOfLeadsBySalesRep();
                case "exit" -> displayPrincipalMenu(scanner);
                default -> {
                    System.out.println("Wrong command. Please, try again");
                }

            }
        }
        displayOptionLeadsMenu(scanner);
    }

    public void displayOptionOpportunityMenu(Scanner scanner) {
        System.out.print(Colors.GREEN_BOLD_BRIGHT);
        System.out.println("You are in the Opportunities reports section");
        System.out.println("You have the following options:");
        System.out.println("Please, type the command indicated [in brackets] for the action you want to perform");
        System.out.println(Colors.RESET);
        System.out.println("  - Display Opportunities by SalesRep" + Colors.YELLOW_BRIGHT + " [report by salesrep]" + Colors.RESET); //New
        System.out.println("  - Display Opportunities by Status" + Colors.YELLOW_BRIGHT + " [report by salesrep and status]" + Colors.RESET); //New
        System.out.println("  - Display Opportunities by Product" + Colors.YELLOW_BRIGHT + " [report by product]" + Colors.RESET); //New
        System.out.println("  - Display Opportunities by Product and Status" + Colors.YELLOW_BRIGHT + " [report by product and status]" + Colors.RESET); //New
        System.out.println("  - Display Opportunities by Country" + Colors.YELLOW_BRIGHT + " [report by country]" + Colors.RESET); //New
        System.out.println("  - Display Opportunities by Country an Status" + Colors.YELLOW_BRIGHT + " [report by country and status]" + Colors.RESET); //New
        System.out.println("  - Display Opportunities by City" + Colors.YELLOW_BRIGHT + " [report by city]" + Colors.RESET); //New
        System.out.println("  - Display Opportunities by City and Status" + Colors.YELLOW_BRIGHT + " [report by city and status]" + Colors.RESET); //New
        System.out.println("  - Display Opportunities by Industry" + Colors.YELLOW_BRIGHT + " [report by industry]" + Colors.RESET); //New
        System.out.println("  - Display Opportunities by Industry and Status" + Colors.YELLOW_BRIGHT + " [report by industry and status]" + Colors.RESET); //New
        System.out.println("  - Display Opportunities by Quantity" + Colors.YELLOW_BRIGHT + " [report by quantity]" + Colors.RESET); //New
        System.out.println("  - Display Opportunities by Quantity and Status" + Colors.YELLOW_BRIGHT + " [report by quantity and status]" + Colors.RESET); //New
        System.out.println("  - Return to principal menu " + Colors.YELLOW_BRIGHT + " [exit]" + Colors.RESET);

        boolean selected = false;
        String option = "";
        while (option.isEmpty()) {
            option = scanner.nextLine().toLowerCase();
            switch (option) {
                case "report by salesrep" -> opportunityService.opportunitiesBySalesRep(scanner);
                //cambio de nombre
                case "report by salesrep and status" -> opportunityService.opportunitiesBySalesRepAndStatus(scanner);
                case "report by product" -> opportunityService.opportunitiesByProduct(scanner);
                case "report by product and status" -> opportunityService.opportunitiesByProductAndStatus(scanner);
                case "report by country" -> opportunityService.opportunitiesByCountry(scanner);
                case "report by country and status" -> opportunityService.opportunitiesByCountryAndStatus(scanner);
                case "report by city" -> opportunityService.opportunitiesByCity(scanner);
                case "report by city and status" -> opportunityService.opportunitiesByCityAndStatus(scanner);
                case "report by industry" -> opportunityService.opportunitiesByIndustry(scanner);
                case "report by industry and status" -> opportunityService.opportunitiesByIndustryAndStatus(scanner);
                case "report by quantity" -> opportunityService.opportunitiesByQuantity(scanner);
                case "report by quantity and status" -> opportunityService.opportunitiesByQuantityAndStatus(scanner);
                case "exit" -> displayPrincipalMenu(scanner);
                default -> {
                    System.out.println("Wrong command. Please, try again");
                }

            }
        }
        displayOptionOpportunityMenu(scanner);
    }

    public void selectOptionAccountMenu(Scanner scanner) {

        System.out.print(Colors.GREEN_BOLD_BRIGHT);
        System.out.println("You are in the Accounts reports section");
        System.out.println("You have the following options:");
        System.out.println("Please, type the command indicated [in brackets] for the action you want to perform");
        System.out.println(Colors.RESET);
        System.out.println("  - Maximum number of employees" + Colors.YELLOW_BRIGHT + " [Max EmployeeCount]" + Colors.RESET); //New
        System.out.println("  - Minimum number of employees" + Colors.YELLOW_BRIGHT + " [Min EmployeeCount]" + Colors.RESET); //New
        System.out.println("  - Mean number of employees" + Colors.YELLOW_BRIGHT + " [Mean EmployeeCount]" + Colors.RESET); //New
        System.out.println("  - Median number of employees" + Colors.YELLOW_BRIGHT + " [Median EmployeeCount]" + Colors.RESET); //New
        System.out.println("  - Maximum number of Opportunity" + Colors.YELLOW_BRIGHT + " [Max Opportunity]" + Colors.RESET); //New
        System.out.println("  - Minimum number of Opportunity" + Colors.YELLOW_BRIGHT + " [Min Opportunity]" + Colors.RESET); //New
        System.out.println("  - Mean number of Opportunity" + Colors.YELLOW_BRIGHT + " [Mean Opportunity]" + Colors.RESET); //New
        System.out.println("  - Median number of Opportunity" + Colors.YELLOW_BRIGHT + " [Median Opportunity]" + Colors.RESET); //New
        System.out.println("  - Return to principal menu " + Colors.YELLOW_BRIGHT + " [exit]" + Colors.RESET);

        boolean selected = false;
        String option = "";
        while (option.isEmpty()) {
            option = scanner.nextLine().toLowerCase();
            switch (option) {
                case "max employeecount" -> accountService.maxEmployeeCont();
                case "min employeecount" -> accountService.minEmployeeCont();
                case "mean employeecount" -> accountService.meanEmployeeCont();
                case "median employeecount" -> accountService.medianEmployeeCont();
                case "max opportunity" -> opportunityService.maxOpportunityByAccount();
                case "min opportunity" -> opportunityService.minOpportunityByAccount();
                case "mean opportunity" -> opportunityService.meanOpportunityByAccount();
                case "median opportunity" -> opportunityService.medianOpportunityByAccount();
                case "exit" -> displayPrincipalMenu(scanner);
                default -> {
                    System.out.println("Wrong command. Please, try again");
                }

            }
        }

        selectOptionAccountMenu(scanner);
    }
    public void selectOptionQuantityMenu(Scanner scanner) {
        System.out.print(Colors.GREEN_BOLD_BRIGHT);
        System.out.println("You are in the quantity of products reports section");
        System.out.println("You have the following options:");
        System.out.println("Please, type the command indicated [in brackets] for the action you want to perform");
        System.out.println(Colors.RESET);
        System.out.println("  - Maximum number of Quantity" + Colors.YELLOW_BRIGHT + " [Max Quantity]" + Colors.RESET); //New
        System.out.println("  - Minimum number of Quantity" + Colors.YELLOW_BRIGHT + " [Min Quantity]" + Colors.RESET); //New
        System.out.println("  - Mean number of Quantity" + Colors.YELLOW_BRIGHT + " [Mean Quantity]" + Colors.RESET); //New
        System.out.println("  - Median number of Quantity" + Colors.YELLOW_BRIGHT + " [Median Quantity]" + Colors.RESET); //New
        System.out.println("  - Return to principal menu " + Colors.YELLOW_BRIGHT + " [exit]" + Colors.RESET);
        boolean selected = false;
        String option = "";
        while (option.isEmpty()) {
            option = scanner.nextLine().toLowerCase();
            switch (option) {
                case "max quantity" -> opportunityService.maxQuantity();
                case "min quantity" -> opportunityService.minQuantity();
                case "mean quantity" -> opportunityService.meanQuantity();
                case "median quantity" -> opportunityService.medianQuantity();
                case "exit" -> displayPrincipalMenu(scanner);
                default -> {
                    System.out.println("Wrong command. Please, try again");
                }

            }

        }
        selectOptionQuantityMenu(scanner);
    }
}
