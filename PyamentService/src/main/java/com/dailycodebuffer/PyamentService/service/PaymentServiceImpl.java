package com.dailycodebuffer.PyamentService.service;

import com.dailycodebuffer.PyamentService.dto.Paymentdto;
import com.dailycodebuffer.PyamentService.model.Payment;
import com.dailycodebuffer.PyamentService.repo.PaymentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PaymentServiceImpl implements PaymentService
{
    @Autowired
    PaymentRepo paymentRepo;
    @Override
    public void createPayment(Payment payment)
    {
          paymentRepo.save(payment);

    }
    public Payment getPayment(int orderId)
    {
        return paymentRepo.findByOrderId(orderId);
    }
}
