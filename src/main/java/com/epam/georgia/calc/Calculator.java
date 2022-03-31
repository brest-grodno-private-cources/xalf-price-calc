package com.epam.georgia.calc;

import java.math.BigDecimal;

public interface Calculator {

    BigDecimal handle(Double pricePerKg, Double pricePerKm, Double length, Double weight);

}
