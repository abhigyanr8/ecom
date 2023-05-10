package com.dailycodebuffer.ProductService.Utils;

import com.dailycodebuffer.ProductService.DTO.ProductDTO;
import com.dailycodebuffer.ProductService.Modal.Product;
import org.springframework.stereotype.Service;

@Service
public class ProductMapper implements Mapper<ProductDTO, Product>
{

    @Override
    public Product toEntity(ProductDTO domain)
    {
       Product product = new Product(domain.getId(),domain.getName(),domain.getPrice(),domain.getSellerId(),domain.getQuantity());
       return product;
    }

    @Override
    public ProductDTO fromEntity(Product entity)
    {
        return new ProductDTO(entity.getId(),entity.getName(),entity.getPrice(),entity.getSellerId(),entity.getQuantity());
    }
}
