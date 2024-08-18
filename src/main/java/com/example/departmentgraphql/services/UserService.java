package com.example.departmentgraphql.services;

import com.example.departmentgraphql.entities.User;
import com.example.departmentgraphql.enums.Role;
import com.example.departmentgraphql.exceptions.NotFoundById;
import com.example.departmentgraphql.exceptions.NotFoundByUsername;
import com.example.departmentgraphql.exceptions.NotFoundUser;
import com.example.departmentgraphql.repos.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    public User save(String username, String password, Role role){
        return userRepository.save(new User(username, password, role));
    }
    public List<User> findAll(){
        return userRepository.findAll();
    }
    public User findById(Integer id){
        return userRepository.findById(id).orElseThrow(()
                -> new NotFoundById("Couldn't find anything by this id" + id));
    }
    public User findByUsername(String username){
        return userRepository.findByUsername(username).orElseThrow(() ->
            new NotFoundByUsername("No user by this username {}"+ username));
    }
    public User findByUsernameAndPassword(String password, String username){
        return userRepository.findByUsernameAndPassword(password, username)
                .orElseThrow(() -> new NotFoundUser("No such user by this credentials. Wrong username or/and password!"));
    }


}
