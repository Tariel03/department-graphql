package com.example.departmentgraphql.controllers;

import com.example.departmentgraphql.entities.Chef;
import com.example.departmentgraphql.entities.Worker;
import com.example.departmentgraphql.repos.ChefRepository;
import com.example.departmentgraphql.services.ChefService;
import jakarta.annotation.security.PermitAll;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class ChefController {
    private final ChefService chefService;
//    @PostAuthorize("hasRole('ADMIN')")
    @QueryMapping
    @PermitAll
    public List<Chef> allChefs(){
        return chefService.findAll();
    }
//    @PostAuthorize("hasRole('ADMIN')")
    @PermitAll
    @QueryMapping
    public Chef chefById(@Argument Integer id){
        return chefService.findById(id);
    }

//    @PostAuthorize("hasRole('ADMIN')")
    @PermitAll
    @MutationMapping
    public Chef createChef(@Argument String name, @Argument String position, @Argument int income){
        return chefService.save(name, position, income);
    }
//    @PostAuthorize("hasRole('ADMIN')")
    @PermitAll
    @QueryMapping
    public Page<Chef> pageOfChefs(@Argument int size, @Argument int page){
        return chefService.getPageOfChefs(
                PageRequest.of(
                        Optional.of(page).orElse(10),
                        Optional.of(size).orElse(10))

        );

    }




}
