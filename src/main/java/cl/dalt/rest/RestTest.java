package cl.dalt.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestTest {
	
	Logger log = LoggerFactory.getLogger(RestTest.class);

	@RequestMapping("/hello")
	public String hello() {
		return "hello";
	}
	
	public static String PERSON = "{\"name\":\"felix\",\"lastName\":\"flores\",\"email\":\"felix@dalt.cl\",\"ppn\":1111}";
	public static Integer TOTAL_ASSIGNMENT = 10;
	
	
	@GetMapping("/person/{ppn}")
	public String searchPerson(@PathVariable(value = "ppn") int ppn) {
		log.info(">>>> Search person with ppn : " + ppn + "......");
		log.info("Person founded : " + PERSON);
		return PERSON;
	}
	
	@GetMapping("/person/{ppn}/assignment/{cantAsignaciones}")
	public Boolean searchPerson(@PathVariable(value = "ppn") int ppn, @PathVariable(value = "cantAsignaciones") int cantAsignaciones) {
		log.info(">>>> Search person with ppn : " + ppn + "......");
		log.info("Person founded : " + PERSON);
		log.info("getting amount of assignment.....");
		log.info("total assignment : " + TOTAL_ASSIGNMENT);
		
		return TOTAL_ASSIGNMENT.equals(cantAsignaciones);
	}
	
	@GetMapping("/person/{ppn}/prize/{premio}")
	public ResponseEntity<Boolean> registerPrize(@PathVariable(value = "ppn") int ppn, @PathVariable(value = "premio") int premio) {
		log.info(">>>> Search person with ppn : " + ppn + "......");
		log.info("Person founded : " + PERSON);
		log.info("setting prize.....");
		log.info("premio registrado para persona " + ppn + " -> : " + premio);
		
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}
	
}
