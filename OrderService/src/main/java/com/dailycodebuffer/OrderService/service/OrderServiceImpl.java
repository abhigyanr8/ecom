package com.dailycodebuffer.OrderService.service;

import com.dailycodebuffer.OrderService.external.client.PaymentService;
import com.dailycodebuffer.OrderService.external.client.ProductService;
import com.dailycodebuffer.OrderService.external.client.model.PaymentResponse;
import com.dailycodebuffer.OrderService.external.client.model.ProductResponse;
import com.dailycodebuffer.OrderService.model.Order;
import com.dailycodebuffer.OrderService.orderdto.OrderResponse;
import com.dailycodebuffer.OrderService.orderdto.Orderdto;
import com.dailycodebuffer.OrderService.orderdto.Paymentdto;
import com.dailycodebuffer.OrderService.repo.Orderrepo;
import com.dailycodebuffer.OrderService.utrils.ModelMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
@Log4j2
public class OrderServiceImpl implements OrderService
{
    @Autowired
    Orderrepo orderRepo;
    @Autowired
    ModelMapper modelMapper;

    @Autowired
    private ProductService productService;

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private PaymentService paymentService;
    @Override
    public Orderdto createOrder(Orderdto orderdto)
    {
        log.info("Reduce quantity{}",orderdto);
        productService.reduceQuantity(orderdto.getProductId(),orderdto.getQuant());

        orderRepo.save(modelMapper.toEntity(orderdto));
        Order order = modelMapper.toEntity(orderdto);

        Paymentdto paymentdto = new Paymentdto();
        paymentdto.setOrderId(order.getId());
        paymentdto.setAmount(orderdto.getAmount());
        paymentdto.setProductId(orderdto.getProductId());
        paymentdto.setPaymentType(orderdto.getPaymentType());

        paymentService.createpayment(paymentdto);
        log.info("Paymentdto created{}",paymentdto);
        order.setStatus("Payment done");
        orderRepo.save(order);

        return modelMapper.fromEntity(order);
    }

    @Override
    public Orderdto updateOrder(Orderdto orderdto) {
        return null;
    }

    @Override
    public void deleteOrder(int id)
    {
        orderRepo.deleteById(id);

    }

    @Override
    public OrderResponse getOrder(int id)
    {
        Orderdto orderdto = modelMapper.fromEntity(orderRepo.findById(id).get());
        ProductResponse productResponse = restTemplate.getForObject("http://PRODUCTSERVICE/product/"+orderdto.getProductId(),ProductResponse.class);
        log.info("Getting orders By id");
        OrderResponse.ProductDetails productDetails =OrderResponse.ProductDetails.builder()
                .price(productResponse.getPrice()).id(productResponse.getId()).name(productResponse.getName()).quantity(productResponse.getQuantity()).sellerId(productResponse.getSellerId())
        .build();

        log.info("Getting Payment details of the order Id {}",orderdto);
        PaymentResponse paymentResponse = restTemplate.getForObject("http://PAYMENTSERVICE/payment/"+orderdto.getId(),PaymentResponse.class);
        log.info("Payment details are {}",paymentResponse);
        OrderResponse.PaymentDetails paymentDetails = OrderResponse.PaymentDetails.builder().orderId(paymentResponse.getOrderId()).productId(paymentResponse.getProductId()).paymentType(paymentResponse.getPaymentType()).amount(paymentResponse.getAmount()).transactionId(paymentResponse.getTransactionId()).build();

        OrderResponse orderResponse = OrderResponse.builder().quant(orderdto.getQuant()).amount(orderdto.getAmount()).id(orderdto.getId()).paymentType(orderdto.getPaymentType()).status(orderdto.getStatus()).productDetails(productDetails).paymentDetails(paymentDetails).productId(orderdto.getProductId())
                .build();


        return orderResponse;

    }

    @Override
    public List<Orderdto> getAllOrder()
    {
         List<Order> orders=  new ArrayList<Order>();
         List<Orderdto> orderdtos = new ArrayList<>();
         orders = (List<Order>) orderRepo.findAll();

         for(Order o : orders)
         {
             System.out.println(o.toString());
             orderdtos.add(modelMapper.fromEntity(o));
         }
         return orderdtos;
    }
}
