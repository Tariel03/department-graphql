package com.example.departmentgraphql.entities;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "tb_worker")
@Getter
@Setter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Worker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    Integer id;
    String name;
    Integer income;
    Integer age;
    String position;
    @JoinColumn(name = "department_id")
    @ManyToOne
    Department department;

    public Worker(String name, Integer income, Integer age, String position) {
        this.name = name;
        this.income = income;
        this.age = age;
        this.position = position;
    }

    public Worker(String name, Integer income, Integer age, String position, Department department) {
        this.name = name;
        this.income = income;
        this.age = age;
        this.position = position;
        this.department = department;
    }
}
