package com.example.product_service.adapter.in;

import com.example.product_service.application.CreateProductUseCase;
import com.example.product_service.application.GetProductUseCase;
import com.example.product_service.domain.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final CreateProductUseCase createUseCase;
    private final GetProductUseCase getUseCase;

    public ProductController(CreateProductUseCase createUseCase,
                             GetProductUseCase getUseCase) {
        this.createUseCase = createUseCase;
        this.getUseCase = getUseCase;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> get(@PathVariable Long id) {
        return getUseCase.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Product createProduct(@RequestBody CreateProductRequest request) {
        return createUseCase.create(
                request.getName(),
                request.getPrice()
        );
    }
}
