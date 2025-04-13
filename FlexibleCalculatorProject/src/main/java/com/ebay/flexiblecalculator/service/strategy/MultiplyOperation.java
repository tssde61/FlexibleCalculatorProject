package com.ebay.flexiblecalculator.service.strategy;

import com.ebay.flexiblecalculator.model.OperationType;
import org.springframework.stereotype.Component;

@Component
public class MultiplyOperation implements OperationStrategy {
    public OperationType getOperationType() { return OperationType.MULTIPLY; }
    public double apply(double a, double b) { return a * b; }
}