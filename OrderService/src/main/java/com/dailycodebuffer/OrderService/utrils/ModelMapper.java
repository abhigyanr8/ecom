package com.dailycodebuffer.OrderService.utrils;

import com.dailycodebuffer.OrderService.model.Order;
import com.dailycodebuffer.OrderService.orderdto.Orderdto;
import org.springframework.stereotype.Service;

@Service
public class ModelMapper implements Mapper<Orderdto, Order>
{

    @Override
    public Order toEntity(Orderdto orderdto)
    {
        Order order = new Order(orderdto.getId(),orderdto.getProductId(),orderdto.getQuant(),orderdto.getAmount(),orderdto.getPaymentType(),orderdto.getStatus());
        return order;
    }

    @Override
    public Orderdto fromEntity(Order order)
    {
       Orderdto orderdto = new Orderdto(order.getId(), order.getProductId(), order.getQuant(), order.getAmount(), order.getPaymentType(), order.getStatus());
       return orderdto;
    }
}
