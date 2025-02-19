package com.company.receiptprocessor.rule.impl;

import com.company.receiptprocessor.model.Receipt;
import com.company.receiptprocessor.rule.Rule;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class OddDayRule implements Rule {
    @Override
    public int process(Receipt receipt) {
        LocalDate date = LocalDate.parse(receipt.getPurchaseDate());
        return date.getDayOfMonth() % 2 == 1 ? 6 : 0;
    }
}