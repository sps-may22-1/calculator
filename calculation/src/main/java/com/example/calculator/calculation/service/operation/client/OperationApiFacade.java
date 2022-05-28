package com.example.calculator.calculation.service.operation.client;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class OperationApiFacade {

    private final OperationAnApiClient anApiClient;

    private final OperationSnApiClient snApiClient;

    private final OperationMnApiClient mnApiClient;

    private final OperationDnApiClient dnApiClient;

    public double add(double x, double y) {
        return calculate(anApiClient, x, y);
    }

    public double subtract(double x, double y) {
        return calculate(snApiClient, x, y);
    }

    public double multiply(double x, double y) {
        return calculate(mnApiClient, x, y);
    }

    public double divide(double x, double y) {
        return calculate(dnApiClient, x, y);
    }

    private static double calculate(OperationApiClient apiClient, double x, double y) {
        return apiClient.calculate(new CalculateOperationRequest(x, y)).result();
    }
}
