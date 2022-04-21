package com.epam.georgia.model;

import com.epam.georgia.calc.Calculator;
import com.epam.georgia.calc.CalculatorImpl;
import com.epam.georgia.util.Selector;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class CalcState implements Status {

    Map<Integer, Double> massPrices;
    Map<Integer, Double> distancePrices;
    Selector selector = new Selector();

    List<Double> values;
    Calculator calculator = new CalculatorImpl();
    public CalcState(Map<Integer, Double> massPrices, Map<Integer, Double> distancePrices, List<Double> values) {
        this.massPrices = massPrices;
        this.distancePrices = distancePrices;
        this.values = values;
    }

    @Override
    public Status handle() {
        Double pricePerKg = selector.getValueFromInterval(values.get(0), massPrices);
        Double pricePerKm = selector.getValueFromInterval(values.get(1), distancePrices);
        BigDecimal result = calculator.handle(pricePerKg, pricePerKm, values.get(1), values.get(0));
        System.out.println("Result = " + result);
        return new ReadDataState(massPrices, distancePrices);
    }

    @Override
    public StatusType getType() {
        return StatusType.CALC;
    }
}
