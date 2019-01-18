package com.example.circuitbreakerexample.controller;

import com.example.circuitbreakerexample.CircuitBreakerExampleApplication;
import com.example.circuitbreakerexample.breaker.CircuitBreakerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
public class ApplicationController {

    private final CircuitBreakerService circuitBreakerService;

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
        final String result = circuitBreakerService.makeRequestToProtectedResource();
        redirectAttributes.addFlashAttribute("response", result);
        return "redirect:/";
    }
}
