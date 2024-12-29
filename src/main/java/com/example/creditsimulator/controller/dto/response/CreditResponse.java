package com.example.creditsimulator.controller.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Builder
public class CreditResponse {
    private LocalDate date;
    private BigDecimal remainingBalance;
    private BigDecimal percentage;
    private BigDecimal amortization;
    private BigDecimal monthlyPayment;
}