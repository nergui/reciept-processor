package com.company.receiptprocessor.repository;

import com.company.receiptprocessor.model.Receipt;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class ReceiptRepository {
    private final Map<String, Receipt> dataStore = new ConcurrentHashMap<>();

    public void save(Receipt receipt) {
        dataStore.put(receipt.getId(), receipt);
    }

    public Optional<Receipt> findById(String id) {
        return Optional.ofNullable(dataStore.get(id));
    }
}