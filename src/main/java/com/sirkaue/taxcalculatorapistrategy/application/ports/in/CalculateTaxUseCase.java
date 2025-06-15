package com.sirkaue.taxcalculatorapistrategy.application.ports.in;

import com.sirkaue.taxcalculatorapistrategy.domain.enums.TaxType;

public interface CalculateTaxUseCase {

    double execute(TaxType taxType, double amount);
}
