package com.example.receiptprocessor.model;

import lombok.Data;

@Data
public class Item {
    private String shortDescription;
    private String price;

    public Item(String shortDescription, String price) {
        this.shortDescription = shortDescription;
        this.price = price;
    }

    public String getShortDescription() {return shortDescription;}
    public String getPrice() {return price;}
}
