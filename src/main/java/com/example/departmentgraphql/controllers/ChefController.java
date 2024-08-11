package com.example.departmentgraphql.controllers;

import com.example.departmentgraphql.entities.Chef;
import com.example.departmentgraphql.entities.Worker;
import com.example.departmentgraphql.repos.ChefRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import javax.swing.text.html.parser.Entity;
import java.util.List;

@Controller
@AllArgsConstructor
public class ChefController {
    private ChefRepository chefRepository;
    @QueryMapping
    public List<Chef> allChefs(){
        return chefRepository.findAll();
    }
    @QueryMapping
    public Chef chefById(@Argument Integer id){
        return chefRepository.findById(id).orElseThrow();
    }
    @MutationMapping
    public Chef createChef(@Argument String name, @Argument String position, @Argument int income){
        return chefRepository.save(new Chef(name, position, income));
    }




}
