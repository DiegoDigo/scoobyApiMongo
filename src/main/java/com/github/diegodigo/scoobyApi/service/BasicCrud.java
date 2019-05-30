package com.github.diegodigo.scoobyApi.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface BasicCrud<T, K> {
    List<T> findAll();

    Page<T> findAll(Pageable pageable);

    Optional<T> get(K id);

    T create(T obj);

    List<T> createAll(List<T> objs);

    List<T> updateAll(List<T> objs);

    T update(T obj);

    void delete(K id);

    Boolean existById(K id);

}
