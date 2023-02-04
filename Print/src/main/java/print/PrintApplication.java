package print;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportRuntimeHints;

@SpringBootApplication
@ImportRuntimeHints(PetClinicRuntimeHints.class)
public class PrintApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrintApplication.class, args);
		System.out.println();
		System.out.println("Hello. You're in PetClinic!");
		System.out.println();
	}

}
