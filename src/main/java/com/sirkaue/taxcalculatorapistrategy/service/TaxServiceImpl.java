package com.sirkaue.taxcalculatorapistrategy.service;

import com.sirkaue.taxcalculatorapistrategy.domain.TaxType;
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

    @Override
    public double execute(TaxType taxType, double amount) {
        log.info("Recebida solicitação para cálculo de imposto: Tipo={}, Valor={}", taxType, amount);
        context.setStrategy(taxType);
        log.info("Estratégia de imposto definida com sucesso: Tipo={}", taxType);

        double taxValue = context.calculate(amount);
        log.info("Imposto calculado com sucesso: Tipo={}, Valor Base={}, Imposto Calculado={}",
                taxType, amount, taxValue);
        return taxValue;
    }
}
