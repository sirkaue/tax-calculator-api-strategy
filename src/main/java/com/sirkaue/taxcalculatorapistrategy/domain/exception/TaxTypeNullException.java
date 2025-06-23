package com.sirkaue.taxcalculatorapistrategy.domain.exception;

public class TaxTypeNullException extends RuntimeException {

    public TaxTypeNullException() {
        super("Tax type must not be null");
    }
}
