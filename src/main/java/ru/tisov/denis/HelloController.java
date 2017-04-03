package ru.tisov.denis;

import org.springframework.beans.factory.annotation.Value;
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

    @Value("${name}")
    private String name;

    @RequestMapping({"/", "/stats"})
    public String stats() {
        RuntimeMXBean runtimeMxBean = ManagementFactory.getRuntimeMXBean();
        return "Input args: " + runtimeMxBean.getInputArguments().toString() +
                "\nJAVA_OPTS: " + System.getenv("JAVA_OPTS") +
                // Get current size of heap in bytes
                "\nCurrent heapsize: " + Runtime.getRuntime().totalMemory() +
                // Get maximum size of heap in bytes. The heap cannot grow beyond this size.// Any attempt will result in an OutOfMemoryException.
                "\nMax heap size: " + Runtime.getRuntime().maxMemory() +

                // Get amount of free memory within the heap in bytes. This size will increase // after garbage collection and decrease as new objects are created.
                "\nFree memory: " + Runtime.getRuntime().freeMemory() +

                "\nCurrent time: " + System.currentTimeMillis() +
                "\nName: " + name;
    }

    @RequestMapping("/HelloWorld")
    public String helloWorld() {
        return "Hello " + restTemplate.getForEntity("http://WorldContainer:8080/world", String.class).getBody();
    }

}