package com.company.receiptprocessor.rule.impl;

import com.company.receiptprocessor.model.Receipt;
import com.company.receiptprocessor.rule.Rule;
import org.springframework.stereotype.Component;

@Component
public class RoundDollarTotalRule implements Rule {
    @Override
    public int process(Receipt receipt) {
        return receipt.getTotal().endsWith(".00") ? 50 : 0;
    }
}