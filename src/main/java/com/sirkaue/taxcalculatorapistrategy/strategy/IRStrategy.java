package com.sirkaue.taxcalculatorapistrategy.strategy;

public class IRStrategy implements TaxStrategy {

    @Override
    public Double calculateTax(Double amount) {
        return amount * 0.275; // IR de 27.5%
    }
}

