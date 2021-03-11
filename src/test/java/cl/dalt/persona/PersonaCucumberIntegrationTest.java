package cl.dalt.persona;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/persona",
	plugin = {"pretty", "html:target/cucumber/persona"},
	glue = "cl.dalt")
public class PersonaCucumberIntegrationTest {

}
