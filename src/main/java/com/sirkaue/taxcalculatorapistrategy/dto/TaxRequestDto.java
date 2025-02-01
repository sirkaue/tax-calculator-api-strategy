package com.sirkaue.taxcalculatorapistrategy.dto;

public record TaxRequestDto(
        String taxType,
        Double amount
) {
}
