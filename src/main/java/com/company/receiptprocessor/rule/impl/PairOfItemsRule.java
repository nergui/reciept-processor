package com.company.receiptprocessor.rule.impl;

import com.company.receiptprocessor.model.Receipt;
import com.company.receiptprocessor.rule.Rule;
import org.springframework.stereotype.Component;

@Component
public class PairOfItemsRule implements Rule {
    @Override
    public int process(Receipt receipt) {
        return (receipt.getItems().size() / 2) * 5;
    }
}