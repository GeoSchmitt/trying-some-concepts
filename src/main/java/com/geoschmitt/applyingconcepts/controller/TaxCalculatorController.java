package com.geoschmitt.applyingconcepts.controller;

import com.geoschmitt.applyingconcepts.model.Dto.InvoiceDto;
import com.geoschmitt.applyingconcepts.model.Invoice;
import com.geoschmitt.applyingconcepts.model.Tax.ICMS;
import com.geoschmitt.applyingconcepts.model.Tax.ISS;
import com.geoschmitt.applyingconcepts.service.TaxCalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @PostMapping("/ICMS")
    public ResponseEntity<BigDecimal> invoiceICMSTax(@RequestBody @Valid InvoiceDto invoiceDto){
        Invoice invoice = invoiceDto.convert();
        BigDecimal result = taxCalculatorService.calculateTax(invoice.getPrice(), new ICMS());
        return new ResponseEntity<BigDecimal>(result, HttpStatus.OK);
    }

    /**
     * Applying the Chain of Responsibility Concept
     * Design Pattern
     */
    @PostMapping("/afterTax")
    public ResponseEntity<BigDecimal> afterTax(@RequestBody @Valid InvoiceDto invoiceDto){
        Invoice invoice = invoiceDto.convert();
        BigDecimal result = taxCalculatorService.afterTax(invoice);
        return new ResponseEntity<BigDecimal>(result, HttpStatus.OK);
    }


}
