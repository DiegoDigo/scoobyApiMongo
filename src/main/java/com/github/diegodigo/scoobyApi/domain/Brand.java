package com.github.diegodigo.scoobyApi.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
@ToString
@AllArgsConstructor
@Document(collection = "brands")
public class Brand {

    @Id
    private String id;
    @NotNull
    @NotEmpty
    private String name;
    private Boolean active;

    public Brand() {
        this.id = UUID.randomUUID().toString();
        this.active = true;
    }

    public Brand(@NotNull @NotEmpty String name) {
        this.id = UUID.randomUUID().toString();
        this.active = true;
        this.name = name;
    }
}
