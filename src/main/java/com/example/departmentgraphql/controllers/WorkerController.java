package com.example.departmentgraphql.controllers;

import com.example.departmentgraphql.entities.Department;
import com.example.departmentgraphql.entities.Worker;
import com.example.departmentgraphql.repos.DepartmentRepository;
import com.example.departmentgraphql.repos.WorkerRepository;
import lombok.AllArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@AllArgsConstructor
public class WorkerController {
    WorkerRepository workerRepository;
    @QueryMapping
    public List<Worker> allWorkers(){
        return workerRepository.findAll();
    }
    @QueryMapping
    public Worker workerById(@Argument Integer id){
        return workerRepository.findById(id).orElseThrow();
    }
    @MutationMapping
    public Worker createWorker(@Argument String name, @Argument String position, @Argument int age,@Argument int income){
        return workerRepository.save(new Worker(name,income,age,position));
    }

}
