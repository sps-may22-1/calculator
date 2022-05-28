package com.example.calculator.calculation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class CalculationApplication {

    public static void main(String[] args) {
        SpringApplication.run(CalculationApplication.class, args);
    }
}
