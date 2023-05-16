package com.dailycodebuffer.OrderService.controller;

import com.dailycodebuffer.OrderService.model.Order;
import com.dailycodebuffer.OrderService.orderdto.OrderResponse;
import com.dailycodebuffer.OrderService.orderdto.Orderdto;
import com.dailycodebuffer.OrderService.service.OrderService;
import com.dailycodebuffer.OrderService.service.OrderServiceImpl;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Log4j2
@RestController
@RequestMapping("/order")
public class OrderController
{
       @Autowired
       OrderServiceImpl orderServiceImpl;
       @PostMapping("")
       public Orderdto createOrder(@RequestBody Orderdto orderdto)
       {
           log.info("creating Order {}",orderdto);
           return orderServiceImpl.createOrder(orderdto);
       }
       @GetMapping("")
       public List<Orderdto> getAllOrders()
       {
           return orderServiceImpl.getAllOrder();
       }

       @GetMapping("{id}")
       public OrderResponse getOrderById(@PathVariable int id)
       {
           log.info("Inside the rest call");
           return orderServiceImpl.getOrder(id);
       }
       @DeleteMapping("{id}")
       public void deleteBYId(@PathVariable int id)
       {
            orderServiceImpl.deleteOrder(id);
       }
}
