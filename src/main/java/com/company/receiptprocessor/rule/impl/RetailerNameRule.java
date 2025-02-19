package com.company.receiptprocessor.rule.impl;

import com.company.receiptprocessor.model.Receipt;
import com.company.receiptprocessor.rule.Rule;
import org.springframework.stereotype.Component;

@Component
public class RetailerNameRule implements Rule {
    @Override
    public int process(Receipt receipt) {
        return (int) receipt.getRetailer().chars()
                .filter(c -> Character.isLetterOrDigit(c))
                .count();
    }
}