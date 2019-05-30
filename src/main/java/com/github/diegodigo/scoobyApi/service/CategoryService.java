package com.github.diegodigo.scoobyApi.service;

import com.github.diegodigo.scoobyApi.domain.Category;
import com.github.diegodigo.scoobyApi.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService implements BasicCrud<Category, String> {

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<Category> createAll(List<Category> objs) {
        return categoryRepository.saveAll(objs);
    }

    @Override
    public List<Category> updateAll(List<Category> objs) {
        return categoryRepository.saveAll(objs);
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Page<Category> findAll(Pageable pageable) {
        return categoryRepository.findAll(pageable);
    }

    @Override
    public Optional<Category> get(String id) {
        return categoryRepository.findById(id);
    }

    @Override
    public Category create(Category obj) {
        return categoryRepository.save(obj);
    }

    @Override
    public Category update(Category obj) {
        return categoryRepository.save(obj);
    }

    @Override
    public void delete(String id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public Boolean existById(String id) {
        return categoryRepository.existsById(id);
    }
}
