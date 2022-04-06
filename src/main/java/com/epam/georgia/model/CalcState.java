package com.epam.georgia.model;

import com.epam.georgia.calc.Calculator;
import com.epam.georgia.calc.CalculatorImpl;

import java.math.BigDecimal;
import java.util.List;

public class CalcState implements Status {

    List<String> values;
    Calculator calculator = new CalculatorImpl();
    public CalcState(List<String> values) {
        this.values = values;
    }

    @Override
    public Status handle() {
        BigDecimal result = calculator.handle(Double.valueOf(values.get(0)), Double.valueOf(values.get(1)),
                Double.valueOf(values.get(2)), Double.valueOf(values.get(3)));
        System.out.println("Result = " + result);
        return new ReadDataState();
    }

    @Override
    public StatusType getType() {
        return StatusType.CALC;
    }
}
