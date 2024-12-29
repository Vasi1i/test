package com.example.creditsimulator.service;

import com.example.creditsimulator.controller.dto.response.CreditResponse;

import java.math.BigDecimal;
import java.util.List;

public interface Creditable {
    List<CreditResponse> simulateCredit(BigDecimal creditAmount, BigDecimal annualPercentageRate, int months);
}