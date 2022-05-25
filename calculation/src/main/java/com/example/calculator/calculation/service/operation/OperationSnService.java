package com.example.calculator.calculation.service.operation;

import org.springframework.stereotype.Service;

@Service
public class OperationSnService extends AbstractOperationService {

    @Override
    protected int getOperationPort() {
        return 8082;
    }
}
