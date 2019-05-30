package com.github.diegodigo.scoobyApi.domain;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
@ToString
@Document(collection = "categories")
public class Category {

    @Id
    private String id;
    @NotNull
    @NotEmpty
    private String name;
    private Boolean active;

    public Category() {
        this.id = UUID.randomUUID().toString();
        this.active = true;
    }
}

