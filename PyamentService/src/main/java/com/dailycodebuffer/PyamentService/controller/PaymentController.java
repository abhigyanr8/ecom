package com.dailycodebuffer.PyamentService.controller;

import com.dailycodebuffer.PyamentService.dto.Paymentdto;
import com.dailycodebuffer.PyamentService.model.Payment;
import com.dailycodebuffer.PyamentService.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@RestController
public class PaymentController
{
    @Autowired
    PaymentService paymentService;
    @PostMapping("payment")
    void createpayment(@RequestBody Paymentdto paymentdto)
    {
        UUID uuid = UUID.randomUUID();
        Payment payment = new Payment(paymentdto.getId(),paymentdto.getProductId(),paymentdto.getOrderId(),paymentdto.getPaymentType(),paymentdto.getAmount(),uuid);
        paymentService.createPayment(payment);
    }
    @GetMapping("payment/{productId}")
    Payment getPayment(@PathVariable int productId)
    {
         return paymentService.getPayment(productId);
    }
}
