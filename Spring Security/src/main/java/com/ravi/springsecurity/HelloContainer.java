package com.ravi.springsecurity;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloContainer {

    @RequestMapping("/")
    public String sayHello() {
        return ("<h1>Welcome!!<h1>");
    }

    @RequestMapping("/admin")
    public String sayHelloToAdmin() {
        return ("<h1>Welcome Admin!!<h1>");
    }

    @RequestMapping("/user")
    public String sayHelloToUser() {
        return ("<h1>Welcome User!!<h1>");
    }
}
