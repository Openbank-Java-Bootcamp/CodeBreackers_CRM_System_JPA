package com.ironhack.crmsystem.model;

import java.util.Scanner;

public class Menu {

    public static void welcome(){
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

    public static void displayMenu(Scanner scanner, OldCRM crm) {
        System.out.print(Colors.GREEN_BOLD_BRIGHT);
        System.out.println("You have the following options:");
        System.out.println("Please, type the command indicated [in brackets] for the action you want to perform");
        System.out.println(Colors.RESET);
        System.out.println("  - Create a Lead" + Colors.YELLOW_BRIGHT + " [New Lead]" + Colors.RESET); //Modify
        System.out.println("  - Create a SalesRep"  + Colors.YELLOW_BRIGHT + " [New SalesRep]" + Colors.RESET); //New
        System.out.println("  - Turn a Lead into an Opportunity" + Colors.YELLOW_BRIGHT + " [convert]" + Colors.RESET); //Modify
        System.out.println("  - Change Opportunity status"  + Colors.YELLOW_BRIGHT + " [change status]" + Colors.RESET);
        //Yadira
        System.out.println("  - Display list of SalesRep"  + Colors.YELLOW_BRIGHT + " [Show SalesReps]" + Colors.RESET); //New

        //Yadira
        System.out.println("  - Access to Lead reports"  + Colors.YELLOW_BRIGHT + " [Lead reports]" + Colors.RESET); //New
                System.out.println("  - Display list of Leads"  + Colors.YELLOW_BRIGHT + " [Show Leads]" + Colors.RESET);
                System.out.println("  - Show details of a Lead"  + Colors.YELLOW_BRIGHT + " [Lookup Lead]" + Colors.RESET);
                System.out.println("  - Count of Leads by SalesRep"  + Colors.YELLOW_BRIGHT + " [Opportunity by SalesRep]" + Colors.RESET);

        //Paula
        System.out.println("  - Access to Opportunity reports"  + Colors.YELLOW_BRIGHT + " [Opportunity reports]" + Colors.RESET); //New
                System.out.println("  - Display Opportunities by SalesRep"  + Colors.YELLOW_BRIGHT + " [Report Opportunity by SalesRep]" + Colors.RESET); //New
                        System.out.println("  - Display Opportunities by Status"  + Colors.YELLOW_BRIGHT + " [Report by Status]" + Colors.RESET); //New
                System.out.println("  - Display Opportunities by Product"  + Colors.YELLOW_BRIGHT + " [Report Opportunity by the product]" + Colors.RESET); //New
                        System.out.println("  - Display Opportunities by Product and Status"  + Colors.YELLOW_BRIGHT + " [Report by Product and Status]" + Colors.RESET); //New
                System.out.println("  - Display Opportunities by Country"  + Colors.YELLOW_BRIGHT + " [Report Opportunity by the Country]" + Colors.RESET); //New
                        System.out.println("  - Display Opportunities by Country an Status"  + Colors.YELLOW_BRIGHT + " [Report by Country and Status]" + Colors.RESET); //New
                System.out.println("  - Display Opportunities by City"  + Colors.YELLOW_BRIGHT + " [Report Opportunity by the City]" + Colors.RESET); //New
                        System.out.println("  - Display Opportunities by City and Status"  + Colors.YELLOW_BRIGHT + " [Report by City and Status]" + Colors.RESET); //New
                System.out.println("  - Display Opportunities by Industry"  + Colors.YELLOW_BRIGHT + " [Report Opportunity by the Industry]" + Colors.RESET); //New
                        System.out.println("  - Display Opportunities by Industry and Status"  + Colors.YELLOW_BRIGHT + " [Report by Industry and Status]" + Colors.RESET); //New

        //Pilar
        System.out.println("  - Access to Employee stats"  + Colors.YELLOW_BRIGHT + " [EmployeeCount]" + Colors.RESET); //New
                System.out.println("  - Maximum number of employees"  + Colors.YELLOW_BRIGHT + " [Max EmployeeCount]" + Colors.RESET); //New
                System.out.println("  - Minimum number of employees"  + Colors.YELLOW_BRIGHT + " [Min EmployeeCount]" + Colors.RESET); //New
                System.out.println("  - Mean number of employees"  + Colors.YELLOW_BRIGHT + " [Mean EmployeeCount]" + Colors.RESET); //New
                System.out.println("  - Median number of employees"  + Colors.YELLOW_BRIGHT + " [Median EmployeeCount]" + Colors.RESET); //New

        //Maria
        System.out.println("  - Access to Quantities of product orders stats"  + Colors.YELLOW_BRIGHT + " [Quantity]" + Colors.RESET); //New
                System.out.println("  - Maximum number of Quantity"  + Colors.YELLOW_BRIGHT + " [Max Quantity]" + Colors.RESET); //New
                System.out.println("  - Minimum number of Quantity"  + Colors.YELLOW_BRIGHT + " [Min Quantity]" + Colors.RESET); //New
                System.out.println("  - Mean number of Quantity"  + Colors.YELLOW_BRIGHT + " [Mean Quantity]" + Colors.RESET); //New
                System.out.println("  - Median number of Quantity"  + Colors.YELLOW_BRIGHT + " [Median Quantity]" + Colors.RESET); //New

        //Yadira
        System.out.println("  - Access to Opportunities per account stats"  + Colors.YELLOW_BRIGHT + " [Opportunity]" + Colors.RESET); //New
                System.out.println("  - Maximum number of Opportunity"  + Colors.YELLOW_BRIGHT + " [Max Opportunity]" + Colors.RESET); //New
                System.out.println("  - Minimum number of Opportunity"  + Colors.YELLOW_BRIGHT + " [Min Opportunity]" + Colors.RESET); //New
                System.out.println("  - Mean number of Opportunity"  + Colors.YELLOW_BRIGHT + " [Mean Opportunity]" + Colors.RESET); //New
                System.out.println("  - Median number of Opportunity"  + Colors.YELLOW_BRIGHT + " [Median Opportunity]" + Colors.RESET); //New

        //exit
        System.out.println("  - Close the program"  + Colors.YELLOW_BRIGHT + " [exit]" + Colors.RESET);
        scanner = new Scanner(System.in);
        selectOption(scanner,crm);
    }


    public static void selectOption(Scanner scanner, OldCRM crm) {
        boolean selected = false;
        String option = "";
        while (option.isEmpty()){
            option = scanner.nextLine().toLowerCase();
            switch (option) {
                case "new lead" -> crm.createLead(scanner);
                case "show leads" -> crm.listIdName(crm);
                case "lookup lead" -> crm.leadDetail(scanner, crm);
                case "convert" -> crm.convertLead(scanner);
                case "change status" -> crm.changeOppStatus(scanner);
                //new options
                //case "lead by salesrep" -> crm.leadBysalesRep(scanner);

                case "exit" -> {
                    System.out.println();
                    System.out.println(Colors.GREEN_BOLD_BRIGHT + "The program is shutting down");
                    System.out.println(Colors.YELLOW_BOLD_BRIGHT + "See you soon......");
                    System.exit(0);
                }
                default -> {
                    System.out.println("Wrong command. Please, try again");
                    option = "";
                }
            }
        }
    }

}
