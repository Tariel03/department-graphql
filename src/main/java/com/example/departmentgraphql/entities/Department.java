package com.example.departmentgraphql.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "tb_department")
@Getter
@Setter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column(columnDefinition = "TEXT")
    String description;
    String name;
    @JoinColumn(name = "chef_id")
    @OneToOne
    Chef chef;

    public Department(String description, String name) {
        this.description = description;
        this.name = name;
    }

    public Department(String description, String name, Chef chef) {
        this.description = description;
        this.name = name;
        this.chef = chef;
    }
}
