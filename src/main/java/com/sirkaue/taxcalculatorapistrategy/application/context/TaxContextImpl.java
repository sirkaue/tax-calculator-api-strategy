package com.sirkaue.taxcalculatorapistrategy.application.context;

import com.sirkaue.taxcalculatorapistrategy.application.ports.out.TaxStrategy;
import com.sirkaue.taxcalculatorapistrategy.domain.enums.TaxType;

import java.util.Map;

public class TaxContextImpl implements TaxContext {

    private final Map<TaxType, TaxStrategy> strategies;
    private TaxStrategy strategy;

    public TaxContextImpl(Map<TaxType, TaxStrategy> strategies) {
        this.strategies = strategies;
    }

    @Override
    public void setStrategy(TaxType taxType) {
        if (taxType == null) {
            throw new IllegalStateException("Tax type must not be null");
        }
        strategy = strategies.get(taxType);
    }

    @Override
    public double calculateTax(double amount) {
        if (strategy == null) {
            throw new IllegalStateException("No strategy set");
        }
        return strategy.calculate(amount);
    }
}
