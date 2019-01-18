package com.example.circuitbreakerexample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class ApplicationController {

    @ModelAttribute("message")
    public String message() {
        return "hey";
    }

    @ModelAttribute("disclaimer")
    public String disclaimer() {
        return "this is good UI";
    }

    @GetMapping("/")
    public String get() {
        return "index";
    }
}
