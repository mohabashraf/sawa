package startup.sawa.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import startup.sawa.json.JokeResponse;

@Service
public class GreetingService {

    private RestTemplate restTemplate;
    private static  final String baseURL =
            "http://api.icndb.com/jokes/random?";

    @Autowired
    public GreetingService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public String getJoke(String firstName, String lastName)
    {
        String Url =
                String.format("%s&firstName=%s%lastName=%s",  baseURL, firstName, lastName);
        JokeResponse jokeResponse =
                restTemplate.getForObject(Url, JokeResponse.class);
        return jokeResponse.getValue().getJoke() !=
                null ?
                jokeResponse.getValue().getJoke() : "The value is null ";
    }

}
