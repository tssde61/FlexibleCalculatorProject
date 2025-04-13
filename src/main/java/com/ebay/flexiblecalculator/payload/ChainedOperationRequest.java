package com.ebay.flexiblecalculator.payload;

import com.ebay.flexiblecalculator.model.OperationType;
import lombok.Data;

import java.util.List;

@Data
public class ChainedOperationRequest {
    private double initialValue;
    private List<Step> steps;

    @Data
    public static class Step {
        private OperationType operation;
        private Double value;
    }
}