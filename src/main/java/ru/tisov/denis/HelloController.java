package ru.tisov.denis;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@RestController
public class HelloController {

    private RestTemplate restTemplate = new RestTemplate();


    @RequestMapping("/hello")
    public String hello() {
        return "Hello";
    }

    @RequestMapping("/HelloWorld")
    public String helloWorld() {
        return "Hello " + restTemplate.getForEntity("http://WorldContainer:8080/world", String.class).getBody();
    }

}