package com.geoschmitt.applyingconcepts.model;

import java.math.BigDecimal;

public interface Tax {

    BigDecimal calculate(BigDecimal price);

}
