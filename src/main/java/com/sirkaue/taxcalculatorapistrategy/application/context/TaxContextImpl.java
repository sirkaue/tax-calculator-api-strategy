package com.sirkaue.taxcalculatorapistrategy.application.context;

import com.sirkaue.taxcalculatorapistrategy.application.ports.out.factory.TaxStrategyFactory;
import com.sirkaue.taxcalculatorapistrategy.application.ports.out.strategy.TaxStrategy;
import com.sirkaue.taxcalculatorapistrategy.domain.enums.TaxType;

public class TaxContextImpl implements TaxContext {

    private final TaxStrategyFactory factory;
    private TaxStrategy strategy;

    public TaxContextImpl(TaxStrategyFactory factory) {
        this.factory = factory;
    }

    @Override
    public void setStrategy(TaxType taxType) {
        strategy = factory.create(taxType);
    }

    @Override
    public double calculateTax(double amount) {
        if (strategy == null) {
            throw new IllegalStateException("No strategy set");
        }
        return strategy.calculate(amount);
    }
}
