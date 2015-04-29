package HeaderDemoApi.controller;

import HeaderDemoApi.domain.Greeting;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(
            @RequestParam(value = "name", defaultValue = "World") String name,
            HttpServletResponse response,
            @RequestHeader("Request-Header") String headerName) {

        // Sets our custom response header
        response.setHeader("Response-Header","Steve");

        return new Greeting(counter.incrementAndGet(),
                String.format(template, headerName));
    }

}
