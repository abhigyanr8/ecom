package com.dailycodebuffer.PyamentService.service;

import com.dailycodebuffer.PyamentService.dto.Paymentdto;
import com.dailycodebuffer.PyamentService.model.Payment;


public interface PaymentService
{
     public void createPayment(Payment paymentdto);
     public Payment getPayment(int id);
}
