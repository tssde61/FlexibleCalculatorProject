package com.ebay.flexiblecalculator.service.strategy;

import com.ebay.flexiblecalculator.model.OperationType;

public interface OperationStrategy {
    OperationType getOperationType();
    double apply(double a, double b);
}