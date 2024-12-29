package com.example.creditsimulator.controller;


import com.example.creditsimulator.controller.dto.request.CreditRequest;
import com.example.creditsimulator.controller.dto.response.CreditResponse;
import com.example.creditsimulator.service.CreditService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/credit")
@AllArgsConstructor
public class CreditController {
    private final CreditService creditService;

    @PostMapping("/simulation")
    public ResponseEntity<List<CreditResponse>> simulate(@Valid @RequestBody CreditRequest request) {
        return ResponseEntity.ok(creditService.calculateCredit(request));
    }
}