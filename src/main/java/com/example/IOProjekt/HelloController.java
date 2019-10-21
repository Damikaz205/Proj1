package com.example.IOProjekt;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController

public class HelloController {
    @RequestMapping("/hello")
String hello(){
    return "Hello   " + LocalDateTime.now();
}
}
