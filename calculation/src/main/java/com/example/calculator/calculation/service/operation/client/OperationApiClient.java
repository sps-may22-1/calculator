package com.example.calculator.calculation.service.operation.client;

import org.springframework.web.bind.annotation.PostMapping;

interface OperationApiClient {

    @PostMapping(path = "/operations")
    CalculateOperationResponse calculate(CalculateOperationRequest request);
}
