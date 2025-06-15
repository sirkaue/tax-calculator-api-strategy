package com.sirkaue.taxcalculatorapistrategy.infra.adapters.in.dto;

import com.sirkaue.taxcalculatorapistrategy.domain.enums.TaxType;

public record TaxRequest(TaxType taxType, double amount) {
}