package com.company.receiptprocessor.rule.impl;

import com.company.receiptprocessor.model.Item;
import com.company.receiptprocessor.model.Receipt;
import com.company.receiptprocessor.rule.Rule;
import org.springframework.stereotype.Component;

@Component
public class MultipleOfThreeItemDescriptionRule implements Rule {
    @Override
    public int process(Receipt receipt) {
        int points = 0;
        for (Item item : receipt.getItems()) {
            // Only count letters and numbers, not spaces or hyphens
            String desc = item.getShortDescription().replaceAll("[^a-zA-Z0-9]", "");
            if (desc.length() % 3 == 0) {
                double price = Double.parseDouble(item.getPrice());
                points += (int) Math.ceil(price * 0.2);
            }
        }
        return points;
    }
}