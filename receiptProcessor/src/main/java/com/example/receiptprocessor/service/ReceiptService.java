package com.example.receiptprocessor.service;

import com.example.receiptprocessor.model.Receipt;
import com.example.receiptprocessor.util.ProcessReceipt;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class ReceiptService {
    private final Map<String, Integer> points=new HashMap<>();

    public String processReceipt(Receipt receipt) {
        int point= ProcessReceipt.calculatePoints(receipt);
        String id= UUID.randomUUID().toString();
        points.put(id,point);
        return id;
    }

    public Integer getPoints(String id) {
        return points.getOrDefault(id,null);
    }
}
