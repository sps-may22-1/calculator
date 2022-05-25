package com.example.calculator.operation.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
public class AbstractOperationApiTest {

    @Autowired
    private MockMvc mockMvc;

    protected void performRequestAndVerify(double expectedResult) throws Exception {
        String requestJson = """
                {
                    "x": 1.0,
                    "y": 2.0
                }""";

        String responseJson = """
                {
                    "result": %f
                }""".formatted(expectedResult);

        mockMvc.perform(post("/operations")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                .andExpect(status().isOk())
                .andExpect(content().json(responseJson, true));
    }
}

@SpringBootTest(properties = "app.operator=+")
class OperationAnApiTest extends AbstractOperationApiTest {

    @Test
    void calculate() throws Exception {
        performRequestAndVerify(1.0 + 2.0);
    }
}

@SpringBootTest(properties = "app.operator=-")
class OperationSnApiTest extends AbstractOperationApiTest {

    @Test
    void calculate() throws Exception {
        performRequestAndVerify(1.0 - 2.0);
    }
}
