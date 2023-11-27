package com.leecottrell.testwebservicelecture;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.net.MalformedURLException;
import java.net.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.leecottrell.testwebservicelecture.Sport.*;

//@SpringBootTest
class TestwebservicelectureApplicationTests {

    private static int port=8080;
    private static URL base;
    private TestRestTemplate template;

    @BeforeAll
    public static void setup() throws Exception{
        base = new URL("http://127.0.0.1:" + port + "/");
       // SpringApplication.run(SportController.class, null);
        
    }

    @ParameterizedTest
    @CsvSource({
        "Soccer, Riverhounds",
        "Hockey, Penguins",
        "Football, Steelers"
    })
    public void testTeamName(String sport, String team) throws Exception{
        template = new TestRestTemplate();
        URL teamURL = new URL(this.base.toString()+ "Sport?sportName="+sport);
        ResponseEntity<String> response = template.getForEntity(teamURL.toString(), String.class); 
        String body = response.getBody();
        ObjectMapper mapper = new ObjectMapper();
        Sport sportJson = mapper.readValue(body, Sport.class);

        String actual = sportJson.getTeamName();
        String expected = team;
        assertEquals(expected, actual);
    }

    @Test
    public void testNoParameter() throws Exception{
    template = new TestRestTemplate();
        URL teamURL = new URL(this.base.toString() + "Sport");
        ResponseEntity<String> response = template.getForEntity(teamURL.toString(), String.class); 

        String body = response.getBody();
        ObjectMapper mapper = new ObjectMapper();
        Sport sportJson = mapper.readValue(body, Sport.class);

        String expected = "no name";
        String actual = sportJson.getSportName();
     // String expected="http://127.0.0.1:8080/Sport";
      //String actual = teamURL.toString();
        assertEquals(expected, actual);
    }



	/*@Ignore
    public void check(){
        Sport actual = new Sport();//set values from the json
        Sport expected = new Sport();//set what you should get
        expected.setSportName("I fail");
        assertEquals(expected, actual);
    }
    */

}
