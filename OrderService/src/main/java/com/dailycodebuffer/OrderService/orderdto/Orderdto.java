package com.dailycodebuffer.OrderService.orderdto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Orderdto
{
    private int id;
    private int productId;
    private int quant;
    private int amount;
    private String paymentType;
    private String status;
}
