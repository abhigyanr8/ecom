package com.dailycodebuffer.ProductService.Controller;

import com.dailycodebuffer.ProductService.DTO.ProductDTO;
import com.dailycodebuffer.ProductService.Modal.Product;
import com.dailycodebuffer.ProductService.Service.ProductService;
import com.dailycodebuffer.ProductService.Service.ProductServiceImpl;
import com.dailycodebuffer.ProductService.Utils.ProductMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("product")
@Log4j2
public class ProductController
{
    @Autowired
    ProductServiceImpl productServiceImpl;
    @Autowired
    ProductMapper productMapper;

    @PostMapping("product")
    Product craeteProduct(@RequestBody Product product)
    {
        return productServiceImpl.createProduct(product);
    }
    @GetMapping("{id}")
    Product getProductById(@PathVariable int id)
    {
          return productServiceImpl.getById(id).get();
    }

    @GetMapping("products")
    List<ProductDTO> getAllProducts()
    {
        log.info("Getting all products ");
        return productServiceImpl.getAllProducts();
    }

    @GetMapping("/product-search/{str}")
    List<ProductDTO> getAllProductsSearch(@PathVariable String str)
    {
        List<ProductDTO> productsDTO = new ArrayList<ProductDTO>();
        List<Product> products = new ArrayList<Product>();
        products =  productServiceImpl.getProductsSearch(str);
        for(Product p:products)
        {
            productsDTO.add(productMapper.fromEntity(p));
        }
        return productsDTO;
    }
    @PutMapping("/reduce-quantity/{id}")
    public void reduceQuantity(@PathVariable int id,@RequestParam int quant)
    {
        productServiceImpl.reduceQuantity(id,quant);
    }
}
