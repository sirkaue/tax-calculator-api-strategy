package com.sirkaue.taxcalculatorapistrategy.infra.adapters.out;

import com.sirkaue.taxcalculatorapistrategy.application.ports.out.TaxStrategy;
import com.sirkaue.taxcalculatorapistrategy.domain.enums.TaxType;
import org.springframework.stereotype.Component;

@Component
public class IRStrategy implements TaxStrategy {

    @Override
    public TaxType getType() {
        return TaxType.IR;
    }

    @Override
    public double calculate(double amount) {
        return amount * 0.275; // IR de 27.5%
    }
}
