package com.sirkaue.taxcalculatorapistrategy.application.ports.out.strategy;

import com.sirkaue.taxcalculatorapistrategy.domain.enums.TaxType;

public interface TaxStrategy {

    TaxType getType();

    double calculate(double amount);
}
