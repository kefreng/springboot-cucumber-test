package cl.dalt;

import io.cucumber.spring.CucumberContextConfiguration;

import javax.annotation.PostConstruct;

import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CucumberSpringConfiguration {
	
	@PostConstruct
	public void showMessage() {
		System.out.println(">>>>> INICIE EL ARCHIVO DE CONFIGURACION!");
	}
	
}
