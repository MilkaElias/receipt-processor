package com.example.receiptprocessor;

import com.example.receiptprocessor.model.Item;
import com.example.receiptprocessor.model.Receipt;
import com.example.receiptprocessor.util.ProcessReceipt;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class ReceiptProcessorApplicationTests {

    List<Item> items1= List.of(new Item("Mountain Dew 12PK", "6.49"),
            new Item("Emils Cheese Pizza","12.25"),
            new Item("Knorr Creamy Chicken", "1.26"),
            new Item("Doritos Nacho Cheese", "3.35"),
            new Item("Klarbrunn 12-PK 12 FL OZ", "12.00"));

    List<Item> items2= List.of(new Item("Gatorade", "2.25"),
            new Item("Gatorade","2.25"),
            new Item("Gatorade", "2.25"),
            new Item("Gatorade", "2.25"));


    Receipt receipt1 = new Receipt("Target","2022-01-01", "13:01",items1,"35.35");
    Receipt receipt2 = new Receipt("M&M Corner Market","2022-03-20", "14:33",items2,"9.00");

    @Test
    public void testAllRulesApply() {
        assertEquals(28, ProcessReceipt.calculatePoints(receipt1));
        assertEquals(109, ProcessReceipt.calculatePoints(receipt2));
    }

}
