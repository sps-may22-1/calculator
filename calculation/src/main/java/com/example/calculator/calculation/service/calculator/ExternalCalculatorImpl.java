package com.example.calculator.calculation.service.calculator;

import com.example.calculator.calculation.service.operation.client.OperationApiFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Primary
@Component
public class ExternalCalculatorImpl implements Calculator {

    private final OperationApiFacade operationApiFacade;

    @Override
    public double add(double x, double y) {
        return operationApiFacade.add(x, y);
    }

    @Override
    public double subtract(double x, double y) {
        return operationApiFacade.subtract(x, y);
    }

    @Override
    public double multiply(double x, double y) {
        return operationApiFacade.multiply(x, y);
    }

    @Override
    public double divide(double x, double y) {
        return operationApiFacade.divide(x, y);
    }
}
