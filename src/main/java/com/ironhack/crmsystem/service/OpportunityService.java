package com.ironhack.crmsystem.service;

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
    Utilities u = new Utilities();
    @Autowired
    OpportunityRepository opportunityRepository;

    public void changeOppStatus(Scanner scanner){

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


    public void maxQuantity(){}
    public void minQuantity(){}
    public void meanQuantity(){}
    public void medianQuantity(){}

}
