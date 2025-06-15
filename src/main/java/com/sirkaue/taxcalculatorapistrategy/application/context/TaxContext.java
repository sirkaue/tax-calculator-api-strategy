package com.sirkaue.taxcalculatorapistrategy.application.context;

import com.sirkaue.taxcalculatorapistrategy.domain.enums.TaxType;

public interface TaxContext {

    void setStrategy(TaxType taxType);

    double calculateTax(double amount);
}
