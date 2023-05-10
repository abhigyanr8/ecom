package com.dailycodebuffer.OrderService.external.client.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponse
{
    private int id;
    private String name;
    private int price;
    private int sellerId;
    private int quantity;
}
