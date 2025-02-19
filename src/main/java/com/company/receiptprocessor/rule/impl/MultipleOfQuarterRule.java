package com.company.receiptprocessor.rule.impl;

import com.company.receiptprocessor.model.Receipt;
import com.company.receiptprocessor.rule.Rule;
import org.springframework.stereotype.Component;

@Component
public class MultipleOfQuarterRule implements Rule {
    @Override
    public int process(Receipt receipt) {
        double total = Double.parseDouble(receipt.getTotal());
        return (total * 4) % 1 == 0 ? 25 : 0;
    }
}