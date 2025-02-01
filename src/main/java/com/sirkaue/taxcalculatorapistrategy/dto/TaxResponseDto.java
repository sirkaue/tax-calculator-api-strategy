package com.sirkaue.taxcalculatorapistrategy.dto;

public record TaxResponseDto(
        String taxType,
        Double amount,
        Double taxValue
) {
}
