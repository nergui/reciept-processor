package com.company.receiptprocessor.rule.impl;

import com.company.receiptprocessor.model.Receipt;
import com.company.receiptprocessor.rule.Rule;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Component
public class AfternoonPurchaseRule implements Rule {
    @Override
    public int process(Receipt receipt) {
        LocalTime time = LocalTime.parse(receipt.getPurchaseTime());
        return (time.getHour() >= 14 && time.getHour() < 16) ? 10 : 0;
    }
}