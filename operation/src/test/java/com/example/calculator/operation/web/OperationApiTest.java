package com.example.calculator.operation.web;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.stream.Stream;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
class OperationApiTest {

    @Autowired
    private MockMvc mockMvc;

    @MethodSource("calculateDataSource")
    @ParameterizedTest
    void calculate(double x, double y, char operator, String operationCode) throws Exception {
        String requestJson = """
                {
                    "x": %f,
                    "y": %f,
                    "operator": "%s"
                }""".formatted(x, y, operator);

        ExpressionParser expressionParser = new SpelExpressionParser();
        Expression expression = expressionParser.parseExpression("%f %s %f".formatted(x, operator, y));

        String responseJson = """
                {
                    "result": %f
                }""".formatted(expression.getValue(double.class));

        mockMvc.perform(post("/%s-operations".formatted(operationCode))
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                .andExpect(status().isOk())
                .andExpect(content().json(responseJson, true));

    }

    private static Stream<Arguments> calculateDataSource() {
        return Stream.of(
                Arguments.of(1, 2, '+', "an"),
                Arguments.of(3, 4, '-', "sn"),
                Arguments.of(5, 6, '*', "mn"),
                Arguments.of(7, 8, '/', "dn")
        );
    }
}
