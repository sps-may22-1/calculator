package com.example.calculator.calculation.service.operation.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "dn")
interface OperationDnApiClient extends OperationApiClient {
}
