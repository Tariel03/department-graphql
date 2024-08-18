package com.example.departmentgraphql.controllers;

import com.example.departmentgraphql.entities.Chef;
import com.example.departmentgraphql.entities.Department;
import com.example.departmentgraphql.repos.DepartmentRepository;
import com.example.departmentgraphql.services.ChefService;
import com.example.departmentgraphql.services.DepartmentService;
import jakarta.annotation.security.PermitAll;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
@AllArgsConstructor
public class DepartmentController {
    DepartmentService departmentService;
    ChefService chefService;
    @QueryMapping
    @PermitAll
    public List<Department> allDepartment(){
        return departmentService.findAll();
    }
    @QueryMapping
    @PermitAll
    public Department departmentById(@Argument Integer id){
        return departmentService.findById(id);
    }
    @MutationMapping
    @PostAuthorize("hasRole('ADMIN')")
    public Department createDepartment(@Argument String name, @Argument String description, @Argument Integer chef_id){
        return departmentService.save(name, description, chef_id);
    }
    @QueryMapping
    @PermitAll
    public Page<Department> pageOfDepartments(@Argument int size, @Argument int page){
        return departmentService.getPageOfDepartments(
                PageRequest.of(
                        Optional.of(page).orElse(10),
                        Optional.of(size).orElse(10))

        );

    }
}
