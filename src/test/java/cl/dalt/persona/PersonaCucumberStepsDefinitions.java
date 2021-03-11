package cl.dalt.persona;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import cl.dalt.HttpClient;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PersonaCucumberStepsDefinitions {
	
	Logger logger = LoggerFactory.getLogger(PersonaCucumberStepsDefinitions.class);

	@Autowired
    private HttpClient httpClient;
	 
	@Given("^Obtener a la persona con ppn (\\d+)$")
    public void obtener_a_la_persona_con_ppn(final int ppn) {
		logger.info(">>>> PPN OBTENIDO DESDE PERSONA.FEATURE: " + ppn);
		String hello = httpClient.getHello();
		logger.info(">>>> VALOR OBENIDO DESDE ENDPOINT..." + hello);
		
		logger.info(">>>BUSCANDO PERSONA EN ENDPOINT....");
		String person = httpClient.searchPerson(ppn);
		logger.info(">>>> PERSONA ENCONTRADA EN ENPOINT /person/" + ppn + " -> " + person);
		
         
    }
	
	//When persona con ppn 1111 tenga 10 asignaciones
	@When("^persona con ppn (\\d+) tenga (\\d+) asignaciones$")
	public void persona_con_ppn_tenga_asignaciones(final int ppn, final int asignaciones) {
		logger.info("persona con ppn : " + ppn);
		logger.info("total asignaciones: " + asignaciones);
		logger.info("validando cantidad de asignaciones....");
		Boolean totalAssignmentValid = httpClient.searchTotalAssignmentByPerson(ppn, asignaciones);
		assertTrue(totalAssignmentValid ? "Cantidad de asignaciones validas" : "Cantidad de asignaciones invalidas ",totalAssignmentValid);
	}
	
	//Permiar a persona de ppn 111 con 1000 dolares
	@Then("^Permiar a persona de ppn (\\d+) con (\\d+) dolares$")
	public void premiar_persona_con_dolares(final int ppn, final int dolares) {
		logger.info("persona con ppn : " + ppn);
		logger.info("premio: " + dolares);
		logger.info("registrando premio.....");
		int codeResult = httpClient.settingPrizeToPerson(ppn, dolares);
		assertEquals(codeResult == HttpStatus.OK.value() ? "Premio registrado" : "No se pudo registrar premio ", HttpStatus.OK.value() ,codeResult);
	}
	 
	
}
