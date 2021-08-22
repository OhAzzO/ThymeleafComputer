package com.example.ThymeleafComputer;

import com.example.ThymeleafComputer.Entity.Computer;
import com.example.ThymeleafComputer.Repository.ComputerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.UUID;

@SpringBootApplication
public class ThymeleafComputerApplication {

	@Autowired
	private ComputerRepository computerRepository;
	public static void main(String[] args) {
		SpringApplication.run(ThymeleafComputerApplication.class, args);
	}

	@Bean
	public ApplicationRunner runComputer() {

		final Computer firstComputer = new Computer(UUID.randomUUID(), "test overview 1", "test system components 1", 100);
		final Computer secondComputer = new Computer(UUID.randomUUID(), "test overview 2", "test system components 2", 200);
		final Computer thirdComputer = new Computer(UUID.randomUUID(), "test overview 3", "test system components 3", 300);

		return args -> computerRepository.saveAll(Arrays.asList(firstComputer, secondComputer, thirdComputer));
	}
}
