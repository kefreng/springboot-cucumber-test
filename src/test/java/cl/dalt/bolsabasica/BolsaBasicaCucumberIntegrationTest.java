package cl.dalt.bolsabasica;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/bolsabasica",
	plugin = {"pretty", "html:target/cucumber/bolsabasica"},
	glue = "cl.dalt")
public class BolsaBasicaCucumberIntegrationTest {

}
