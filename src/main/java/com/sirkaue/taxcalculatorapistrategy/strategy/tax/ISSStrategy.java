package com.sirkaue.taxcalculatorapistrategy.strategy.tax;

import org.springframework.stereotype.Component;

@Component("ISS")
public class ISSStrategy implements TaxStrategy {

    @Override
    public Double calculateTax(Double amount) {
        return amount * 0.05; // ISS de 5%
    }
}

