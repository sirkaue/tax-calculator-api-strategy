package com.sirkaue.taxcalculatorapistrategy.strategy.tax;

import org.springframework.stereotype.Component;

@Component("IR")
public class IRStrategy implements TaxStrategy {

    @Override
    public Double calculateTax(Double amount) {
        return amount * 0.275; // IR de 27.5%
    }
}

