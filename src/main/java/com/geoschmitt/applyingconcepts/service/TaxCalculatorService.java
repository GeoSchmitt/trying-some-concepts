package com.geoschmitt.applyingconcepts.service;

import com.geoschmitt.applyingconcepts.model.Tax;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class TaxCalculatorService {


    public BigDecimal calculateTax(BigDecimal price, Tax tax){
        return tax.calculate(price);
    }


}
