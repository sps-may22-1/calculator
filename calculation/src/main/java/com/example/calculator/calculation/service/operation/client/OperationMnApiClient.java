package com.example.calculator.calculation.service.operation.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "mn")
interface OperationMnApiClient extends OperationApiClient {
}
