package com.example.departmentgraphql.repos;

import com.example.departmentgraphql.entities.Department;
import com.example.departmentgraphql.entities.Worker;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface WorkerRepository extends JpaRepository<Worker,Integer> , PagingAndSortingRepository<Worker,Integer> {
    List<Worker> findByDepartment(Department department);
}
