package com.example.departmentgraphql.controllers;

import com.example.departmentgraphql.entities.User;
import com.example.departmentgraphql.enums.Role;
import com.example.departmentgraphql.services.UserService;
import jakarta.annotation.security.PermitAll;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @QueryMapping
    @PermitAll
//    @PostAuthorize("hasRole('USER')")
    public List<User> allUsers(){
        return userService.findAll();
    }
    @QueryMapping
    @PermitAll

//    @PostAuthorize("hasRole('USER')")
    public User userById(@Argument Integer id){
        return  userService.findById(id);
    }
    @PermitAll
    @MutationMapping
    public User createUser(@Argument String username, @Argument String password, @Argument Role role){
        return userService.save(username, password ,role);
    }
    @PermitAll
    @QueryMapping
    public User login(@Argument String username, @Argument String password){
        return userService.findByUsernameAndPassword(username, password);
    }

}
