package com.sirkaue.taxcalculatorapistrategy.controller;

import com.sirkaue.taxcalculatorapistrategy.dto.TaxRequest;
import com.sirkaue.taxcalculatorapistrategy.dto.TaxResponse;
import com.sirkaue.taxcalculatorapistrategy.service.TaxService;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<TaxResponse> calculateTax(@RequestBody TaxRequest request) {
        double taxValue = taxService.execute(request.taxType(), request.amount());

        TaxResponse body = new TaxResponse(
                request.taxType(),
                request.amount(),
                taxValue
        );

        return ResponseEntity.ok(body);
    }
}
