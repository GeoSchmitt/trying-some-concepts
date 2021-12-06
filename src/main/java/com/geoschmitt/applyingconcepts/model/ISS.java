package com.geoschmitt.applyingconcepts.model;

import java.math.BigDecimal;

public class ISS implements Tax{

    @Override
    public BigDecimal calculate(BigDecimal price) {
        return price.multiply(new BigDecimal("0.20"));
    }
}
