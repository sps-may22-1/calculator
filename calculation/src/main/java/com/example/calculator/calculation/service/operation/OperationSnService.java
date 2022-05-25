package com.example.calculator.calculation.service.operation;

import org.springframework.stereotype.Service;

@Service
public class OperationSnService extends AbstractOperationService {

    @Override
    protected String getOperationCode() {
        return "sn";
    }
}
