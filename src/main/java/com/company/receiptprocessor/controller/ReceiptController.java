package com.company.receiptprocessor.controller;

import com.company.receiptprocessor.dto.PointsResponseDto;
import com.company.receiptprocessor.dto.ReceiptDto;
import com.company.receiptprocessor.model.Receipt;
import com.company.receiptprocessor.service.ReceiptService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/receipts")
@RequiredArgsConstructor
public class ReceiptController {
    private final ReceiptService receiptService;

    @PostMapping("/process")
    public ResponseEntity<Map<String, String>> processReceipt(@Valid @RequestBody ReceiptDto receiptDto) {
        String id = receiptService.submitReceipt(receiptDto);
        return ResponseEntity.ok(Map.of("id", id));
    }

    @GetMapping("/{id}/points")
    public ResponseEntity<?> getPoints(@PathVariable String id) {
        Optional<Receipt> receiptOpt = receiptService.getReceipt(id);

        if (receiptOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Receipt receipt = receiptOpt.get();
        if (!receipt.isProcessed()) {
            return ResponseEntity.status(HttpStatus.ACCEPTED)
                    .body(Map.of("message", "Receipt processing is still in progress"));
        }

        return ResponseEntity.ok(new PointsResponseDto(receipt.getPoints()));
    }
}