package com.example.departmentgraphql.services;

import com.example.departmentgraphql.entities.Chef;
import com.example.departmentgraphql.entities.Worker;
import com.example.departmentgraphql.exceptions.NotFoundById;
import com.example.departmentgraphql.repos.WorkerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WorkerService {
    private final WorkerRepository workerRepository;
    private final DepartmentService departmentService;
    public List<Worker> findAll(){
        return workerRepository.findAll();
    }
    public Worker findById(Integer id){
        Optional<Worker> workerOptional = workerRepository.findById(id);
        if(workerOptional.isPresent()){
            return workerOptional.get();
        }
        throw new NotFoundById("Not found Worker by this id: " + id);
    }
    public Worker save(String name, String position, int age,  int income, Integer department_id){
        return workerRepository.save(new Worker(name, income, age,position, departmentService.findById(department_id)));
    }
    public Page<Worker> getPageOfWorkers(Pageable pageable){
        return workerRepository.findAll(pageable);
    }
}
