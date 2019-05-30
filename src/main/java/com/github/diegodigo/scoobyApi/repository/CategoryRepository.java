package com.github.diegodigo.scoobyApi.repository;

import com.github.diegodigo.scoobyApi.domain.Category;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends MongoRepository<Category, String> {
}
