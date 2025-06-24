package com.sirkaue.taxcalculatorapistrategy.unit.infra.adapters.out.strategy;

import com.sirkaue.taxcalculatorapistrategy.application.ports.out.strategy.TaxStrategy;
import com.sirkaue.taxcalculatorapistrategy.domain.enums.TaxType;
import com.sirkaue.taxcalculatorapistrategy.infra.adapters.out.strategy.ICMSStrategy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ICMSStrategyTest {

    private final TaxStrategy strategy = new ICMSStrategy();

    @Test
    void shouldGetType() {
        // Arrange & Act
        TaxType type = strategy.getType();

        // Assert
        assertEquals(TaxType.ICMS, type, "O tipo retornado deve ser ICMS");
    }
}
