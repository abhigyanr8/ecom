package com.dailycodebuffer.OrderService.service;

import com.dailycodebuffer.OrderService.orderdto.OrderResponse;
import com.dailycodebuffer.OrderService.orderdto.Orderdto;

import java.util.List;

public interface OrderService
{
      public Orderdto createOrder(Orderdto orderdto);
      public Orderdto updateOrder(Orderdto orderdto);
      public void deleteOrder(int id);
      public OrderResponse getOrder(int id);
      public List<Orderdto> getAllOrder();

}
