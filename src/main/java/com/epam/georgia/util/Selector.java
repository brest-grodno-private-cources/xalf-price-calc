package com.epam.georgia.util;

import java.util.Map;

public class Selector {

    public Double getValueFromInterval(Double value, Map<Integer, Double> values) {
        Double result = 0d;
        for (Integer key : values.keySet()) {
            result = values.get(key);
            if (key > value) {
                break;
            }
        }
        return result;
    }
}
