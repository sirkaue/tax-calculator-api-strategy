package com.sirkaue.taxcalculatorapistrategy.infra.adapters.out.factory;

import com.sirkaue.taxcalculatorapistrategy.application.ports.out.factory.TaxStrategyFactory;
import com.sirkaue.taxcalculatorapistrategy.application.ports.out.strategy.TaxStrategy;
import com.sirkaue.taxcalculatorapistrategy.domain.enums.TaxType;
import com.sirkaue.taxcalculatorapistrategy.domain.exception.StrategyNotFoundException;
import com.sirkaue.taxcalculatorapistrategy.domain.exception.TaxTypeNullException;

import java.util.Map;

public class TaxStrategyFactoryImpl implements TaxStrategyFactory {

    private final Map<TaxType, TaxStrategy> strategyMap;

    public TaxStrategyFactoryImpl(Map<TaxType, TaxStrategy> strategyMap) {
        this.strategyMap = strategyMap;
    }

    @Override
    public TaxStrategy create(TaxType taxType) {
        if (taxType == null) {
            throw new TaxTypeNullException();
        }

        TaxStrategy strategy = strategyMap.get(taxType);

        if (strategy == null) {
            throw new StrategyNotFoundException(taxType);
        }
        return strategy;
    }
}
