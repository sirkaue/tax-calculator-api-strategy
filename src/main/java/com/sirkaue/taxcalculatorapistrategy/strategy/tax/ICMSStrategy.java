package com.sirkaue.taxcalculatorapistrategy.strategy.tax;

import com.sirkaue.taxcalculatorapistrategy.domain.TaxType;
import org.springframework.stereotype.Component;

@Component
public class ICMSStrategy implements TaxStrategy {

    @Override
    public TaxType getType() {
        return TaxType.ICMS;
    }

    @Override
    public double calculateTax(double amount) {
        return amount * 0.17; // ICMS de 17%
    }
}

