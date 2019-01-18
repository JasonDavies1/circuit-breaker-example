package com.example.circuitbreakerexample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @GetMapping("/test")
    public String test(final RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("buttonClicked", true);
        redirectAttributes.addFlashAttribute("buttonClickMessage", "You clicked the button, good for you I guess");
        return "redirect:/";
    }
}
