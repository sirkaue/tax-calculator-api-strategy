package com.sirkaue.taxcalculatorapistrategy.application.usecase;

import com.sirkaue.taxcalculatorapistrategy.application.ports.in.CalculateTaxUseCase;
import com.sirkaue.taxcalculatorapistrategy.application.context.TaxContext;
import com.sirkaue.taxcalculatorapistrategy.domain.enums.TaxType;

public class CalculateTaxUseCaseImpl implements CalculateTaxUseCase {

    private final TaxContext context;

    public CalculateTaxUseCaseImpl(TaxContext context) {
        this.context = context;
    }

    @Override
    public double execute(TaxType taxType, double amount) {
        context.setStrategy(taxType);
        return context.calculateTax(amount);
    }
}
