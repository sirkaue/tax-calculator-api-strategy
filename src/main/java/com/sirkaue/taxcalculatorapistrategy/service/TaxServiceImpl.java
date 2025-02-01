package com.sirkaue.taxcalculatorapistrategy.service;

import com.sirkaue.taxcalculatorapistrategy.dto.TaxRequestDto;
import com.sirkaue.taxcalculatorapistrategy.dto.TaxResponseDto;
import com.sirkaue.taxcalculatorapistrategy.strategy.ICMSStrategy;
import com.sirkaue.taxcalculatorapistrategy.strategy.IRStrategy;
import com.sirkaue.taxcalculatorapistrategy.strategy.ISSStrategy;
import com.sirkaue.taxcalculatorapistrategy.strategy.TaxStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class TaxServiceImpl implements TaxService {

    private static final Logger log = LoggerFactory.getLogger(TaxServiceImpl.class);
    private final Map<String, TaxStrategy> strategies = new HashMap<>();

    public TaxServiceImpl() {
        strategies.put("ICMS", new ICMSStrategy());
        strategies.put("ISS", new ISSStrategy());
        strategies.put("IR", new IRStrategy());
    }

    public TaxResponseDto calculateTax(TaxRequestDto request) {
        log.info("Recebida solicitação para cálculo de imposto: Tipo={}, Valor={}", request.taxType(), request.amount());

        TaxStrategy strategy = strategies.get(request.taxType());

        if (strategy == null) {
            log.error("Erro: Tipo de imposto inválido: {}", request.taxType());
            throw new IllegalArgumentException("Tipo de imposto inválido!");
        }

        Double taxValue = strategy.calculateTax(request.amount());

        log.info("Imposto calculado com sucesso: Tipo={}, Valor Base={}, Imposto Calculado={}",
                request.taxType(), request.amount(), taxValue);

        return new TaxResponseDto(request.taxType(), request.amount(), taxValue);
    }
}
