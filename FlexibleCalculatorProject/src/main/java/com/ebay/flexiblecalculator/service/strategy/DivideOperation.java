package com.ebay.flexiblecalculator.service.strategy;

import com.ebay.flexiblecalculator.model.OperationType;
import org.springframework.stereotype.Component;

@Component
public class DivideOperation implements OperationStrategy {
    public OperationType getOperationType() { return OperationType.DIVIDE; }
    public double apply(double a, double b) {
        if (b == 0) throw new ArithmeticException("Cannot divide by zero");
        return a / b;
    }
}