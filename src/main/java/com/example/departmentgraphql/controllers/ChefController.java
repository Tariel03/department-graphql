package com.example.departmentgraphql.controllers;

import com.example.departmentgraphql.entities.Chef;
import com.example.departmentgraphql.entities.Worker;
import com.example.departmentgraphql.repos.ChefRepository;
import com.example.departmentgraphql.services.ChefService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class ChefController {
    private final ChefService chefService;
    @QueryMapping
    public List<Chef> allChefs(){
        return chefService.findAll();
    }
    @QueryMapping
    public Chef chefById(@Argument Integer id){
        return chefService.findById(id);
    }
    @MutationMapping
    public Chef createChef(@Argument String name, @Argument String position, @Argument int income){
        return chefService.save(name, position, income);
    }
    @QueryMapping
    public Page<Chef> pageOfChefs(@Argument int size, @Argument int page){
        return chefService.getPageOfChefs(
                PageRequest.of(
                        Optional.of(page).orElse(10),
                        Optional.of(size).orElse(10))

        );

    }




}
