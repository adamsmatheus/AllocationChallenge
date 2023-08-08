package com.challenge.Allocation.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    @Operation(summary = "isRunning", description = "To check whether service is running or not")
    @GetMapping(value = "/health")
    public ResponseEntity<String> health() {
        return new ResponseEntity<>("Service is running.", HttpStatus.OK);
    }
}
