package com.example.calculator.calculation.service.operation;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;


@RequiredArgsConstructor
public abstract class AbstractOperationService {

    private final DiscoveryClient discoveryClient;

    private static final RestTemplate httpClient = new RestTemplateBuilder()
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();

    public double calculate(double x, double y) {
        ServiceInstance serviceInstance = discoveryClient.getInstances(getOperationCode()).get(0);

        String url = "http://%s:%d/operations".formatted(serviceInstance.getHost(), serviceInstance.getPort());

        String requestJson = """
                {
                    "x": %f,
                    "y": %f
                }""".formatted(x, y);

        JsonNode responseJson = httpClient.postForObject(url, requestJson, JsonNode.class);

        return responseJson.get("result").asDouble();
    }

    protected abstract String getOperationCode();
}

