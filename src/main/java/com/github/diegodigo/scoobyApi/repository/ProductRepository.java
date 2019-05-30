package com.github.diegodigo.scoobyApi.repository;

import com.github.diegodigo.scoobyApi.domain.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
}
