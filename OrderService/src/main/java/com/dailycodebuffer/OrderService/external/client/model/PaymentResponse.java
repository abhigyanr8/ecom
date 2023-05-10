package com.dailycodebuffer.OrderService.external.client.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentResponse
{
    private int id;
    private int productId;
    private int orderId;
    private String paymentType;
    private int amount;
    private UUID transactionId;
}
