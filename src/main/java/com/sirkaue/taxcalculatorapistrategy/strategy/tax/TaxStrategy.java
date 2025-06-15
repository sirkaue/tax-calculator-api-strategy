package com.sirkaue.taxcalculatorapistrategy.strategy.tax;

import com.sirkaue.taxcalculatorapistrategy.domain.TaxType;

public interface TaxStrategy {

    TaxType getType();

    double calculateTax(double amount);
}
