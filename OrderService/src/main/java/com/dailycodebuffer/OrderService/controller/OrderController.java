package com.dailycodebuffer.OrderService.controller;

import com.dailycodebuffer.OrderService.model.Order;
import com.dailycodebuffer.OrderService.orderdto.OrderResponse;
import com.dailycodebuffer.OrderService.orderdto.Orderdto;
import com.dailycodebuffer.OrderService.service.OrderService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Log4j2
@RestController
public class OrderController
{
       @Autowired
       OrderService orderService;
       @PostMapping("order")
       public Orderdto createOrder(@RequestBody Orderdto orderdto)
       {
           log.info("creating Order {}",orderdto);
           return orderService.createOrder(orderdto);
       }
       @GetMapping("orders")
       public List<Orderdto> getAllOrders()
       {
           return orderService.getAllOrder();
       }

       @GetMapping("order/{id}")
       public OrderResponse getOrderById(@PathVariable int id)
       {
           log.info("Inside the rest call");
           return orderService.getOrder(id);
       }
       @DeleteMapping("order/{id}")
       public void deleteBYId(@PathVariable int id)
       {
            orderService.deleteOrder(id);
       }
}
