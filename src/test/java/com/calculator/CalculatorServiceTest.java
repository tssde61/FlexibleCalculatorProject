package com.calculator;

import com.ebay.flexiblecalculator.exception.UnsupportedOperationException;
import com.ebay.flexiblecalculator.model.OperationType;
import com.ebay.flexiblecalculator.payload.ChainedOperationRequest;
import com.ebay.flexiblecalculator.service.CalculatorService;
import com.ebay.flexiblecalculator.service.strategy.AddOperation;
import com.ebay.flexiblecalculator.service.strategy.DivideOperation;
import com.ebay.flexiblecalculator.service.strategy.MultiplyOperation;
import com.ebay.flexiblecalculator.service.strategy.SubtractOperation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorServiceTest {

    private CalculatorService calculatorService;

    @BeforeEach
    void setUp() {
        calculatorService = new CalculatorService(List.of(
            new AddOperation(),
            new SubtractOperation(),
            new MultiplyOperation(),
            new DivideOperation()
        ));
    }

    @Test
    void testAddition() {
        assertEquals(8.0, calculatorService.calculate(OperationType.ADD, 5.0, 3.0));
    }

    @Test
    void testSubtraction() {
        assertEquals(2.0, calculatorService.calculate(OperationType.SUBTRACT, 5.0, 3.0));
    }

    @Test
    void testMultiplication() {
        assertEquals(15.0, calculatorService.calculate(OperationType.MULTIPLY, 5.0, 3.0));
    }

    @Test
    void testDivision() {
        assertEquals(2.0, calculatorService.calculate(OperationType.DIVIDE, 6.0, 3.0));
    }

    @Test
    void testNullOperands() {
        assertThrows(UnsupportedOperationException.class,
            () -> calculatorService.calculate(OperationType.ADD, null, 2.0));
    }

    @Test
    void testChainOperations() {
        ChainedOperationRequest request = new ChainedOperationRequest();
        request.setInitialValue(5.0);
        var step1 = new ChainedOperationRequest.Step();
        step1.setOperation(OperationType.ADD);
        step1.setValue(3.0);
        var step2 = new ChainedOperationRequest.Step();
        step2.setOperation(OperationType.MULTIPLY);
        step2.setValue(2.0);
        request.setSteps(List.of(step1, step2));

        assertEquals(16.0, calculatorService.chainCalculate(request));
    }

    @Test
    void testDivisionByZero() {
        assertThrows(UnsupportedOperationException.class, () ->
                calculatorService.calculate(OperationType.DIVIDE, 10.0, 0.0));
    }

    @Test
    void testInvalidOperation() {
        assertThrows(UnsupportedOperationException.class, () ->
                calculatorService.calculate(null, 10.0, 5.0));
    }

    @Test
    void testChainedOperationsWithDivisionByZero() {
        ChainedOperationRequest request = new ChainedOperationRequest();
        request.setInitialValue(10.0);
        ChainedOperationRequest.Step step = new ChainedOperationRequest.Step();
        step.setOperation(OperationType.DIVIDE);
        step.setValue(0.0);
        request.setSteps(List.of(step));
        assertThrows(UnsupportedOperationException.class, () -> calculatorService.chainCalculate(request));
    }

    @Test
    void testChainedOperationsWithNullOperand() {
        ChainedOperationRequest request = new ChainedOperationRequest();
        request.setInitialValue(5.0);
        ChainedOperationRequest.Step step = new ChainedOperationRequest.Step();
        step.setOperation(OperationType.ADD);
        step.setValue(null);
        request.setSteps(List.of(step));
        assertThrows(UnsupportedOperationException.class, () -> calculatorService.chainCalculate(request));
    }

    @Test
    void testChainedOperationsWithInvalidOperation() {
        ChainedOperationRequest request = new ChainedOperationRequest();
        request.setInitialValue(5.0);
        ChainedOperationRequest.Step step = new ChainedOperationRequest.Step();
        step.setOperation(null);
        step.setValue(2.0);
        request.setSteps(List.of(step));
        assertThrows(UnsupportedOperationException.class, () -> calculatorService.chainCalculate(request));
    }

    @Test
    void testNegativeNumberAddition() {
        double result = calculatorService.calculate(OperationType.ADD, -5.0, -3.0);
        assertEquals(-8.0, result);
    }

    @Test
    void testFloatingPointMultiplication() {
        double result = calculatorService.calculate(OperationType.MULTIPLY, 2.5, 4.0);
        assertEquals(10.0, result);
    }




}