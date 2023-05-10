package com.dailycodebuffer.OrderService.orderdto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderResponse
{

    private int id;
    private int productId;
    private int quant;
    private int amount;
    private String paymentType;
    private String status;
    private ProductDetails productDetails;
    private PaymentDetails paymentDetails;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class ProductDetails
    {
        private int id;
        private String name;
        private int price;
        private int sellerId;
        private int quantity;
    }
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class PaymentDetails
    {
        private int id;
        private int productId;
        private int orderId;
        private String paymentType;
        private int amount;
        private UUID transactionId;
    }

}
