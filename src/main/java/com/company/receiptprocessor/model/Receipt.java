package com.company.receiptprocessor.model;

import lombok.Data;

import java.util.List;

@Data
public class Receipt {
    private String id;
    private String retailer;
    private String purchaseDate;
    private String purchaseTime;
    private String total;
    private List<Item> items;
    private Integer points;
    private boolean processed;
}