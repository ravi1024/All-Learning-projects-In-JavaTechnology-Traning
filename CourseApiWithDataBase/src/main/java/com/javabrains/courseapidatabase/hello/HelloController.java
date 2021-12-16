package com.javabrains.courseapidatabase.hello;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloController {

    @RequestMapping("/hello")
    public String helloMethod() {
        return "Hello World! Ravi";
    }
}
