package com.company.receiptprocessor.dto;

import com.company.receiptprocessor.model.Item;
import lombok.Data;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import java.util.List;

@Data
public class ReceiptDto {
    @NotBlank(message = "Retailer name is required")
    @Pattern(regexp = "^[\\w\\s\\-&]+$", message = "Retailer name contains invalid characters")
    private String retailer;

    @NotBlank(message = "Purchase date is required")
    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$", message = "Invalid purchase date format (YYYY-MM-DD)")
    private String purchaseDate;

    @NotBlank(message = "Purchase time is required")
    @Pattern(regexp = "^\\d{2}:\\d{2}$", message = "Invalid purchase time format (HH:MM in 24-hr)")
    private String purchaseTime;

    @NotBlank(message = "Total is required")
    @Pattern(regexp = "^\\d+\\.\\d{2}$", message = "Invalid total format (##.##)")
    private String total;

    @NotEmpty(message = "Items are required")
    private List<Item> items;
}