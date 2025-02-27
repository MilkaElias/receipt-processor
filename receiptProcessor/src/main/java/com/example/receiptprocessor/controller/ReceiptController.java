package com.example.receiptprocessor.controller;

import com.example.receiptprocessor.model.Receipt;
import com.example.receiptprocessor.service.ReceiptService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/receipts")
public class ReceiptController {

    private ReceiptService receiptService;

    public ReceiptController(ReceiptService receiptService){
        this.receiptService=receiptService;
    }

    @PostMapping("/process")
    public ResponseEntity<?> processReceipt(@RequestBody Receipt receipt){
        String id= receiptService.processReceipt(receipt);
        return ResponseEntity.ok(Map.of("id:", id));
    }

    @GetMapping("/{id}/points")
    public ResponseEntity<?> getPoints(@PathVariable String id){
        Integer points= receiptService.getPoints(id);
        if(points==null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(Map.of("points", points));
    }

}
