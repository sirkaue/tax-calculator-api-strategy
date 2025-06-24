package com.sirkaue.taxcalculatorapistrategy.unit.infra.adapters.out.strategy;

import com.sirkaue.taxcalculatorapistrategy.application.ports.out.strategy.TaxStrategy;
import com.sirkaue.taxcalculatorapistrategy.domain.enums.TaxType;
import com.sirkaue.taxcalculatorapistrategy.infra.adapters.out.strategy.IRStrategy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IRStrategyTest {

    private final TaxStrategy strategy = new IRStrategy();

    @Test
    void shouldGetType() {
        // Arrange & Act
        TaxType type = strategy.getType();

        // Assert
        assertEquals(TaxType.IR, type, "O tipo retornado deve ser IR");
    }
}
