package com.sirkaue.taxcalculatorapistrategy.infra.config;

import com.sirkaue.taxcalculatorapistrategy.application.context.TaxContext;
import com.sirkaue.taxcalculatorapistrategy.application.context.TaxContextImpl;
import com.sirkaue.taxcalculatorapistrategy.application.ports.in.CalculateTaxUseCase;
import com.sirkaue.taxcalculatorapistrategy.application.ports.out.TaxStrategy;
import com.sirkaue.taxcalculatorapistrategy.application.usecase.CalculateTaxUseCaseImpl;
import com.sirkaue.taxcalculatorapistrategy.domain.enums.TaxType;
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
