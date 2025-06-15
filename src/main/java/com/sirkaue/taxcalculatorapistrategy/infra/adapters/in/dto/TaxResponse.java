package com.sirkaue.taxcalculatorapistrategy.infra.adapters.in.dto;

import com.sirkaue.taxcalculatorapistrategy.domain.enums.TaxType;

public record TaxResponse(
        TaxType taxType,
        double amount,
        double totalTaxes
) {
}