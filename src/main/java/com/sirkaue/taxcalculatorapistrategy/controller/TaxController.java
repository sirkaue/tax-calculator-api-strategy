package com.sirkaue.taxcalculatorapistrategy.controller;

import com.sirkaue.taxcalculatorapistrategy.dto.TaxRequestDto;
import com.sirkaue.taxcalculatorapistrategy.dto.TaxResponseDto;
import com.sirkaue.taxcalculatorapistrategy.service.TaxService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/tax")
public class TaxController {
    private final TaxService taxService;

    public TaxController(TaxService taxService) {
        this.taxService = taxService;
    }

    @PostMapping("/calculate")
    public TaxResponseDto calculateTax(@RequestBody TaxRequestDto request) {
        return taxService.calculateTax(request);
    }
}
