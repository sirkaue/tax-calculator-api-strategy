package com.sirkaue.taxcalculatorapistrategy.application.ports.out.factory;

import com.sirkaue.taxcalculatorapistrategy.application.ports.out.strategy.TaxStrategy;
import com.sirkaue.taxcalculatorapistrategy.domain.enums.TaxType;

public interface TaxStrategyFactory {

    TaxStrategy create(TaxType taxType);
}
