package com.geoschmitt.applyingconcepts.model.Dto;

import com.geoschmitt.applyingconcepts.model.Invoice;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class InvoiceDto {

    public BigDecimal price;

    @NotEmpty @NotNull
    public String client;

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Invoice convert(){
        return new Invoice(this.price, this.client);
    }
}
