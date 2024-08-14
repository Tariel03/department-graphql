package com.example.departmentgraphql.repos;

import com.example.departmentgraphql.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface DepartmentRepository extends JpaRepository<Department, Integer>, PagingAndSortingRepository<Department, Integer> {
}
