package com.github.diegodigo.scoobyApi.service;

import com.github.diegodigo.scoobyApi.domain.Product;
import com.github.diegodigo.scoobyApi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements BasicCrud<Product, String> {

    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Product> createAll(List<Product> objs) {
        return productRepository.saveAll(objs);
    }

    @Override
    public List<Product> updateAll(List<Product> objs) {
        return productRepository.saveAll(objs);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public Optional<Product> get(String id) {
        return productRepository.findById(id);
    }

    @Override
    public Product create(Product obj) {
        return productRepository.save(obj);
    }

    @Override
    public Product update(Product obj) {
        return productRepository.save(obj);
    }

    @Override
    public void delete(String id) {
        productRepository.deleteById(id);
    }

    @Override
    public Boolean existById(String id) {
        return productRepository.existsById(id);
    }
}
