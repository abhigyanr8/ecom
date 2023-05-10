package com.dailycodebuffer.ProductService.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO
{
    private int id;
    private String name;
    private int price;
    private int sellerId;
    private int quantity;

}
