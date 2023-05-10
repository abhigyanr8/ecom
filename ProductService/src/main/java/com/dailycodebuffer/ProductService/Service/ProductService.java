package com.dailycodebuffer.ProductService.Service;

import com.dailycodebuffer.ProductService.DTO.ProductDTO;
import com.dailycodebuffer.ProductService.Modal.Product;

import java.util.List;
import java.util.Optional;


public interface ProductService
{

     List<ProductDTO> getAllProducts();
     Product createProduct(Product product);
     Optional<Product> getById(int id);
     List<Product> getProductsSearch(String str);
     void reduceQuantity(int id,int quant);
}
