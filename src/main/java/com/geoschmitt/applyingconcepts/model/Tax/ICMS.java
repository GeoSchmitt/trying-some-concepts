package com.geoschmitt.applyingconcepts.model.Tax;

import java.math.BigDecimal;

public class ICMS implements Tax {

    @Override
    public BigDecimal calculate(BigDecimal price) {
        return price.multiply(new BigDecimal("0.50"));
    }
}
