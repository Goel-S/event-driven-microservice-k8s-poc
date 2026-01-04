package com.example.product_service.adapter.out;

import com.example.product_service.domain.ProductRepository;
import org.springframework.stereotype.Repository;
import com.example.product_service.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class ProductJpaRepository implements ProductRepository {

    private final SpringDataProductRepository jpaRepo;

    public ProductJpaRepository(SpringDataProductRepository jpaRepo) {
        this.jpaRepo = jpaRepo;
    }

    @Override
    public Product save(Product product) {
        return jpaRepo.save(product);
    }

    @Override
    public Optional<Product> findById(Long id) {
        return jpaRepo.findById(id);
    }
}