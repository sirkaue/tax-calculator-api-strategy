package com.sirkaue.taxcalculatorapistrategy.domain.exception;

import com.sirkaue.taxcalculatorapistrategy.domain.enums.TaxType;

public class StrategyNotFoundException extends RuntimeException {

    private final TaxType taxType;

    public StrategyNotFoundException(TaxType taxType) {
        super("No strategy found for tax type: " + taxType);
        this.taxType = taxType;
    }

    public StrategyNotFoundException(String message) {
        super(message);
        this.taxType = null;
    }

    public TaxType getTaxType() {
        return taxType;
    }
}
