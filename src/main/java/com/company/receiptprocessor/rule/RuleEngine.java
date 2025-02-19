package com.company.receiptprocessor.rule;

import com.company.receiptprocessor.model.Receipt;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RuleEngine {
    private final List<Rule> rules;

    public int processReceipt(Receipt receipt) {
        return rules.stream()
                .mapToInt(rule -> rule.process(receipt))
                .sum();
    }
}