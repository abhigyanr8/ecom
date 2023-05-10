package com.dailycodebuffer.ProductService.Service;

import com.dailycodebuffer.ProductService.DTO.ProductDTO;
import com.dailycodebuffer.ProductService.Modal.Product;
import com.dailycodebuffer.ProductService.Repo.ProductRepo;
import com.dailycodebuffer.ProductService.Utils.ProductMapper;
import jakarta.ws.rs.NotFoundException;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class ProductServiceImpl implements ProductService
{
    @Autowired
    ProductRepo productrepo;

    @Autowired
    ProductMapper productMapper;
    @Override
    public List<ProductDTO> getAllProducts()
    {
         List<Product> products = new ArrayList<Product>();
         products = (List<Product>) productrepo.findAll();

         List<ProductDTO> productsDTO = new ArrayList<ProductDTO>();

         for(Product p:products)
         {
                log.info("Getting data of {}",productMapper.fromEntity(p));
                productsDTO.add(productMapper.fromEntity(p));
         }
         return productsDTO;
    }

    @Override
    public Product createProduct(Product product)
    {
       return productrepo.save(product);
    }

    @Override
    public Optional<Product> getById(int id)
    {
         return productrepo.findById(id);
    }

    @Override
    public List<Product> getProductsSearch(String str)
    {
       return productrepo.findProducts(str);
    }

    @Override
    public void reduceQuantity(int id, int quant)
    {
        Product product = productrepo.findById(id).get();
        product.setQuantity(product.getQuantity()-quant);
        productrepo.save(product);
    }


}
