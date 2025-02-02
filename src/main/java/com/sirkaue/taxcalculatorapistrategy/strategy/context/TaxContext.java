package com.sirkaue.taxcalculatorapistrategy.strategy.context;

public interface TaxContext {
    void setStrategy(String taxType);

    Double calculateTax(Double amount);
}
