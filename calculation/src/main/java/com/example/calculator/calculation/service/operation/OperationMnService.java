package com.example.calculator.calculation.service.operation;

import org.springframework.stereotype.Service;

@Service
public class OperationMnService extends AbstractOperationService {

    @Override
    protected int getOperationPort() {
        return 8083;
    }
}
