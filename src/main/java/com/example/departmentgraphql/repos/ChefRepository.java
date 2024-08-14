package com.example.departmentgraphql.repos;

import com.example.departmentgraphql.entities.Chef;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ChefRepository extends JpaRepository<Chef, Integer>, PagingAndSortingRepository<Chef, Integer> {
}
