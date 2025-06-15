package com.sirkaue.taxcalculatorapistrategy.strategy.tax;

import com.sirkaue.taxcalculatorapistrategy.domain.TaxType;
import org.springframework.stereotype.Component;

@Component
public class IRStrategy implements TaxStrategy {

    @Override
    public TaxType getType() {
        return TaxType.IR;
    }

    @Override
    public double calculateTax(double amount) {
        return amount * 0.275; // IR de 27.5%
    }
}

