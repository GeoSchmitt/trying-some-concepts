package com.geoschmitt.applyingconcepts.model.Tax;

import com.geoschmitt.applyingconcepts.model.Invoice;

import java.math.BigDecimal;

public abstract class TaxDiscount {

    protected TaxDiscount next;

    public TaxDiscount(TaxDiscount next){
        this.next = next;
    }

    public abstract BigDecimal calculate(Invoice invoice);
}
