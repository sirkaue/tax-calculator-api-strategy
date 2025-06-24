package com.sirkaue.taxcalculatorapistrategy.unit.infra.adapters.out.factory;

import com.sirkaue.taxcalculatorapistrategy.application.ports.out.strategy.TaxStrategy;
import com.sirkaue.taxcalculatorapistrategy.domain.enums.TaxType;
import com.sirkaue.taxcalculatorapistrategy.infra.adapters.out.factory.TaxStrategyFactoryImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
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

    @Test
    void shouldThrowWhenTaxTypeIsNull() {
        // Arrange
        TaxStrategyFactoryImpl factory = new TaxStrategyFactoryImpl(Map.of());

        // Act
        Executable executable = () -> factory.create(null);

        // Assert
        assertThrows(IllegalStateException.class, executable);
    }
}
