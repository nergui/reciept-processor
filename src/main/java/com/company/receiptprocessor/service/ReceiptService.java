package com.company.receiptprocessor.service;

import com.company.receiptprocessor.dto.ReceiptDto;
import com.company.receiptprocessor.model.Receipt;
import com.company.receiptprocessor.repository.ReceiptRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ReceiptService {
    private final ReceiptRepository receiptRepository;
    private final ReceiptProcessingService processingService;

    public String   submitReceipt(ReceiptDto receiptDto) {
        // Convert DTO to model
        Receipt receipt = new Receipt();
        receipt.setId(UUID.randomUUID().toString());
        receipt.setRetailer(receiptDto.getRetailer());
        receipt.setPurchaseDate(receiptDto.getPurchaseDate());
        receipt.setPurchaseTime(receiptDto.getPurchaseTime());
        receipt.setTotal(receiptDto.getTotal());
        receipt.setItems(receiptDto.getItems());
        receipt.setProcessed(false);

        // Save receipt with pending status
        receiptRepository.save(receipt);

        // Submit for async processing
        processingService.processReceiptAsync(receipt);

        return receipt.getId();
    }

    public Optional<Receipt> getReceipt(String id) {
        return receiptRepository.findById(id);
    }
}