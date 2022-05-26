package com.example.calculator.calculation.service.operation;

import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;

@Service
public class OperationSnService extends AbstractOperationService {

    public OperationSnService(DiscoveryClient discoveryClient) {
        super(discoveryClient);
    }

    @Override
    protected String getOperationCode() {
        return "sn";
    }
}
