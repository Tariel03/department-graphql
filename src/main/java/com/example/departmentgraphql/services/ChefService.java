package com.example.departmentgraphql.services;

import com.example.departmentgraphql.entities.Chef;
import com.example.departmentgraphql.entities.Worker;
import com.example.departmentgraphql.exceptions.NotFoundById;
import com.example.departmentgraphql.repos.ChefRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class ChefService {
    private final ChefRepository chefRepository;
    public List<Chef> findAll(){
        return chefRepository.findAll();
    }
    public Chef save(String name, String position, int income){
        return chefRepository.save(new Chef(name,position, income));

    }
    public Page<Chef> getPageOfChefs(Pageable pageable){
        return chefRepository.findAll(pageable);
    }

    public Chef findById(Integer id){
        Optional<Chef> optional = chefRepository.findById(id);
        if(optional.isPresent()){
            return optional.get();
        }
        throw new NotFoundById("Not found chef by this id :" + id);
    }
}
