package com.geoschmitt.applyingconcepts.model.Tax;

import com.geoschmitt.applyingconcepts.model.Invoice;

import java.math.BigDecimal;

public class ICMSDiscount extends TaxDiscount{

    public ICMSDiscount(TaxDiscount next) {
        super(next);
    }

    @Override
    public BigDecimal calculate(Invoice invoice) {
        if (invoice.getPrice().compareTo(new BigDecimal(1000)) > 0){
            ICMS tax = new ICMS();
            BigDecimal price = invoice.getPrice();
            invoice.setPrice( price.subtract(tax.calculate(price)));
        }
        return next.calculate(invoice);
    }
}
