package cl.dalt.bolsabasica;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BolsaBasicaCucumberStepsDefinitions {
	
	Logger logger = LoggerFactory.getLogger(BolsaBasicaCucumberStepsDefinitions.class);

	 
	@Given("^la bolsa no esta vacia$")
    public void the_bag_is_not_empty() {
        logger.info("La bolsa no esta vacia...");
    }
 
	
    @When("^vacio la bolsa$")
    public void empty_the_bag() {
        logger.info("Vacio la bolsa");
    }
    
    
    @Then("^la bolsa esta vacia$")
    public void the_bag_is_empty() {
    	logger.info("La bolsa esta vacia");
    }
	
}
