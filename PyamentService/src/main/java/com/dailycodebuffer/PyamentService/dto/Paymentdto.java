package com.dailycodebuffer.PyamentService.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

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
