package com.github.diegodigo.scoobyApi.domain;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@ToString
@Document(collection = "products")
public class Product {

    @Id
    private String id;
    @NotNull
    @NotEmpty
    private String name;
    private String description;
    @NotNull
    private BigDecimal price;
    @NotNull
    @DBRef
    private Category category;
    @NotNull
    @DBRef
    private Family family;
    @NotNull
    @DBRef
    private Brand brand;
    @NotNull
    private Integer stock;
    private String image;
    private LocalDateTime registretionDate;
    private Boolean active;


    public Product() {
        this.registretionDate = LocalDateTime.now();
        this.active = true;
        this.id = UUID.randomUUID().toString();
    }
}
