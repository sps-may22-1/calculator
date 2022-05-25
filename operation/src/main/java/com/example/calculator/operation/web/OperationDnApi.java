package com.example.calculator.operation.web;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OperationDnApi {

    @PostMapping(path = "/dn-operations")
    public CalculateOperationResponse calculate(@RequestBody CalculateOperationRequest request) {
        return new CalculateOperationResponse(request.x() / request.y());
    }
}
