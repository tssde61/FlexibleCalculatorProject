package com.calculator;

import com.ebay.flexiblecalculator.model.OperationType;
import com.ebay.flexiblecalculator.payload.OperationRequest;
import com.ebay.flexiblecalculator.service.CalculatorService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.ebay.flexiblecalculator.controller.CalculatorController;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import org.springframework.test.context.ContextConfiguration;
import com.ebay.flexiblecalculator.FlexibleCalculatorApplication;

import java.util.List;
import com.ebay.flexiblecalculator.payload.ChainedOperationRequest;



@WebMvcTest(controllers = CalculatorController.class)
@ContextConfiguration(classes = com.ebay.flexiblecalculator.FlexibleCalculatorApplication.class)

public class CalculatorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CalculatorService calculatorService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testCalculateEndpoint() throws Exception {
        OperationRequest request = new OperationRequest();
        request.setOperation(OperationType.ADD);
        request.setA(4.0);
        request.setB(5.0);

        Mockito.when(calculatorService.calculate(OperationType.ADD, 4.0, 5.0)).thenReturn(9.0);

        mockMvc.perform(post("/api/calculator/calculate")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(content().string("9.0"));
    }

    @Test
    void testChainCalculateEndpoint() throws Exception {
        ChainedOperationRequest request = new ChainedOperationRequest();
        request.setInitialValue(5.0);

        ChainedOperationRequest.Step step1 = new ChainedOperationRequest.Step();
        step1.setOperation(OperationType.ADD);
        step1.setValue(3.0);

        ChainedOperationRequest.Step step2 = new ChainedOperationRequest.Step();
        step2.setOperation(OperationType.MULTIPLY);
        step2.setValue(2.0);

        request.setSteps(List.of(step1, step2));

        Mockito.when(calculatorService.chainCalculate(Mockito.any(ChainedOperationRequest.class)))
                .thenReturn(16.0);

        mockMvc.perform(post("/api/calculator/chain")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(content().string("16.0"));
    }
}