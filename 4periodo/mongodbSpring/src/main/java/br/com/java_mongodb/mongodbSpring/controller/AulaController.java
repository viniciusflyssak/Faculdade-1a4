package br.com.java_mongodb.mongodbSpring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AulaController {
    @GetMapping("/")
    public String index(){
        return"index";
    }
}
