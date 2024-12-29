package com.example.creditsimulator.controller.dto.request;

import com.example.creditsimulator.validator.KnownCredit;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@ToString
@AllArgsConstructor
public class CreditRequest {
    @KnownCredit
    private String creditType;

    @NotNull
    @Positive
    private BigDecimal creditAmount;

    @NotNull
    @DecimalMin("0.01")
    private BigDecimal annualPercentageRate;

    @NotNull
    @Min(1)
    @Max(360)
    private int months;
}