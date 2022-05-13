package com.ironhack.crmsystem;

import com.ironhack.crmsystem.components.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;

import java.util.Arrays;
import java.util.Scanner;

@SpringBootApplication
public class CrmSystemApplication implements CommandLineRunner {

	@Autowired
	private Menu menu;

	@Autowired
	private Environment environment;

	public static void main(String[] args) {
		SpringApplication.run(CrmSystemApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		if(!Arrays.asList(environment.getActiveProfiles()).contains("test")){
			Scanner scanner = new Scanner(System.in);
			Menu.welcome();
			menu.displayPrincipalMenu(scanner);
		}

	}
}