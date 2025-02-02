package com.sirkaue.taxcalculatorapistrategy.strategy.context;

import com.sirkaue.taxcalculatorapistrategy.strategy.tax.TaxStrategy;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class TaxContextImpl implements TaxContext {

    private TaxStrategy strategy;
    private final Map<String, TaxStrategy> strategies;

    public TaxContextImpl(Map<String, TaxStrategy> strategies) {
        this.strategies = strategies;
    }

    public TaxStrategy getStrategy() {
        return strategy;
    }

    public void setStrategy(TaxStrategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public void setStrategy(String taxType) {
        TaxStrategy strategy = strategies.get(taxType);
        if (strategy == null) {
            throw new IllegalArgumentException("Tipo de imposto inválido!");
        }
        setStrategy(strategy);
    }

    @Override
    public Double calculateTax(Double amount) {
        return getStrategy().calculateTax(amount);
    }
}
