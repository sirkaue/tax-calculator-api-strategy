package com.sirkaue.taxcalculatorapistrategy.config;

import com.sirkaue.taxcalculatorapistrategy.domain.TaxType;
import com.sirkaue.taxcalculatorapistrategy.strategy.context.TaxContext;
import com.sirkaue.taxcalculatorapistrategy.strategy.context.TaxContextImpl;
import com.sirkaue.taxcalculatorapistrategy.strategy.tax.TaxStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Configuration
public class CalculateTaxConfig {

    @Bean
    public TaxContext taxContext(Map<TaxType, TaxStrategy> strategies) {
        return new TaxContextImpl(strategies);
    }

    @Bean
    public Map<TaxType, TaxStrategy> strategyMap(List<TaxStrategy> strategies) {
        return strategies.stream().collect(Collectors.toMap(TaxStrategy::getType, Function.identity()));
    }
}
