package cl.dalt;

import static io.cucumber.spring.CucumberTestContext.SCOPE_CUCUMBER_GLUE;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
@Scope(SCOPE_CUCUMBER_GLUE)
public class HttpClient {
	
	Logger log = LoggerFactory.getLogger(HttpClient.class);

    private final String SERVER_URL = "http://localhost";
    private final String HELLO_ENDPOINT = "/hello";
    private final String SEARCH_PERSON = "/person";
    private final String SEARCH_ASSIGNMENT = "/assignment";
    private final String SETTING_PRIZE = "/prize";

    @LocalServerPort
    private int port;
    private final RestTemplate restTemplate = new RestTemplate();


    private String thingsEndpoint() {
        return SERVER_URL + ":" + port;
    }
    
    public String getHello() {
    	return restTemplate.getForEntity(thingsEndpoint() + HELLO_ENDPOINT, String.class).getBody();
    }
    
    public String searchPerson(int ppn) {
    	log.info("enpoint en metodo searchPerson : " + thingsEndpoint() + SEARCH_PERSON + "/" + ppn );
    	return restTemplate.getForEntity(thingsEndpoint() + SEARCH_PERSON + "/" + ppn, String.class).getBody();
    }
    
    public Boolean searchTotalAssignmentByPerson(int ppn, int totalAssignment) { 
    	return restTemplate.getForEntity(thingsEndpoint() + SEARCH_PERSON + "/" + ppn + SEARCH_ASSIGNMENT + "/"+ totalAssignment, Boolean.class).getBody();
    }
    
    public int settingPrizeToPerson(int ppn, int prize) { 
    	return restTemplate.getForEntity(thingsEndpoint() + SEARCH_PERSON + "/" + ppn + SETTING_PRIZE + "/"+ prize, Boolean.class).getStatusCodeValue();
    }


}
 
