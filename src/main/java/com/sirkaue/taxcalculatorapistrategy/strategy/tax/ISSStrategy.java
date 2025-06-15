package com.sirkaue.taxcalculatorapistrategy.strategy.tax;

import com.sirkaue.taxcalculatorapistrategy.domain.TaxType;
import org.springframework.stereotype.Component;

@Component
public class ISSStrategy implements TaxStrategy {

    @Override
    public TaxType getType() {
        return TaxType.ISS;
    }

    @Override
    public double calculateTax(double amount) {
        return amount * 0.05; // ISS de 5%
    }
}

