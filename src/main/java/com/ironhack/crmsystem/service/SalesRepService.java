package com.ironhack.crmsystem.service;

import com.ironhack.crmsystem.components.Colors;
import com.ironhack.crmsystem.components.Menu;
import com.ironhack.crmsystem.components.Utilities;
import com.ironhack.crmsystem.model.SalesRep;
import com.ironhack.crmsystem.repository.ContactRepository;
import com.ironhack.crmsystem.repository.SalesRepRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class SalesRepService {

    private Menu menu;

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

            menu.displayPrincipalMenu(scanner);
        }

        public void showSalesRep(Scanner scanner){

        }


}
