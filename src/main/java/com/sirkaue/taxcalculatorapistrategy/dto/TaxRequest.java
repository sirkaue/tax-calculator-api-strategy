package com.sirkaue.taxcalculatorapistrategy.dto;

import com.sirkaue.taxcalculatorapistrategy.domain.TaxType;

public record TaxRequest(
        TaxType taxType,
        double amount
) {
}
