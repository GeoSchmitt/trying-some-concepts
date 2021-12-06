package com.geoschmitt.applyingconcepts.model.Tax;

import com.geoschmitt.applyingconcepts.model.Invoice;

import java.math.BigDecimal;

public class NoTax extends TaxDiscount{

    public NoTax() {
        super(null);
    }

    @Override
    public BigDecimal calculate(Invoice invoice) {
        return invoice.getPrice();
    }
}
