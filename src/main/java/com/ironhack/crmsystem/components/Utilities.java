package com.ironhack.crmsystem.components;
import com.ironhack.crmsystem.enums.Industry;
import com.ironhack.crmsystem.enums.Product;
import com.ironhack.crmsystem.enums.Status;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Utilities {

    public static String nameLead(Scanner scanner) {

        System.out.println("Please insert the name");
        String name = scanner.nextLine();
        boolean isNumber = false;
        while (!isNumber) { //valida que no hayan numeros
            if(!name.matches(".*[0-9].*") && name!=""){
                isNumber = true;
            }
            else{
                System.err.println("Please select a valid name");
                name=scanner.nextLine();
            }
        }
        return name;
    }
    public static String phoneNumberLead(Scanner scanner){
        System.out.println("Please insert the phone number of the new lead");
        String phoneNumber = scanner.nextLine();
        boolean isWord = false;
        while (!isWord) { //valida que solo hayan numeros y el tamaño 9
            if(phoneNumber.matches(".*[0-9].*") && phoneNumber.length()==9){
                isWord = true;
            }
            else{
                System.err.println("Please select a valid phone number");
                phoneNumber=scanner.nextLine();
            }
        }
        return phoneNumber;
    }
    public static String emailLead(Scanner scanner){
        System.out.println("Please insert the email address of the new lead");
        String emailAddress = scanner.nextLine();
        boolean isEmail=false;
        while(!isEmail){
            Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
            Matcher mather = pattern.matcher(emailAddress);
            if (mather.find()) {
                isEmail=true;
            }
            else{
                System.err.println("Please select a valid email");
                emailAddress = scanner.nextLine();
            }
        }
        return emailAddress;
    }
    public static String companyNameLead(Scanner scanner){
        System.out.println("Please insert the company the new lead works for");
        String companyName = scanner.nextLine(); //pueden haber letras y numeros*/
        return companyName;
    }
    public Industry industrySelection(Scanner scanner){
        Industry i;
        String industry = scanner.nextLine().toUpperCase();
        switch (industry){
            case "PRODUCE":
                i = Industry.PRODUCE;
                System.out.println(i + " Selected!");
                break;
            case "ECOMMERCE":
                i = Industry.ECOMMERCE;
                System.out.println(i + " Selected!");
                break;
            case "MANUFACTURING":
                i = Industry.MANUFACTURING;
                System.out.println(i + " Selected!");
                break;
            case "MEDICAL":
                i = Industry.MEDICAL;
                System.out.println(i + " Selected!");
                break;
            case "OTHER":
                i = Industry.OTHER;
                System.out.println(i + " Selected!");
                break;
            default:
                System.err.println("Invalid input. Please try again");
                i = industrySelection(scanner);
        }
        return i;
    }
    public Product productSelection(Scanner scanner){
        Product p;
        String product = scanner.nextLine().toUpperCase();
        switch (product){
            case "HYBRID":
                p = Product.HYBRID;
                System.out.println(p+ " Selected!");
                break;
            case "FLATBED":
                p = Product.FLATBED;
                System.out.println(p+ " Selected!");
                break;
            case "BOX":
                p = Product.BOX;
                System.out.println(p+ " Selected!");
                break;
            default:
                System.err.println("Invalid input. Please try again");
                p = productSelection(scanner);
        }
        return p;
    }
    public static int quantityNumber(Scanner scanner){
        int quantity = 0;
        try {
            String quantityString = scanner.nextLine();
            quantity = Integer.parseInt(quantityString);
            if (quantity < 1) {
                System.err.println("The number must be at least 1");
                //quantity = 1;
                quantity = quantityNumber(scanner);
            }
        }catch(Exception e){
            System.err.println("That´s not a number. Please try again");
            quantity = quantityNumber(scanner);
        }
        return quantity;
    }

    public static void printEnum(String s){
        System.out.println("This are the possible "+ s.toUpperCase() + " types: ");
        if (s.equalsIgnoreCase("Industry")) {
            Industry industries[] = Industry.values();
            for (Industry i : industries) {
                System.out.println("- " + i);
            }
        } else if (s.equalsIgnoreCase("Product")){
            Product products[] = Product.values();
            for (Product p : products) {
                System.out.println("- " + p);
            }
        } else if (s.equalsIgnoreCase("Status")){
            Status statuses[] = Status.values();
            for (Status st : statuses) {
                System.out.println("- " + st);
            }
        }
        System.out.println("Choose one by typing its name");
    }
    public static boolean validateCountry(String s) {

        String[] locales = Locale.getISOCountries();

        for (String countryCode : locales) {

            Locale obj = new Locale("", countryCode);

            if (s.equalsIgnoreCase(obj.getDisplayCountry(java.util.Locale.ENGLISH))) {
                return true;
            }
        }
        return false;
    }

    public static String countryInput(Scanner scanner){
        System.out.println("Please insert the country of the company");
        String city = scanner.nextLine();
        while (!validateCountry(city)){
            System.err.println("Thats not a valid country. Please try again");
            city = scanner.next();
        }
        return city;
    }


    //============= Metodos que hay que rehacer utilizando Repository ================

    /*//Method that verifies that the id is lead and a String
    public static int IdNumber(Scanner scanner){
        System.out.println("Please enter de " +  Colors.YELLOW_BOLD_BRIGHT + " [ID] " + Colors.RESET+ "of the lead you would like to upgrade: ");
        int id = 0;
        try {
            //id = scanner.nextInt();
            String idString = scanner.nextLine();
            id = Integer.parseInt(idString);
            boolean valid = leadMap.containsKey(id);
            if (!valid) {
                System.err.println("Lead ID not valid. Try again.");
                id = IdNumber(scanner);
            }
        }catch(Exception e){
            System.err.println("That´s not a number. Please try again");
            id = IdNumber(scanner);
        }
        return id;
    }

    public static Opportunity OpportunityFromLead(Product product, int quantity, Contact contact){
        Opportunity opportunity = new Opportunity(product, quantity, contact, Status.OPEN);
        opportunityMap.put(opportunity.getId(), opportunity);
        return opportunity;
    }

     //Find Contact
    public static Contact ContactFromLead(int id){
        Lead leadToConvert = leadMap.get(id);
        Contact contact = new Contact(leadToConvert.getName(), leadToConvert.getPhoneNumber(), leadToConvert.getEmailAddress(), leadToConvert.getCompanyName());
        contactMap.put(contact.getId(),contact);
        return contact;
    }

     public static void showOpportunities(){
        for (Map.Entry<Integer, Opportunity> entry : opportunityMap.entrySet()) {
            Integer key = entry.getKey();
            String name = entry.getValue().getDecisionMaker().getName();
            String status = entry.getValue().getStatus().toString();
            System.out.println(key + ". DECISION MAKER: " + name + ". STATUS: " + status);
        }
    }
*/

}
