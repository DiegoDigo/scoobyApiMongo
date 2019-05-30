package com.github.diegodigo.scoobyApi.controller;

import com.github.diegodigo.scoobyApi.domain.Family;
import com.github.diegodigo.scoobyApi.service.FamilyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("family")
public class FamilyController {

    @Autowired
    FamilyService familyService;

    @GetMapping("all")
    public ResponseEntity<?> getAll() {
        List<Family> families = familyService.findAll();
        if (families.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(families);
    }

    @GetMapping
    public ResponseEntity<?> getAll(Pageable pageable) {
        Page<Family> families = familyService.findAll(pageable);
        if (families.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(families);
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody Family family) {
        return ResponseEntity.status(HttpStatus.CREATED).body(familyService.create(family));
    }

    @PutMapping
    public ResponseEntity<?> update(@Valid @RequestBody Family family) {
        if (familyService.existById(family.getId())) {
            return ResponseEntity.status(HttpStatus.CREATED).body(familyService.update(family));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable("id") String id) {
        if (familyService.existById(id)) {
            familyService.delete(id);
            return ResponseEntity.status(HttpStatus.ACCEPTED).build();
        }
        return ResponseEntity.notFound().build();
    }
}
