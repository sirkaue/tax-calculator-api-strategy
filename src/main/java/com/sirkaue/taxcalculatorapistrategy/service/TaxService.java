package com.sirkaue.taxcalculatorapistrategy.service;

import com.sirkaue.taxcalculatorapistrategy.dto.TaxRequestDto;
import com.sirkaue.taxcalculatorapistrategy.dto.TaxResponseDto;

public interface TaxService {
    TaxResponseDto calculateTax(TaxRequestDto request);
}
