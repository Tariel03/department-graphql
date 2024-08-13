package com.example.departmentgraphql.controllers;

import com.example.departmentgraphql.entities.Department;
import com.example.departmentgraphql.repos.DepartmentRepository;
import com.example.departmentgraphql.services.ChefService;
import com.example.departmentgraphql.services.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@AllArgsConstructor
public class DepartmentController {
    DepartmentService departmentService;
    ChefService chefService;
    @QueryMapping
    public List<Department> allDepartment(){
        return departmentService.findAll();
    }
    @QueryMapping
    public Department departmentById(@Argument Integer id){
        return departmentService.findById(id);
    }
    @MutationMapping
    public Department createDepartment(@Argument String name, @Argument String description, @Argument Integer chef_id){
        return departmentService.save(name, description, chef_id);
    }
}
