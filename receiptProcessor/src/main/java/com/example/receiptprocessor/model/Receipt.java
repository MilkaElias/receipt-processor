package com.example.receiptprocessor.model;

import lombok.Data;
import java.util.List;

@Data
public class Receipt {
    private String retailer;
    private String purchaseDate;
    private String purchaseTime;
    private List<Item> items;
    private String total;

    public Receipt(String retailer, String purchaseDate, String purchaseTime, List<Item> items, String total) {
        this.retailer = retailer;
        this.purchaseDate = purchaseDate;
        this.purchaseTime = purchaseTime;
        this.items = items;
        this.total = total;
    }

    public String getRetailer() {return retailer;}
    public String getPurchaseDate() {return purchaseDate;}
    public String getPurchaseTime() {return purchaseTime;}
    public List<Item> getItems() {return items;}
    public String getTotal() {return total;}

}
