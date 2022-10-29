package com.onlineshop.multistrat.chelariu.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "roles")
public class Rol {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 40, nullable = false, unique = true)
    @NotNull(message = "This section cannot be empty")
    private String name;

    @Column(length = 150, nullable = false)
    @NotNull(message ="This section cannot be empty")
    private String description;

    public Rol(Long id) {
        this.id = id;
    }

    public Rol(String name) {
        this.name = name;
    }

    public Rol(String name, String description) {
        super();
        this.name = name;
        this.description = description;
    }


    @Override
    public String toString() {
        return this.name;
    }
}
