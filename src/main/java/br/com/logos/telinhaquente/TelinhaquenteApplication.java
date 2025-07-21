package br.com.logos.telinhaquente;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class TelinhaquenteApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(TelinhaquenteApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Telinhaquente Application has started successfully!");
	}

}
