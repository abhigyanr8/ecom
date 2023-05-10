package com.dailycodebuffer.OrderService.external.client;

import com.dailycodebuffer.OrderService.orderdto.Paymentdto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="PAYMENTSERVICE")
public interface PaymentService
{
    @PostMapping("payment")
    void createpayment(@RequestBody Paymentdto paymentdto);
}
