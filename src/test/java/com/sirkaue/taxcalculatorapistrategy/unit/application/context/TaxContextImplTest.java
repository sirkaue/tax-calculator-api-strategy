package com.sirkaue.taxcalculatorapistrategy.unit.application.context;

import com.sirkaue.taxcalculatorapistrategy.application.context.TaxContextImpl;
import com.sirkaue.taxcalculatorapistrategy.application.ports.out.factory.TaxStrategyFactory;
import com.sirkaue.taxcalculatorapistrategy.application.ports.out.strategy.TaxStrategy;
import com.sirkaue.taxcalculatorapistrategy.domain.enums.TaxType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TaxContextImplTest {

    @Mock
    private TaxStrategyFactory factory;

    @Mock
    private TaxStrategy strategy;

    @InjectMocks
    private TaxContextImpl context;

    @Test
    void shouldSetStrategyUsingFactory() {
        // Arrange
        TaxType taxType = TaxType.ICMS;
        when(factory.create(taxType)).thenReturn(strategy);

        // Act
        context.setStrategy(taxType);

        // Assert
        verify(factory).create(taxType);
    }

    @Test
    void shouldCalculateTaxUsingStrategy() {
        // Arrange
        TaxType taxType = TaxType.ICMS;
        double amount = 1000.0;
        double expectedTax = 170.0;

        when(factory.create(taxType)).thenReturn(strategy);
        when(strategy.calculate(amount)).thenReturn(expectedTax);

        // Act
        context.setStrategy(taxType);
        double result = context.calculateTax(amount);

        // Assert
        assertEquals(expectedTax, result);
        verify(factory).create(taxType);
        verify(strategy).calculate(amount);
    }
}
