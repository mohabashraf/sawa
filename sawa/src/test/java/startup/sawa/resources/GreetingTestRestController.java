package startup.sawa.resources;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import startup.sawa.domains.User;


import static org.junit.Assert.assertEquals;
@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GreetingTestRestController {

    @Autowired
    TestRestTemplate testRestTemplate;

    @Test
    public void greetingWithoutName(){
        ResponseEntity<User> entity = testRestTemplate.getForEntity("/rest", User.class);
        assertEquals(HttpStatus.OK, entity.getStatusCode());
        User response = entity.getBody();
        assertEquals("Mohab", response.getName());
    }

    @Test
    public void greetingWithName(){
        User response = testRestTemplate.getForObject("/rest?name=Ahmed", User.class);
        assertEquals("Ahmed", response.getName());
    }
}
