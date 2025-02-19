package com.company.receiptprocessor.service;

import com.company.receiptprocessor.model.Receipt;
import com.company.receiptprocessor.repository.ReceiptRepository;
import com.company.receiptprocessor.rule.RuleEngine;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ReceiptProcessingService {
    private final RuleEngine ruleEngine;
    private final ReceiptRepository receiptRepository;

    @Async
    public void processReceiptAsync(Receipt receipt) {
        try {
            // Process receipt through rule engine
            int points = ruleEngine.processReceipt(receipt);

            // Update receipt with points and mark as processed
            receipt.setPoints(points);
            receipt.setProcessed(true);
            receiptRepository.save(receipt);

            log.info("Receipt {} processed with {} points", receipt.getId(), points);
        } catch (Exception e) {
            log.error("Error processing receipt {}: {}", receipt.getId(), e.getMessage());
        }
    }
}