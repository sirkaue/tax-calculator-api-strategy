package com.sirkaue.taxcalculatorapistrategy.infra.config;

import com.sirkaue.taxcalculatorapistrategy.application.context.TaxContext;
import com.sirkaue.taxcalculatorapistrategy.application.context.TaxContextImpl;
import com.sirkaue.taxcalculatorapistrategy.application.ports.in.CalculateTaxUseCase;
import com.sirkaue.taxcalculatorapistrategy.application.ports.out.factory.TaxStrategyFactory;
import com.sirkaue.taxcalculatorapistrategy.application.ports.out.strategy.TaxStrategy;
import com.sirkaue.taxcalculatorapistrategy.application.usecase.CalculateTaxUseCaseImpl;
import com.sirkaue.taxcalculatorapistrategy.domain.enums.TaxType;
import com.sirkaue.taxcalculatorapistrategy.infra.adapters.out.factory.TaxStrategyFactoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Configuration
public class CalculateTaxConfig {

    @Bean
    public TaxStrategyFactory taxStrategyFactory(Map<TaxType, TaxStrategy> strategyMap) {
        return new TaxStrategyFactoryImpl(strategyMap);
    }

    @Bean
    public TaxContext taxContext(TaxStrategyFactory factory) {
        return new TaxContextImpl(factory);
    }

    @Bean
    public CalculateTaxUseCase calculateTaxUseCase(TaxContext context) {
        return new CalculateTaxUseCaseImpl(context);
    }

    @Bean
    public Map<TaxType, TaxStrategy> strategyMap(List<TaxStrategy> strategies) {
        return strategies.stream().collect(Collectors.toMap(
                TaxStrategy::getType,
                Function.identity()
        ));
    }
}
