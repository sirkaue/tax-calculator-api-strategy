package com.sirkaue.taxcalculatorapistrategy.strategy.context;

import com.sirkaue.taxcalculatorapistrategy.domain.TaxType;

public interface TaxContext {

    void setStrategy(TaxType taxType);

    double calculate(double amount);
}
