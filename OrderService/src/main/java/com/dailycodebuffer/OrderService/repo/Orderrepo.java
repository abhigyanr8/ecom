package com.dailycodebuffer.OrderService.repo;

import com.dailycodebuffer.OrderService.model.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Orderrepo extends CrudRepository<Order,Integer>
{

}
