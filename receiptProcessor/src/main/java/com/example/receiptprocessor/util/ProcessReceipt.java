package com.example.receiptprocessor.util;

import com.example.receiptprocessor.model.Item;
import com.example.receiptprocessor.model.Receipt;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalTime;
import java.util.List;

public class ProcessReceipt {
    public static Integer calculatePoints(Receipt receipt){
        int points=0;
        points +=alphanumericRetailerName(receipt.getRetailer());
        points +=roundDollarTotal(receipt.getTotal());
        points +=multipleOfQuarter(receipt.getTotal());
        points +=everyTwoItems(receipt.getItems());
        points +=oddPurchaseDate(receipt.getPurchaseDate());
        points +=timeBetween2PMAnd4PM(receipt.getPurchaseTime());
        points +=pointsBasedOnItemDescription(receipt.getItems());

        return points;
    }


    private static int alphanumericRetailerName(String retailer){
        return retailer.replaceAll("[^a-zA-Z0-9]", "").length();
    }

    private static int roundDollarTotal(String total){
        BigDecimal totalValue= new BigDecimal(total);
        return (totalValue.stripTrailingZeros().scale() <=0) ? 50 : 0;
    }

    private static int multipleOfQuarter(String total){
        BigDecimal totalValue= new BigDecimal(total);
        return (totalValue.remainder(new BigDecimal("0.25")).compareTo(BigDecimal.ZERO)==0) ? 25:0;
    }

    private static int everyTwoItems(List<Item> items){
        return items.size()/2 * 5;
    }

    private static int oddPurchaseDate(String purchaseDate){
        int day=Integer.parseInt(purchaseDate.split("-")[2]);
        return (day % 2 !=0) ? 6 :0;
    }

    private static int timeBetween2PMAnd4PM(String purchaseTime){
        LocalTime time= LocalTime.parse(purchaseTime);
        return time.isAfter(LocalTime.of(14,0)) && time.isBefore(LocalTime.of(16,0)) ? 10 : 0;
    }

    private static int pointsBasedOnItemDescription(List<Item> items){
        int point=0;
        for(Item item:items){
            String description= item.getShortDescription().trim();
            if(description.length() %3 ==0){
                BigDecimal itemPrice= new BigDecimal(item.getPrice());
                point += itemPrice.multiply(new BigDecimal(0.2)).setScale(0,RoundingMode.UP).intValue();
            }
        }
        return point;
    }
}
