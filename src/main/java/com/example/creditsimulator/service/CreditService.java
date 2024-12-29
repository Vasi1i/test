package com.example.creditsimulator.service;

import com.example.creditsimulator.controller.dto.request.CreditRequest;
import com.example.creditsimulator.controller.dto.response.CreditResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class CreditService {
    private final Map<String, Creditable> credits;
    public List<CreditResponse> calculateCredit(CreditRequest request) {
        Creditable credit = credits.get(request.getCreditType());
        return credit.simulateCredit(request.getCreditAmount(), request.getAnnualPercentageRate(), request.getMonths());
    }
}