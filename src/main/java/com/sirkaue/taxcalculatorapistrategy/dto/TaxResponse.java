package com.sirkaue.taxcalculatorapistrategy.dto;

import com.sirkaue.taxcalculatorapistrategy.domain.TaxType;

public record TaxResponse(
        TaxType taxType,
        Double amount,
        Double taxValue
) {
}
