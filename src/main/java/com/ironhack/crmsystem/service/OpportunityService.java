package com.ironhack.crmsystem.service;

import com.ironhack.crmsystem.components.Colors;
import com.ironhack.crmsystem.components.Menu;
import com.ironhack.crmsystem.model.Opportunity;
import com.ironhack.crmsystem.repository.OpportunityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class OpportunityService {
    @Autowired
    private OpportunityRepository opportunityRepository;
    public void changeOppStatus(Scanner scanner){

    }

    public void opportunitiesBySalesRep(Scanner scanner){

    }

    public void opportunitiesByStatus(Scanner scanner){

    }

    public void opportunitiesByProduct(Scanner scanner){

    }

    public void opportunitiesByProductAndProduct(Scanner scanner){

    }


    public void opportunitiesByCountry(Scanner scanner){

    }

    public void opportunitiesByCountryAndStatus(Scanner scanner){

    }
    public void opportunitiesByCity(Scanner scanner){

    }
    public void opportunitiesByCityAndStatus(Scanner scanner){

    }
    public void opportunitiesByIndustry(Scanner scanner){

    }

    public void opportunitiesByIndustryAndStatus(Scanner scanner){

    }

    public void maxQuantity(){
        double max=opportunityRepository.getMaxQuantity();
        System.out.println("Max Quantity is" + max);

        System.out.println();
        Menu.enterToContinue(Colors.YELLOW_BOLD_BRIGHT + "Press ENTER to continue...");
        System.out.println();
        System.out.println(Colors.RESET + "---------------------------------------------------------------------------------");
        System.out.println();
    }
    public void minQuantity(){
        double min=opportunityRepository.getMinQuantity();
        System.out.println("Min Quantity is" + min);

        System.out.println();
        Menu.enterToContinue(Colors.YELLOW_BOLD_BRIGHT + "Press ENTER to continue...");
        System.out.println();
        System.out.println(Colors.RESET + "---------------------------------------------------------------------------------");
        System.out.println();
    }
    public void meanQuantity(){
        double mean=opportunityRepository.getAvgQuantity();
        System.out.println("Mean Quantity is"+ mean);

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

}
