package com.dailycodebuffer.ProductService.Controller;

import com.dailycodebuffer.ProductService.DTO.ProductDTO;
import com.dailycodebuffer.ProductService.Modal.Product;
import com.dailycodebuffer.ProductService.Service.ProductService;
import com.dailycodebuffer.ProductService.Utils.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController
{
    @Autowired
    ProductService productService;
    @Autowired
    ProductMapper productMapper;

    @PostMapping("/product")
    Product craeteProduct(@RequestBody Product product)
    {
        return productService.createProduct(product);
    }
    @GetMapping("/product/{id}")
    Product getProductById(@PathVariable int id)
    {
          return productService.getById(id).get();
    }

    @GetMapping("/products")
    List<ProductDTO> getAllProducts()
    {
         return productService.getAllProducts();
    }

    @GetMapping("/product-search/{str}")
    List<ProductDTO> getAllProductsSearch(@PathVariable String str)
    {
        List<ProductDTO> productsDTO = new ArrayList<ProductDTO>();
        List<Product> products = new ArrayList<Product>();
        products =  productService.getProductsSearch(str);
        for(Product p:products)
        {
            productsDTO.add(productMapper.fromEntity(p));
        }
        return productsDTO;
    }
    @PutMapping("/reduce-quantity/{id}")
    public void reduceQuantity(@PathVariable int id,@RequestParam int quant)
    {
        productService.reduceQuantity(id,quant);
    }
}
