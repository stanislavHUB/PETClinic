package webUi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportRuntimeHints;

@SpringBootApplication
@ImportRuntimeHints(PetClinicRuntimeHints.class)
public class WebUiApplication {
	public static void main(String[] args) {
		SpringApplication.run(WebUiApplication.class, args);
	}
}
