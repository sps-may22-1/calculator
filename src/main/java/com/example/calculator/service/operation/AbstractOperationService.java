package com.example.calculator.service.operation;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;


@RequiredArgsConstructor
public abstract class AbstractOperationService {

    private final Environment environment;

    private static final RestTemplate httpClient = new RestTemplateBuilder()
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();

    public double calculate(double x, double y) {
        int serverPort = Integer.parseInt(environment.getProperty("local.server.port"));

        String url = "http://localhost:%d/%s-operations".formatted(serverPort, getOperationCode());

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

