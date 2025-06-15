package com.sirkaue.taxcalculatorapistrategy.application.ports.out;

import com.sirkaue.taxcalculatorapistrategy.domain.enums.TaxType;

public interface TaxStrategy {

    TaxType getType();

    double calculate(double amount);
}
