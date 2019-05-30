package com.github.diegodigo.scoobyApi.service;

import com.github.diegodigo.scoobyApi.domain.Family;
import com.github.diegodigo.scoobyApi.repository.FamilyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FamilyService implements BasicCrud<Family, String> {

    @Autowired
    FamilyRepository familyRepository;

    @Override
    public List<Family> createAll(List<Family> objs) {
        return familyRepository.saveAll(objs);
    }

    @Override
    public List<Family> updateAll(List<Family> objs) {
        return familyRepository.saveAll(objs);
    }

    @Override
    public List<Family> findAll() {
        return familyRepository.findAll();
    }

    @Override
    public Page<Family> findAll(Pageable pageable) {
        return familyRepository.findAll(pageable);
    }

    @Override
    public Optional<Family> get(String id) {
        return familyRepository.findById(id);
    }

    @Override
    public Family create(Family obj) {
        return familyRepository.save(obj);
    }

    @Override
    public Family update(Family obj) {
        return familyRepository.save(obj);
    }

    @Override
    public void delete(String id) {
        familyRepository.deleteById(id);
    }

    @Override
    public Boolean existById(String id) {
        return familyRepository.existsById(id);
    }
}
