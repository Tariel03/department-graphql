package com.example.departmentgraphql.repos;

import com.example.departmentgraphql.entities.Chef;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChefRepository extends JpaRepository<Chef, Integer> {
}
