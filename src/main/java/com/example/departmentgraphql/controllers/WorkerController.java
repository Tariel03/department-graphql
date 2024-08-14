package com.example.departmentgraphql.controllers;

import com.example.departmentgraphql.entities.Department;
import com.example.departmentgraphql.entities.Worker;
import com.example.departmentgraphql.repos.DepartmentRepository;
import com.example.departmentgraphql.repos.WorkerRepository;
import com.example.departmentgraphql.services.WorkerService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
@AllArgsConstructor
public class WorkerController {
    WorkerService workerService;
    @QueryMapping
    public List<Worker> allWorkers(){
        return workerService.findAll();
    }
    @QueryMapping
    public Worker workerById(@Argument Integer id){
        return workerService.findById(id);
    }
    @MutationMapping
    public Worker createWorker(@Argument String name, @Argument String position, @Argument int age,@Argument int income
    ,@Argument Integer department_id){
        return workerService.save(name,position,age,income, department_id);
    }
    @QueryMapping
    public Page<Worker> pageOfWorkers(@Argument int size, @Argument int page){
        return workerService.getPageOfWorkers(
                PageRequest.of(
                        Optional.of(page).orElse(10),
                        Optional.of(size).orElse(10))

        );

    }

}
