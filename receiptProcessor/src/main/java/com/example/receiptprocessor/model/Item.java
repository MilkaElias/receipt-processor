package com.example.receiptprocessor.model;

import lombok.Data;

@Data
public class Item {
    private String shortDescription;
    private double price;

    public String getShortDescription() {return shortDescription;}
    public double getPrice() {return price;}
}
