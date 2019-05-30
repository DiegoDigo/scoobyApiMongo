package com.github.diegodigo.scoobyApi.repository;

import com.github.diegodigo.scoobyApi.domain.Brand;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends MongoRepository<Brand, String> {
}
