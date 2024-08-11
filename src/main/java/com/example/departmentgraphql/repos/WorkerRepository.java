package com.example.departmentgraphql.repos;

import com.example.departmentgraphql.entities.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkerRepository extends JpaRepository<Worker,Integer> {
}
