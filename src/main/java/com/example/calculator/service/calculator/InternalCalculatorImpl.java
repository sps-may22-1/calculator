package com.example.calculator.service.calculator;

import org.springframework.stereotype.Component;

@Component
public class InternalCalculatorImpl implements Calculator {

    @Override
    public double add(double x, double y) {
        return x + y;
    }

    @Override
    public double subtract(double x, double y) {
        return x - y;
    }

    @Override
    public double multiply(double x, double y) {
        return x * y;
    }

    @Override
    public double divide(double x, double y) {
        return x / y;
    }
}
