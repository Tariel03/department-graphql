package com.example.departmentgraphql.controllers;

import com.example.departmentgraphql.entities.Department;
import com.example.departmentgraphql.repos.DepartmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@AllArgsConstructor
public class DepartmentController {
    DepartmentRepository departmentRepository;
    @QueryMapping
    public List<Department> allDepartment(){
        return departmentRepository.findAll();
    }
    @QueryMapping
    public Department departmentById(@Argument Integer id){
        return departmentRepository.findById(id).orElseThrow();
    }
    @MutationMapping
    public Department createDepartment(@Argument String name, @Argument String description){
        return departmentRepository.save(new Department(name, description));
    }
}
