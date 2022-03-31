package com.epam.georgia.calc;

import java.math.BigDecimal;

public class CalculatorImpl implements Calculator {

    @Override
    public BigDecimal handle(Double pricePerKg, Double pricePerKm, Double weight, Double length) {
        BigDecimal step1 = BigDecimal.valueOf(pricePerKg).multiply(BigDecimal.valueOf(weight));
        BigDecimal step2 = BigDecimal.valueOf(pricePerKm).multiply(BigDecimal.valueOf(length));
        return step1.add(step2);
    }
}
