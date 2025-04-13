package com.ebay.flexiblecalculator.service.strategy;

import com.ebay.flexiblecalculator.model.OperationType;
import org.springframework.stereotype.Component;

@Component
public class SubtractOperation implements OperationStrategy {
    public OperationType getOperationType() { return OperationType.SUBTRACT; }
    public double apply(double a, double b) { return a - b; }
}