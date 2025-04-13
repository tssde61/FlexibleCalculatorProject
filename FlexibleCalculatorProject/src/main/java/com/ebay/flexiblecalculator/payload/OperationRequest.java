package com.ebay.flexiblecalculator.payload;

import com.ebay.flexiblecalculator.model.OperationType;
import lombok.Data;

@Data
public class OperationRequest {
    private OperationType operation;
    private Double a;
    private Double b;
}