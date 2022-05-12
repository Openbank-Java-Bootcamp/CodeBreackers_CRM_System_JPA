package com.ironhack.crmsystem.service;

import com.ironhack.crmsystem.components.Colors;
import com.ironhack.crmsystem.components.Menu;

import com.ironhack.crmsystem.components.Utilities;
import com.ironhack.crmsystem.enums.Status;

import com.ironhack.crmsystem.model.Opportunity;
import com.ironhack.crmsystem.repository.OpportunityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@Service
public class OpportunityService {

    

    private Utilities u = new Utilities();
    private Menu menu = new Menu();
    @Autowired
    private OpportunityRepository opportunityRepository;


    public void changeOppStatus(Scanner scanner){

        //Header of the method
        System.out.println();
        System.out.println(Colors.GREEN_BOLD_BRIGHT + "You have selected the \"Change Opportunity status\" option");
        System.out.println(Colors.RESET);

        if (opportunityRepository.getCount() == 0){
            System.out.println("The company has no Opportunities");
        } else {
            System.out.println(Colors.YELLOW_BOLD_BRIGHT + "The company owns the following Opportunities:");
            System.out.println(Colors.RESET);
            opportunityList();
            System.out.println();
            System.out.println("Please, enter the commands" + Colors.YELLOW_BOLD_BRIGHT + " [close-lost id]"
                    + Colors.RESET + " or " + Colors.YELLOW_BOLD_BRIGHT + "[close-won id]"
                    + Colors.RESET + " with the id of the Opportunity you want to change");
            System.out.println("For example, if you wants to close lost the Opportunity with id \"4321\", you have to type"
                    + Colors.YELLOW_BRIGHT + " [close-lost 4321]" + Colors.RESET);
            changeNewStatus(scanner);
        }
        System.out.println();
        Menu.enterToContinue(Colors.YELLOW_BOLD_BRIGHT + "Press ENTER to continue...");
        System.out.println();
        System.out.println(Colors.RESET + "---------------------------------------------------------------------------------");
        System.out.println();
        //menu.displayPrincipalMenu(scanner);

    }

    public void opportunitiesList(){
        List<Opportunity> opportunities = opportunityRepository.findAll();
        u.printOpportunities(opportunities);

    }

    public void opportunitiesBySalesRep(Scanner scanner){
       List<Object[]> stats =  opportunityRepository.findBySalesRepo();
       u.printStats(stats);
    }

    public void opportunitiesBySalesRepAndStatus(Scanner scanner){
        System.out.println("Introduce the Opportunity State you want to filter by: ");
        Status s = u.StateSelection(scanner);
        List<Object[]> stats =  opportunityRepository.findBySalesRepoAndStatus(s.toString());
        u.printStats(stats);
    }

    public void opportunitiesByProduct(Scanner scanner){
        List<Object[]> stats =  opportunityRepository.findByProduct();
        u.printStats(stats);
    }

    //ESTE SERIA PRODUCT AND STATUS
    public void opportunitiesByProductAndStatus(Scanner scanner){
        System.out.println("Introduce the Opportunity State you want to filter by: ");
        Status s = u.StateSelection(scanner);
        List<Object[]> stats =  opportunityRepository.findByProductAndState(s.toString());
        u.printStats(stats);
    }


    public void opportunitiesByCountry(Scanner scanner){
        List<Object[]> stats =  opportunityRepository.findByCountry();
        u.printStats(stats);
    }

    public void opportunitiesByCountryAndStatus(Scanner scanner){
        System.out.println("Introduce the Opportunity State you want to filter by: ");
        Status s = u.StateSelection(scanner);
        List<Object[]> stats =  opportunityRepository.findByCountryAndStatus(s.toString());
        u.printStats(stats);
    }
    public void opportunitiesByCity(Scanner scanner){
        List<Object[]> stats =  opportunityRepository.findByCity();
        u.printStats(stats);
    }
    public void opportunitiesByCityAndStatus(Scanner scanner){
        System.out.println("Introduce the Opportunity State you want to filter by: ");
        Status s = u.StateSelection(scanner);
        List<Object[]> stats =  opportunityRepository.findByCityAndStatus(s.toString());
        u.printStats(stats);
    }
    public void opportunitiesByIndustry(Scanner scanner){
        List<Object[]> stats =  opportunityRepository.findByIndustry();
        u.printStats(stats);
    }

    public void opportunitiesByIndustryAndStatus(Scanner scanner){
        System.out.println("Introduce the Opportunity State you want to filter by: ");
        Status s = u.StateSelection(scanner);
        List<Object[]> stats =  opportunityRepository.findByIndustryAndStatus(s.toString());
        u.printStats(stats);
    }
    public void opportunitiesByQuantityAndStatus(Scanner scanner){
        System.out.println("Introduce the Opportunity State you want to filter by: ");
        Status s = u.StateSelection(scanner);
        List<Object[]> stats =  opportunityRepository.findByQuantityAndStatus(s.toString());
        u.printStats(stats);
    }
    public void opportunitiesByQuantity(Scanner scanner){
        List<Object[]> stats =  opportunityRepository.findByQuantity();
        u.printStats(stats);
    }
    public void opportunityList(){
        List<Opportunity> opportunities = opportunityRepository.findAll();
        u.printOpportunities(opportunities);
    }

    public void changeNewStatus(Scanner scanner){
        try {
            String[] typed = scanner.nextLine().toLowerCase().split(" ");
            Opportunity opportunity = new Opportunity();
            if (typed.length != 2) {
                throw new Exception("The command entered or the id are wrong");
            }

            if (typed[1].matches(".*[0-9].*")) {
                int id = Integer.parseInt(typed[1]);
                if (opportunityRepository.findById(id).isPresent()) {
                    Opportunity opp = opportunityRepository.findById(id).get();
                    switch (typed[0]) {
                        case "close-lost" -> {
                            opp.setStatus(Status.CLOSED_LOST);
                            opportunityRepository.save(opp);
                            System.out.println(Colors.GREEN_BOLD_BRIGHT + "The status was changed successfully into CLOSED_LOST"
                                    + Colors.RESET);
                        }
                        case "close-won" -> {
                            opp.setStatus(Status.CLOSED_WON);
                            opportunityRepository.save(opp);
                            System.out.println(Colors.GREEN_BOLD_BRIGHT + "The status was changed successfully into CLOSED_LOST"
                                    + Colors.RESET);
                        }
                        default -> {
                            System.out.println("The command entered is wrong. Try again");
                            changeNewStatus(scanner);
                        }
                    }
                } else {
                    System.out.println("The id entered does not exist. Try again");
                    changeNewStatus(scanner);
                }
            }

        } catch (Exception e) {
            //System.out.println(Colors.RED_BRIGHT + e.getMessage() + Colors.RESET);
            System.out.println("Please, try again");
            changeNewStatus(scanner);
        }
    }

    public void maxQuantity(){
        int max=opportunityRepository.getMaxQuantity();
        System.out.println("Max Quantity is: " + max);

        System.out.println();
        Menu.enterToContinue(Colors.YELLOW_BOLD_BRIGHT + "Press ENTER to continue...");
        System.out.println();
        System.out.println(Colors.RESET + "---------------------------------------------------------------------------------");
        System.out.println();
    }
    public void minQuantity(){
        int min=opportunityRepository.getMinQuantity();
        System.out.println("Min Quantity is: " + min);

        System.out.println();
        Menu.enterToContinue(Colors.YELLOW_BOLD_BRIGHT + "Press ENTER to continue...");
        System.out.println();
        System.out.println(Colors.RESET + "---------------------------------------------------------------------------------");
        System.out.println();
    }
    public void meanQuantity(){
        //double mean=opportunityRepository.getAvgQuantity();
        System.out.println("Mean Quantity is: "+ opportunityRepository.getAvgQuantity());

        System.out.println();
        Menu.enterToContinue(Colors.YELLOW_BOLD_BRIGHT + "Press ENTER to continue...");
        System.out.println();
        System.out.println(Colors.RESET + "---------------------------------------------------------------------------------");
        System.out.println();
    }
    public void medianQuantity(){
        int size = opportunityRepository.sizeOfOpportunityDatabase();
        if(size% 2 != 0){  //odd
            int row = (int) Math.floor(size/2);
            int oddMedian=opportunityRepository.medianOfOddDBOpp(row);
            System.out.println("Median Quantity is:  "+ oddMedian);
        }else{  //even
            int row = (size/2)-1;
            double evenMedian=opportunityRepository.medianOfEvenDBOpp(row);
            System.out.println("Median Quantity is:  "+ evenMedian);
        }

        System.out.println();
        Menu.enterToContinue(Colors.YELLOW_BOLD_BRIGHT + "Press ENTER to continue...");
        System.out.println();
        System.out.println(Colors.RESET + "---------------------------------------------------------------------------------");
        System.out.println();
    }

    public void maxOpportunityByAccount(){
        /*List<Object[]> opportunities = opportunityRepository.findOpportunitiesByAccount();
        Object[] maxOpp = opportunities.get(0);

        String nameAcc = maxOpp[0].toString();
        String max = maxOpp[1].toString();

         */
        if(opportunityRepository.getCount() == 0){
            System.out.println("The company has no Opportunities");
        } else {

            Object maxOp = opportunityRepository.findMaxOpportunityByAccount();
            String nameAcc = ((Object[]) maxOp)[0].toString();
            String max = ((Object[]) maxOp)[1].toString();

            System.out.println("The Account with the greatest Opportunities is " + nameAcc + " with a number of " + max);
        }
        System.out.println();
        Menu.enterToContinue(Colors.YELLOW_BOLD_BRIGHT + "Press ENTER to continue...");
        System.out.println();
        System.out.println(Colors.RESET + "---------------------------------------------------------------------------------");
        System.out.println();
    }
    public void minOpportunityByAccount(){

        /*List<Object[]> opportunities = opportunityRepository.findOpportunitiesByAccount();
        int totalAcc = opportunities.size();
        Object[] mixOpp = opportunities.get(totalAcc-1);

        String nameAcc = mixOpp[0].toString();
        String min = mixOpp[1].toString();*/

        if(opportunityRepository.getCount() == 0){
            System.out.println("The company has no Opportunities");
        } else {

            Object minOp = opportunityRepository.findMinOpportunityByAccount();
            String nameAcc = ((Object[]) minOp)[0].toString();
            String min = ((Object[]) minOp)[1].toString();

            System.out.println("The Account with fewer Opportunities is " + nameAcc + " with a number of " + min);
        }
        System.out.println();
        Menu.enterToContinue(Colors.YELLOW_BOLD_BRIGHT + "Press ENTER to continue...");
        System.out.println();
        System.out.println(Colors.RESET + "---------------------------------------------------------------------------------");
        System.out.println();
    }
    public void meanOpportunityByAccount(){
        List<Object[]> opportunities = opportunityRepository.findOpportunitiesByAccount();
        int totalAcc = opportunities.size();
        if(totalAcc == 0){
            System.out.println("The company has no Opportunities");
        } else {
            int totalOpp = 0;
            for (Object[] opp : opportunities) {
                totalOpp += Integer.parseInt(opp[1].toString());
            }
            double mean = totalOpp / totalAcc;

            //Object avg = opportunityRepository.findMinOpportunityByAccount();
            //String mean = ((Object[])avg)[1].toString();

            System.out.println("The mean of Opportunities by Account is " + mean);
        }
        System.out.println();
        Menu.enterToContinue(Colors.YELLOW_BOLD_BRIGHT + "Press ENTER to continue...");
        System.out.println();
        System.out.println(Colors.RESET + "---------------------------------------------------------------------------------");
        System.out.println();

    }

    public void medianOpportunityByAccount(){
        List<Object[]> opportunities = opportunityRepository.findOpportunitiesByAccount();
        double median = 0;

        if(opportunities.size() == 0){
            System.out.println("The company has no Opportunities");
        } else {
            if (opportunities.size() % 2 != 0){
                Object[] medianOpp = opportunities.get(opportunities.size()/2);
                median = Double.parseDouble(medianOpp[1].toString());
            } else {
                Object[] medianOpp1 = opportunities.get(opportunities.size()/2);
                double med1 = Double.parseDouble(medianOpp1[1].toString());
                Object[] medianOpp2 = opportunities.get(opportunities.size()/2);
                double med2 = Double.parseDouble(medianOpp1[1].toString());
                median = (med1 + med2) / 2;
            }

        }

        System.out.println("The mean of Opportunities by Account is " + median);

        System.out.println();
        Menu.enterToContinue(Colors.YELLOW_BOLD_BRIGHT + "Press ENTER to continue...");
        System.out.println();
        System.out.println(Colors.RESET + "---------------------------------------------------------------------------------");
        System.out.println();
    }

}