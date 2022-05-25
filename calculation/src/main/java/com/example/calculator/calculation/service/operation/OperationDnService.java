package com.example.calculator.calculation.service.operation;

import org.springframework.stereotype.Service;

@Service
public class OperationDnService extends AbstractOperationService {

    @Override
    protected int getOperationPort() {
        return 8084;
    }
}
