package com.epam.georgia.calc;

import java.math.BigDecimal;

public class ABCCalcImpl implements Calculator {

    @Override
    public BigDecimal handle(Double pricePerKg, Double pricePerKm, Double length, Double weight) {
        return BigDecimal.valueOf((pricePerKg + pricePerKm + length + weight) / 2);
    }
}
