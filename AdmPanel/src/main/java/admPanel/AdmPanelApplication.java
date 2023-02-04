package admPanel;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.Scanner;

@SpringBootApplication
public class AdmPanelApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(AdmPanelApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception{
		Console.consoleForAdmPanel();
	}
}
