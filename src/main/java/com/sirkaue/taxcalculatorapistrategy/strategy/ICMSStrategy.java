package com.sirkaue.taxcalculatorapistrategy.strategy;

public class ICMSStrategy implements TaxStrategy {

    @Override
    public Double calculateTax(Double amount) {
        return amount * 0.17; // ICMS de 17%
    }
}

