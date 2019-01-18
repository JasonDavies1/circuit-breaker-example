package com.example.circuitbreakerexample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class ApplicationController {

    @ModelAttribute("message")
    public String message(){
        return "hey";
    }

    @GetMapping("/")
    public String get(){
        return "index";
    }
}
