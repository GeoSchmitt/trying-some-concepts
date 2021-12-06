package com.geoschmitt.applyingconcepts.model.Tax;

import java.math.BigDecimal;

public interface Tax {

    BigDecimal calculate(BigDecimal price);

}
