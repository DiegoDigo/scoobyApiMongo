package com.github.diegodigo.scoobyApi.service;

import com.github.diegodigo.scoobyApi.domain.Brand;
import com.github.diegodigo.scoobyApi.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BrandService implements BasicCrud<Brand, String> {

    @Autowired
    BrandRepository brandRepository;

    @Override
    public List<Brand> createAll(List<Brand> objs) {
        return brandRepository.saveAll(objs);
    }

    @Override
    public List<Brand> updateAll(List<Brand> objs) {
        return brandRepository.saveAll(objs);
    }

    @Override
    public List<Brand> findAll() {
        return brandRepository.findAll();
    }

    @Override
    public Page<Brand> findAll(Pageable pageable) {
        return brandRepository.findAll(pageable);
    }

    @Override
    public Optional<Brand> get(String id) {
        return brandRepository.findById(id);
    }

    @Override
    public Brand create(Brand obj) {
        return brandRepository.save(obj);
    }

    @Override
    public Brand update(Brand obj) {
        return brandRepository.save(obj);
    }

    @Override
    public void delete(String id) {
        brandRepository.deleteById(id);
    }

    @Override
    public Boolean existById(String id) {
        return brandRepository.existsById(id);
    }
}
