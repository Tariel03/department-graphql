package com.example.departmentgraphql.services;

import com.example.departmentgraphql.entities.Chef;
import com.example.departmentgraphql.entities.Department;
import com.example.departmentgraphql.exceptions.NotFoundById;
import com.example.departmentgraphql.repos.ChefRepository;
import com.example.departmentgraphql.repos.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DepartmentService {
    private final DepartmentRepository departmentRepository;
    private final ChefService chefService;
    public List<Department> findAll(){
        return departmentRepository.findAll();
    }
    public Department findById(Integer id){
        Optional<Department> optionalDepartment = departmentRepository.findById(id);
        if(optionalDepartment.isPresent()){
            return optionalDepartment.get();
        }
        throw new NotFoundById("Not found department by this id: " +id );
    }
    public Department save(String name, String description, Integer chef_id){
        return departmentRepository.save(new Department(name, description, chefService.findById(chef_id)));
    }
    public Page<Department> getPageOfDepartments(Pageable pageable){
        return departmentRepository.findAll(pageable);
    }


}
