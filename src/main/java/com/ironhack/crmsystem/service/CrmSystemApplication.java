package com.ironhack.crmsystem.service;

import com.ironhack.crmsystem.controller.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class CrmSystemApplication implements CommandLineRunner {

	@Autowired
	private Menu menu;

	public static void main(String[] args) {
		SpringApplication.run(CrmSystemApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		//Menu.welcome();
		//menu.displayPrincipalMenu(scanner);
	}
}
