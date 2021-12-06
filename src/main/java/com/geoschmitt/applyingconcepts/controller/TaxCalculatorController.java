package com.geoschmitt.applyingconcepts.controller;

import com.geoschmitt.applyingconcepts.model.ICMS;
import com.geoschmitt.applyingconcepts.model.ISS;
import com.geoschmitt.applyingconcepts.service.TaxCalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/TaxCalculator")
public class TaxCalculatorController {

    @Autowired
    TaxCalculatorService taxCalculatorService;


    /**
    * Applying the Strategy Concept
    * Design Pattern
     */
    @GetMapping("/ICMS/{price}")
    public ResponseEntity<BigDecimal> processingICMSTax(@PathVariable("price") BigDecimal price){
        BigDecimal result = taxCalculatorService.calculateTax(price, new ICMS());
        return new ResponseEntity<BigDecimal>(result, HttpStatus.OK);
    }

    @GetMapping("/ISS/{price}")
    public ResponseEntity<BigDecimal> processingISSTax(@PathVariable("price") BigDecimal price){
        BigDecimal result = taxCalculatorService.calculateTax(price, new ISS());
        return new ResponseEntity<BigDecimal>(result, HttpStatus.OK);
    }

}
