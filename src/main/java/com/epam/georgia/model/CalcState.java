package com.epam.georgia.model;

import com.epam.georgia.calc.Calculator;
import com.epam.georgia.calc.CalculatorImpl;

import java.math.BigDecimal;
import java.util.List;

public class CalcState implements Status {

    List<Double> values;
    Calculator calculator = new CalculatorImpl();
    public CalcState(List<Double> values) {
        this.values = values;
    }

    @Override
    public Status handle() {
        BigDecimal result = calculator.handle(values.get(0), values.get(1), values.get(2), values.get(3));
        System.out.println("Result = " + result);
        return new ReadDataState();
    }

    @Override
    public StatusType getType() {
        return StatusType.CALC;
    }
}
