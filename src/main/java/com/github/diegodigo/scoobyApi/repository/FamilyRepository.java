package com.github.diegodigo.scoobyApi.repository;

import com.github.diegodigo.scoobyApi.domain.Family;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FamilyRepository extends MongoRepository<Family, String> {
}
