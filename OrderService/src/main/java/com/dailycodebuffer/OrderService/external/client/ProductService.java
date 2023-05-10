package com.dailycodebuffer.OrderService.external.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="PRODUCTSERVICE")
public interface ProductService
{
    @PutMapping("/reduce-quantity/{id}")
    public void reduceQuantity(@PathVariable int id, @RequestParam int quant);
}
