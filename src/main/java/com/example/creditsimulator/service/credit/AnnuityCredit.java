package com.example.creditsimulator.service.credit;

import com.example.creditsimulator.controller.dto.response.CreditResponse;
import com.example.creditsimulator.service.Creditable;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class AnnuityCredit implements Creditable {
    @Override
    public List<CreditResponse> simulateCredit(BigDecimal creditAmount, BigDecimal annualPercentageRate, int months) {
        BigDecimal monthlyRate = annualPercentageRate.divide(BigDecimal.valueOf(12 * 100), 10, RoundingMode.HALF_UP);
        BigDecimal onePlusRatePowerMonths = BigDecimal.ONE.add(monthlyRate).pow(months);
        BigDecimal monthlyPayment = creditAmount.multiply(monthlyRate).multiply(onePlusRatePowerMonths)
                .divide(onePlusRatePowerMonths.subtract(BigDecimal.ONE), 2, RoundingMode.HALF_UP);
        BigDecimal remainingDebt = creditAmount;
        LocalDate date = LocalDate.now();
        List<CreditResponse> creditResponses = new ArrayList<>();
        for (int i = 0; i < months; i++) {
            BigDecimal interest = remainingDebt.multiply(monthlyRate).setScale(2, RoundingMode.HALF_UP);
            BigDecimal amortization = monthlyPayment.subtract(interest).setScale(2, RoundingMode.HALF_UP);
            CreditResponse creditResponse = CreditResponse.builder()
                    .date(date)
                    .remainingBalance(remainingDebt.setScale(2, RoundingMode.HALF_UP))
                    .percentage(interest.setScale(2, RoundingMode.HALF_UP))
                    .amortization(amortization.setScale(2, RoundingMode.HALF_UP))
                    .monthlyPayment(monthlyPayment.setScale(2, RoundingMode.HALF_UP))
                    .build();
            creditResponses.add(creditResponse);
            remainingDebt = remainingDebt.subtract(amortization).setScale(2, RoundingMode.HALF_UP);
            date = date.plusMonths(1);
        }
        return creditResponses;
    }
}