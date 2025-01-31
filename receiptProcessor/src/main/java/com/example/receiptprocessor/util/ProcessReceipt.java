package com.example.receiptprocessor.util;

import com.example.receiptprocessor.model.Item;
import com.example.receiptprocessor.model.Receipt;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalTime;

public class ProcessReceipt {
    public static Integer calculatePoints(Receipt receipt){
        int points=0;

        //1 point for each alphanumeric character in the retailer name
        points += receipt.getRetailer().replaceAll("[^a-zA-Z0-9]", "").length();

        //50 points if the total os a round dollar amount with no cents
        BigDecimal total= new BigDecimal(receipt.getTotal());
        if(total.stripTrailingZeros().scale() <=0) points += 50;

        //25 points if the total is a multiple of 0.25
        if(total.remainder(new BigDecimal("0.25")).compareTo(BigDecimal.ZERO)==0) points+=25;

        //5 points for every two items on the receipt
        points += (receipt.getItems().size()/2) * 5;

        //6 points if the date of purchase is odd
        int day=Integer.parseInt(receipt.getPurchaseDate().split("-")[2]);
        if(day % 2 !=0) points+=6;

        //10 points if the time of purchase is between 2PM and 4PM
        LocalTime time= LocalTime.parse(receipt.getPurchaseTime());
        if(time.isAfter(LocalTime.of(14,0)) && time.isBefore(LocalTime.of(16,0))) points += 10;


        //points based on item description
        for(Item item: receipt.getItems()){
            String description= item.getShortDescription().trim();
            if(description.length() %3 ==0){
                BigDecimal itemPrice= new BigDecimal(item.getPrice());
                points += itemPrice.multiply(new BigDecimal(0.2)).setScale(0,RoundingMode.UP).intValue();
            }
        }


        return points;
    }
}
