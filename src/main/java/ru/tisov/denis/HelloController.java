package ru.tisov.denis;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;

@RestController
public class HelloController {

    private RestTemplate restTemplate = new RestTemplate();


    @RequestMapping("/hello")
    public String hello() {
        return "Hello";
    }

    @RequestMapping({"/", "/stats"})
    public String stats() {
        RuntimeMXBean runtimeMxBean = ManagementFactory.getRuntimeMXBean();
        return "Input args: " + runtimeMxBean.getInputArguments().toString() +
                "\nJAVA_OPTS: " + System.getenv("JAVA_OPTS") +
                "\n" + System.currentTimeMillis();
    }

    @RequestMapping("/HelloWorld")
    public String helloWorld() {
        return "Hello " + restTemplate.getForEntity("http://WorldContainer:8080/world", String.class).getBody();
    }

}