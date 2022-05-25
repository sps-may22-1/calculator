package com.example.calculator.operation.web;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.function.DoubleBinaryOperator;

@RequiredArgsConstructor
@RestController
public class OperationApi {

    private final DoubleBinaryOperator operator;

    @PostMapping(path = "/operations")
    public CalculateOperationResponse calculate(@RequestBody CalculateOperationRequest request) {
        return new CalculateOperationResponse(operator.applyAsDouble(request.x(), request.y()));
    }
}

@Configuration
class OperatorConfig {

    @Bean
    @ConditionalOnProperty(name = "app.operator", havingValue = "+")
    public DoubleBinaryOperator operatorAn() {
        return (x, y) -> x + y;
    }

    @Bean
    @ConditionalOnProperty(name = "app.operator", havingValue = "-")
    public DoubleBinaryOperator operatorSn() {
        return (x, y) -> x - y;
    }

    @Bean
    @ConditionalOnProperty(name = "app.operator", havingValue = "*")
    public DoubleBinaryOperator operatorMn() {
        return (x, y) -> x * y;
    }

    @Bean
    @ConditionalOnProperty(name = "app.operator", havingValue = "/")
    public DoubleBinaryOperator operatorDn() {
        return (x, y) -> x / y;
    }
}
