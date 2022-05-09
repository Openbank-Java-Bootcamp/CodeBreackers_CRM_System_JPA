package com.ironhack.crmsystem.service;

import com.ironhack.crmsystem.components.Colors;
import com.ironhack.crmsystem.components.Menu;
import com.ironhack.crmsystem.components.Utilities;
import com.ironhack.crmsystem.model.SalesRep;
import com.ironhack.crmsystem.repository.ContactRepository;
import com.ironhack.crmsystem.repository.SalesRepRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@Service
public class SalesRepService {
    Menu menu = new Menu();
    private Utilities utilities = new Utilities();

    @Autowired
    private SalesRepRepository salesRepRepository;

    public void createSalesRep(Scanner scanner){

            //Header of the method
            System.out.println();
            System.out.println(Colors.GREEN_BOLD_BRIGHT + "You have selected the \"Create a SalesRep\" option");
            System.out.println(Colors.YELLOW_BOLD_BRIGHT + "You must enter the data that will be requested below");
            System.out.println(Colors.RESET);

            SalesRep salesRep = new SalesRep(Utilities.nameLead(scanner));

            salesRepRepository.save(salesRep);

            //Foot of the method
            System.out.println();
            System.out.println(Colors.YELLOW_BOLD_BRIGHT + "You have inserted a SalesRep");
            Menu.enterToContinue(Colors.YELLOW_BOLD_BRIGHT + "Press ENTER to continue...");
            System.out.println();
            System.out.println(Colors.RESET + "---------------------------------------------------------------------------------");
            System.out.println();

        }

        public void showSalesRep(Scanner scanner){
            //Header of the method
            System.out.println();
            System.out.println(Colors.GREEN_BOLD_BRIGHT + "You have selected the \"Show salesReps\" option");
            System.out.println(Colors.RESET);

            SalesRepList(scanner);

            System.out.println();
            Menu.enterToContinue(Colors.YELLOW_BOLD_BRIGHT + "Press ENTER to continue...");
            System.out.println();
            System.out.println(Colors.RESET + "---------------------------------------------------------------------------------");
            System.out.println();
        }

        public void SalesRepList(Scanner scanner){
            List<SalesRep> salesReps = salesRepRepository.findAll();
            utilities.printSalesRep(salesReps);
        }


}
