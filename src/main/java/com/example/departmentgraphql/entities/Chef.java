package com.example.departmentgraphql.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "tb_chef")
@Getter
@Setter
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Chef {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    String name;
    String position;
    Integer income;

    public Chef(String name, String position, Integer income) {
        this.name = name;
        this.position = position;
        this.income = income;
    }
}
