package com.ebay.flexiblecalculator.service;

import com.ebay.flexiblecalculator.exception.UnsupportedOperationException;
import com.ebay.flexiblecalculator.model.OperationType;
import com.ebay.flexiblecalculator.payload.ChainedOperationRequest;
import com.ebay.flexiblecalculator.service.strategy.OperationStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CalculatorService {
    private final Map<OperationType, OperationStrategy> strategyMap;

    @Autowired
    public CalculatorService(List<OperationStrategy> strategies) {
        this.strategyMap = strategies.stream().collect(
            Collectors.toMap(OperationStrategy::getOperationType, s -> s)
        );
    }

    public double calculate(OperationType operation, Double a, Double b) {
        if (a == null || b == null) {
            throw new UnsupportedOperationException("Operands must not be null");
        }

        OperationStrategy strategy = strategyMap.get(operation);
        if (strategy == null) {
            throw new UnsupportedOperationException("Unsupported operation: " + operation);
        }

        try {
            return strategy.apply(a, b);
        } catch (ArithmeticException ex) {
            throw new UnsupportedOperationException("Invalid arithmetic operation: " + ex.getMessage());
        }
    }


    public double chainCalculate(ChainedOperationRequest request) {
        double result = request.getInitialValue();
        for (ChainedOperationRequest.Step step : request.getSteps()) {
            if (step.getValue() == null) {
                throw new UnsupportedOperationException("Operands must not be null");
            }
            result = calculate(step.getOperation(), result, step.getValue());
        }
        return result;
    }
}