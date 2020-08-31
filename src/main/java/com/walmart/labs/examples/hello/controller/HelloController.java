package com.walmart.labs.examples.hello.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HelloController {

	    @GetMapping("/")
	    public String getGreeting() {

	        return "Hello!";
	    }

}
