package com.sirkaue.taxcalculatorapistrategy.service;

import com.sirkaue.taxcalculatorapistrategy.domain.TaxType;

public interface TaxService {

    double execute(TaxType taxType, double amount);
}
