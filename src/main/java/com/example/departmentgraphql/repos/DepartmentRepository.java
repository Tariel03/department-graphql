package com.example.departmentgraphql.repos;

import com.example.departmentgraphql.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
}
