package com.geoschmitt.applyingconcepts.model;

import java.math.BigDecimal;

public class Invoice {

    public BigDecimal price;
    public String client;

    public Invoice(BigDecimal price, String client) {
        this.price = price;
        this.client = client;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }
}
