package com.example.circuitbreakerexample.breaker;

import com.example.circuitbreakerexample.resource.ResponseGenerator;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;

import static com.example.circuitbreakerexample.breaker.BreakerStatus.*;

@Slf4j
@Getter
@Service
@RequiredArgsConstructor
public class CircuitBreakerService {

    private final ResponseGenerator responseGenerator;

    private BreakerStatus status = OPEN;
    private Integer errorThreshold = 2;
    private Integer attempts = 0;

    @Scheduled(cron = "*/5 * * * * *")
    public void halfOpenBreaker() {
        if (breakerTripped()) {
            status = HALF_OPEN;
            logStatus();
        }
    }

    private boolean breakerTripped() {
        return status.equals(CLOSED);
    }

    private void tripBreakerIfOverThreshold() {
        if (attempts >= errorThreshold) {
            status = CLOSED;
            logStatus();
        }
    }

    private void openBreaker() {
        status = OPEN;
        logStatus();
    }

    public String makeRequestToProtectedResource() {
        if (!breakerTripped()) {
            if (responseGenerator.getResponse()) {
                attempts = 0;
                if (breakerHalfOpen()){
                    openBreaker();
                }
                return "Cheese!";
            } else {
                attempts++;
                tripBreakerIfOverThreshold();
                return "PETRILL!!";
            }
        }
        return "Breaker has been tripped, please wait...";
    }

    private boolean breakerHalfOpen() {
        return status.equals(HALF_OPEN);
    }

    private void logStatus() {
        log.info("breaker set to {}", status);
    }

}
