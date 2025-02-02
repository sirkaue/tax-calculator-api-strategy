package com.sirkaue.taxcalculatorapistrategy.service;

import com.sirkaue.taxcalculatorapistrategy.dto.TaxRequestDto;
import com.sirkaue.taxcalculatorapistrategy.dto.TaxResponseDto;
import com.sirkaue.taxcalculatorapistrategy.strategy.context.TaxContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class TaxServiceImpl implements TaxService {

    private static final Logger log = LoggerFactory.getLogger(TaxServiceImpl.class);
    private final TaxContext context;

    public TaxServiceImpl(TaxContext context) {
        this.context = context;
    }

    public TaxResponseDto calculateTax(TaxRequestDto request) {
        log.info("Recebida solicitação para cálculo de imposto: Tipo={}, Valor={}", request.taxType(), request.amount());
        context.setStrategy(request.taxType());
        log.info("Estratégia de imposto definida com sucesso: Tipo={}", request.taxType());

        Double taxValue = context.calculateTax(request.amount());
        log.info("Imposto calculado com sucesso: Tipo={}, Valor Base={}, Imposto Calculado={}",
                request.taxType(), request.amount(), taxValue);
        return new TaxResponseDto(request.taxType(), request.amount(), taxValue);
    }
}
