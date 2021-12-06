package com.geoschmitt.applyingconcepts.service;

import com.geoschmitt.applyingconcepts.model.Invoice;
import com.geoschmitt.applyingconcepts.model.Tax.*;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class TaxCalculatorService {


    public BigDecimal calculateTax(BigDecimal price, Tax tax){
        return tax.calculate(price);
    }

    public BigDecimal afterTax(Invoice invoice){
        TaxDiscount taxDiscount = new ICMSDiscount(new ISSDiscount(new NoTax()));
        return taxDiscount.calculate(invoice);
    }

}
