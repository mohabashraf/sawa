package startup.sawa.resources;

import org.reactivestreams.Publisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import startup.sawa.domains.User;

@RestController
public class GreetingRestController {

    @GetMapping("/rest")
    public User getUser(@RequestParam(value = "name", required = false, defaultValue = "Mohab") String name) {
        return new User("assa",name);
    }

    @GetMapping("/hello")
    Publisher<String> greetings(){
        Flux<String> greeting = Flux.<String>generate(sink -> sink.next("asa")).take(1000);
        return greeting;
    }
}
