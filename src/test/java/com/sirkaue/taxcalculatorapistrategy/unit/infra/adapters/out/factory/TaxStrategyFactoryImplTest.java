package com.sirkaue.taxcalculatorapistrategy.unit.infra.adapters.out.factory;

import com.sirkaue.taxcalculatorapistrategy.application.ports.out.strategy.TaxStrategy;
import com.sirkaue.taxcalculatorapistrategy.domain.enums.TaxType;
import com.sirkaue.taxcalculatorapistrategy.infra.adapters.out.factory.TaxStrategyFactoryImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
class TaxStrategyFactoryImplTest {

    @Test
    void shouldReturnCorrectStrategyWhenTaxTypeIsValid() {
        // Arrange
        TaxStrategy icmsStrategy = mock(TaxStrategy.class);
        Map<TaxType, TaxStrategy> strategyMap = Map.of(TaxType.ICMS, icmsStrategy);
        TaxStrategyFactoryImpl factory = new TaxStrategyFactoryImpl(strategyMap);

        // Act
        TaxStrategy result = factory.create(TaxType.ICMS);

        // Assert
        assertSame(icmsStrategy, result);
    }
}
