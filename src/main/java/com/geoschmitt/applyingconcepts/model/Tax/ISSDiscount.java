package com.geoschmitt.applyingconcepts.model.Tax;

import com.geoschmitt.applyingconcepts.model.Invoice;

import java.math.BigDecimal;

public class ISSDiscount extends TaxDiscount{

    public ISSDiscount(TaxDiscount next) {
        super(next);
    }

    @Override
    public BigDecimal calculate(Invoice invoice) {
        if (invoice.getPrice().compareTo(new BigDecimal(950)) > 0){
            ISS tax = new ISS();
            BigDecimal price = invoice.getPrice();
            invoice.setPrice( price.subtract(tax.calculate(price)));
        }
        return next.calculate(invoice);
    }
}
