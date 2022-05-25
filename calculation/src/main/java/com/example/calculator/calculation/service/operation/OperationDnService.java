package com.example.calculator.calculation.service.operation;

import org.springframework.stereotype.Service;

@Service
public class OperationDnService extends AbstractOperationService {

    @Override
    protected String getOperationCode() {
        return "dn";
    }
}
