package com.sirkaue.taxcalculatorapistrategy.infra.adapters.out;

import com.sirkaue.taxcalculatorapistrategy.application.ports.out.TaxStrategy;
import com.sirkaue.taxcalculatorapistrategy.domain.enums.TaxType;
import org.springframework.stereotype.Component;

@Component
public class ICMSStrategy implements TaxStrategy {

    @Override
    public TaxType getType() {
        return TaxType.ICMS;
    }

    @Override
    public double calculate(double amount) {
        return amount * 0.17; // ICMS de 17%
    }
}