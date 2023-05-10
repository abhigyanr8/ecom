package com.dailycodebuffer.ProductService.Repo;

import com.dailycodebuffer.ProductService.Modal.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.security.PublicKey;
import java.util.List;

@Repository

public interface ProductRepo extends CrudRepository<Product,Integer>
{
    @Query("select p from Product p where (p.name like %?1%)")
    public List<Product> findProducts(String str);

}
