package com.ebay.flexiblecalculator.controller;

import com.ebay.flexiblecalculator.payload.ChainedOperationRequest;
import com.ebay.flexiblecalculator.payload.OperationRequest;
import com.ebay.flexiblecalculator.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/calculator")
public class CalculatorController {

    @Autowired
    private CalculatorService calculatorService;

    @PostMapping("/calculate")
    public double calculate(@RequestBody OperationRequest request) {
        return calculatorService.calculate(request.getOperation(), request.getA(), request.getB());
    }

    @PostMapping("/chain")
    public double chainCalculate(@RequestBody ChainedOperationRequest request) {
        return calculatorService.chainCalculate(request);
    }
}