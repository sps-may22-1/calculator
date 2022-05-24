package com.example.calculator.service.operation;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class OperationSnService extends AbstractOperationService {

    public OperationSnService(Environment environment) {
        super(environment);
    }

    @Override
    protected String getOperationCode() {
        return "sn";
    }
}
