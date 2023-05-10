package com.dailycodebuffer.OrderService.orderdto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Paymentdto
{
    private int id;
    private int productId;
    private int orderId;
    private String paymentType;
    private int amount;
}
