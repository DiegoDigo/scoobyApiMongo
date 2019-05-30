package com.github.diegodigo.scoobyApi.controller;

import com.github.diegodigo.scoobyApi.domain.Brand;
import com.github.diegodigo.scoobyApi.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("brand")
public class BrandController {

    @Autowired
    BrandService brandService;

    @GetMapping("all")
    public ResponseEntity<?> getAll() {
        List<Brand> brands = brandService.findAll();
        if (brands.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(brands);
    }

    @GetMapping
    public ResponseEntity<?> getAll(Pageable pageable) {
        Page<Brand> brands = brandService.findAll(pageable);
        if (brands.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(brands);
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody Brand brand) {
        return ResponseEntity.status(HttpStatus.CREATED).body(brandService.create(brand));
    }

    @PutMapping
    public ResponseEntity<?> update(@Valid @RequestBody Brand brand) {
        if (brandService.existById(brand.getId())) {
            return ResponseEntity.status(HttpStatus.CREATED).body(brandService.update(brand));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable("id") String id){
        if (brandService.existById(id)) {
            brandService.delete(id);
            return ResponseEntity.status(HttpStatus.ACCEPTED).build();
        }
        return ResponseEntity.notFound().build();
    }
}
