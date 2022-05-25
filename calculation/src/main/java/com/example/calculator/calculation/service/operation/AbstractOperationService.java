package com.example.calculator.calculation.service.operation;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;


public abstract class AbstractOperationService {

    private static final RestTemplate httpClient = new RestTemplateBuilder()
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();

    public double calculate(double x, double y) {
        String url = "http://localhost:%d/operations".formatted(getOperationPort());

        String requestJson = """
                {
                    "x": %f,
                    "y": %f
                }""".formatted(x, y);

        JsonNode responseJson = httpClient.postForObject(url, requestJson, JsonNode.class);

        return responseJson.get("result").asDouble();
    }

    protected abstract int getOperationPort();
}

