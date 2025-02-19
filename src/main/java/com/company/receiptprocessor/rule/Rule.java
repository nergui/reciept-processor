package com.company.receiptprocessor.rule;

import com.company.receiptprocessor.model.Receipt;

public interface Rule {
    int process(Receipt receipt);
}