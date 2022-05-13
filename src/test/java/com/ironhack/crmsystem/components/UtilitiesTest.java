package com.ironhack.crmsystem.components;

import com.ironhack.crmsystem.enums.Industry;
import com.ironhack.crmsystem.enums.Product;
import nl.altindag.console.ConsoleCaptor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.StringReader;
import java.util.List;
import java.util.Scanner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UtilitiesTest {

    Utilities u = new Utilities();


    @Test
    public void IndustrySelection_PRODUCE_works(){
        Industry i = Industry.PRODUCE;
        StringReader sr = new StringReader("PRODUCE");
        Scanner scan = new Scanner(sr);
        ConsoleCaptor consoleCaptor = new ConsoleCaptor();
        assertEquals(i, u.industrySelection(scan));;
        List<String> s = consoleCaptor.getStandardOutput();
        consoleCaptor.close();
        assertThat(s.contains("PRODUCE selected!"));
    }

    @Test
    public void IndustrySelection_ECOMMERCE_works(){
        Industry i = Industry.ECOMMERCE;
        StringReader sr = new StringReader("ECOMMERCE");
        Scanner scan = new Scanner(sr);
        ConsoleCaptor consoleCaptor = new ConsoleCaptor();
        assertEquals(i, u.industrySelection(scan));;
        List<String> s = consoleCaptor.getStandardOutput();
        consoleCaptor.close();
        assertThat(s.contains("ECOMMERCE selected!"));
    }

    @Test
    public void IndustrySelection_MANUFACTURING_works(){
        Industry i = Industry.MANUFACTURING;
        StringReader sr = new StringReader("MANUFACTURING");
        Scanner scan = new Scanner(sr);
        ConsoleCaptor consoleCaptor = new ConsoleCaptor();
        assertEquals(i, u.industrySelection(scan));;
        List<String> s = consoleCaptor.getStandardOutput();
        consoleCaptor.close();
        assertThat(s.contains("MANUFACTURING selected!"));
    }

    @Test
    public void IndustrySelection_MEDICAL_works(){
        Industry i = Industry.MEDICAL;
        StringReader sr = new StringReader("MEDICAL");
        Scanner scan = new Scanner(sr);
        ConsoleCaptor consoleCaptor = new ConsoleCaptor();
        assertEquals(i, u.industrySelection(scan));;
        List<String> s = consoleCaptor.getStandardOutput();
        consoleCaptor.close();
        assertThat(s.contains("MEDICAL selected!"));
    }

    @Test
    public void IndustrySelection_OTHER_works(){
        Industry i = Industry.OTHER;
        StringReader sr = new StringReader("OTHER");
        Scanner scan = new Scanner(sr);
        ConsoleCaptor consoleCaptor = new ConsoleCaptor();
        assertEquals(i, u.industrySelection(scan));;
        List<String> s = consoleCaptor.getStandardOutput();
        consoleCaptor.close();
        assertThat(s.contains("OTHER selected!"));
    }

    @Test
    public void printEnum_Insdustry_Works(){
        ConsoleCaptor consoleCaptor = new ConsoleCaptor();
        u.printEnum("Industry");
        List<String> s = consoleCaptor.getStandardOutput();
        assertThat(s.contains("- PRODUCE\n- ECOMMERCE\n- MANUFACTURING\n- MEDICAL\n- OTHER\n"));
        consoleCaptor.close();
    }

    @Test
    public void printEnun_Product_Works(){
        ConsoleCaptor consoleCaptor = new ConsoleCaptor();
        u.printEnum("Product");
        List<String> s = consoleCaptor.getStandardOutput();
        assertThat(s.contains("- HYBRID\n- HYBRID\n- HYBRID\n"));
        consoleCaptor.close();
    }

    @Test
    public void printEnun_Status_Works(){
        ConsoleCaptor consoleCaptor = new ConsoleCaptor();
        u.printEnum("Status");
        List<String> s = consoleCaptor.getStandardOutput();
        assertThat(s.contains("- OPEN\n- CLOSED_LOST\n- CLOSED_WIN\n"));
        consoleCaptor.close();
    }


    @Test
    public void ProductSelection_HYBRID_works(){
        Product i = Product.HYBRID;
        StringReader sr = new StringReader("HYBRID");
        Scanner scan = new Scanner(sr);
        ConsoleCaptor consoleCaptor = new ConsoleCaptor();
        assertEquals(i, u.productSelection(scan));;
        List<String> s = consoleCaptor.getStandardOutput();
        consoleCaptor.close();
        assertThat(s.contains("HYBRID selected!"));
    }

    @Test
    public void ProductSelection_FLATBED_works(){
        Product i = Product.FLATBED;
        StringReader sr = new StringReader("FLATBED");
        Scanner scan = new Scanner(sr);
        ConsoleCaptor consoleCaptor = new ConsoleCaptor();
        assertEquals(i, u.productSelection(scan));;
        List<String> s = consoleCaptor.getStandardOutput();
        consoleCaptor.close();
        assertThat(s.contains("FLATBED selected!"));
    }

    @Test
    public void ProductSelection_BOX_works(){
        Product i = Product.BOX;
        StringReader sr = new StringReader("BOX");
        Scanner scan = new Scanner(sr);
        ConsoleCaptor consoleCaptor = new ConsoleCaptor();
        assertEquals(i, u.productSelection(scan));;
        List<String> s = consoleCaptor.getStandardOutput();
        consoleCaptor.close();
        assertThat(s.contains("BOX selected!"));
    }

    @Test
    public void quantityNumber_err_minus1(){
        StringReader sr = new StringReader("1");
        Scanner scan = new Scanner(sr);
        ConsoleCaptor consoleCaptor = new ConsoleCaptor();
        u.quantityNumber(scan);
        List<String> s = consoleCaptor.getErrorOutput();
        consoleCaptor.close();
        assertThat(s.contains("The number must be bigger than 1"));
    }
    @Test
    public void quatityNumber_Works(){
        StringReader sr = new StringReader("20");
        Scanner scan = new Scanner(sr);
        assertEquals(20, u.quantityNumber(scan));
    }
    @Test
    public void ValidateCountry_true(){
        assertTrue(u.validateCountry("Spain"));
    }
    @Test
    public void ValidateCountry_false(){
        assertFalse(u.validateCountry("Paloma"));
    }
    @Test
    public void countryInput_Works(){
        StringReader sr = new StringReader("Spain");
        Scanner scan = new Scanner(sr);
        assertEquals("Spain", u.countryInput(scan));
    }

    @Test
    public void quantityNumber_Throw_notINT(){
        StringReader sr = new StringReader("s");
        Scanner scan = new Scanner(sr);
        ConsoleCaptor consoleCaptor = new ConsoleCaptor();
        List<String> s = consoleCaptor.getErrorOutput();
        consoleCaptor.close();
        assertThat(s.contains("That´s not a number. Please try again"));

    }

}