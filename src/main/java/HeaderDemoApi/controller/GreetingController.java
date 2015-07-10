package HeaderDemoApi.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    @RequestMapping("/greeting")
    public HttpEntity<String> getRequest(@RequestHeader(value = "My-Response-Header", defaultValue = "No header found") String token) {

        ResponseEntity<String> response = new ResponseEntity<>(token, HttpStatus.OK);

        return response;
    }

}
