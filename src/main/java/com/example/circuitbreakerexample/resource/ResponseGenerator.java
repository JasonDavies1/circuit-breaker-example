package com.example.circuitbreakerexample.resource;

import org.springframework.stereotype.Component;

@Component
public class ResponseGenerator {

    public boolean getResponse() {
        return 5 > (Math.random() * 10);
    }
}
