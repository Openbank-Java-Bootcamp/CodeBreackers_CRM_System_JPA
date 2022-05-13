package com.ironhack.crmsystem.service;

import com.ironhack.crmsystem.components.Colors;
import com.ironhack.crmsystem.components.Menu;
import com.ironhack.crmsystem.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.rmi.NoSuchObjectException;
import java.util.List;
import java.util.Scanner;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

    public void maxEmployeeCont(){
        //Header of the method
        System.out.println();
        System.out.println(Colors.GREEN_BOLD_BRIGHT + "You have selected the \"Max Employee Count\" option");
        System.out.println(Colors.RESET);

        if(accountRepository.sizeOfAccountsDatabase() == 0){
            System.out.println("No accounts in the database");
        }
        List<Object[]> objectList = accountRepository.findMaxEmployeeCount();
        System.out.println("Max Employee Count and the accounts with the max count are:");
        for (Object[] obj : objectList) {
            System.out.println("Account: " +obj[0].toString() +".    Employee Count: "+ obj[1].toString());
        }

        System.out.println();
        //Menu.enterToContinue(Colors.YELLOW_BOLD_BRIGHT + "Press ENTER to continue...");
        System.out.println();
        System.out.println(Colors.RESET + "---------------------------------------------------------------------------------");
        System.out.println();
    }
    public void minEmployeeCont(){
        //Header of the method
        System.out.println();
        System.out.println(Colors.GREEN_BOLD_BRIGHT + "You have selected the \"Min Employee Count\" option");
        System.out.println(Colors.RESET);

        if(accountRepository.sizeOfAccountsDatabase() == 0){
            System.out.println("No accounts in the database");
        }
        List<Object[]> objectList = accountRepository.findMinEmployee();
        System.out.println("Min Employee Count and the accounts with the min count are:");
        for (Object[] obj : objectList) {
            System.out.println("Account: " +obj[0].toString() +".    Employee Count: "+ obj[1].toString());
        }

        System.out.println();
        Menu.enterToContinue(Colors.YELLOW_BOLD_BRIGHT + "Press ENTER to continue...");
        System.out.println();
        System.out.println(Colors.RESET + "---------------------------------------------------------------------------------");
        System.out.println();
    }

    public void meanEmployeeCont(){
        //Header of the method
        System.out.println();
        System.out.println(Colors.GREEN_BOLD_BRIGHT + "You have selected the \"Mean Employee Count\" option");
        System.out.println(Colors.RESET);

        if(accountRepository.sizeOfAccountsDatabase() == 0){
            System.out.println("No accounts in the database");
        }
        int mean = accountRepository.findMeanEmployee();
        System.out.println("Mean Employee Count is:  "+mean);

        System.out.println();
        Menu.enterToContinue(Colors.YELLOW_BOLD_BRIGHT + "Press ENTER to continue...");
        System.out.println();
        System.out.println(Colors.RESET + "---------------------------------------------------------------------------------");
        System.out.println();
    }
    public void medianEmployeeCont(){

        //Header of the method
        System.out.println();
        System.out.println(Colors.GREEN_BOLD_BRIGHT + "You have selected the \"Median Employee Count\" option");
        System.out.println(Colors.RESET);

        if(accountRepository.sizeOfAccountsDatabase() == 0){
            System.out.println("No accounts in the database");
        }
        int size = accountRepository.sizeOfAccountsDatabase();
        if(size% 2 != 0){  //odd
            int row = (int) Math.floor(size/2); //no le sumo uno porque el offset del primer row es 0, no 1;
            int oddMedian=accountRepository.medianOfOddDB(row);
            System.out.println("Median Employee Count is:  "+oddMedian);
        }else{  //even
            int row = (size/2)-1;
            double evenMedian=accountRepository.medianOfEvenDB(row);
            System.out.println("Median Employee Count is:  "+evenMedian);
        }


        System.out.println();
        Menu.enterToContinue(Colors.YELLOW_BOLD_BRIGHT + "Press ENTER to continue...");
        System.out.println();
        System.out.println(Colors.RESET + "---------------------------------------------------------------------------------");
        System.out.println();

    }

}
