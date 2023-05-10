package com.dailycodebuffer.PyamentService.repo;

import com.dailycodebuffer.PyamentService.model.Payment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepo extends CrudRepository<Payment,Integer>
{
        Payment findByOrderId(int id);
}
