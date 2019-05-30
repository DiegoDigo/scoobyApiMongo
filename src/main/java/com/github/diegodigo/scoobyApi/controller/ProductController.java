package com.github.diegodigo.scoobyApi.controller;

import com.github.diegodigo.scoobyApi.domain.Product;
import com.github.diegodigo.scoobyApi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("all")
    public ResponseEntity<?> getAll() {
        List<Product> products = productService.findAll();
        if (products.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(products);
    }

    @GetMapping
    public ResponseEntity<?> getAll(Pageable pageable) {
        Page<Product> products = productService.findAll(pageable);
        if (products.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(products);
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody Product product) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.create(product));
    }

    @PutMapping
    public ResponseEntity<?> update(@Valid @RequestBody Product product) {
        if (productService.existById(product.getId())) {
            return ResponseEntity.status(HttpStatus.CREATED).body(productService.update(product));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable("id") String id) {
        if (productService.existById(id)) {
            productService.delete(id);
            return ResponseEntity.status(HttpStatus.ACCEPTED).build();
        }
        return ResponseEntity.notFound().build();
    }
}
