package com.example.calculator.calculation.service.calculator;

import com.example.calculator.calculation.service.operation.OperationAnService;
import com.example.calculator.calculation.service.operation.OperationDnService;
import com.example.calculator.calculation.service.operation.OperationMnService;
import com.example.calculator.calculation.service.operation.OperationSnService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Primary
@Component
public class ExternalCalculatorImpl implements Calculator {

    private final OperationAnService operationAnService;

    private final OperationSnService operationSnService;

    private final OperationMnService operationMnService;

    private final OperationDnService operationDnService;

    @Override
    public double add(double x, double y) {
        return operationAnService.calculate(x, y);
    }

    @Override
    public double subtract(double x, double y) {
        return operationSnService.calculate(x, y);
    }

    @Override
    public double multiply(double x, double y) {
        return operationMnService.calculate(x, y);
    }

    @Override
    public double divide(double x, double y) {
        return operationDnService.calculate(x, y);
    }
}
