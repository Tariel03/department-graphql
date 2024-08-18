package com.example.departmentgraphql.security;

import com.example.departmentgraphql.entities.User;
import com.example.departmentgraphql.repos.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
@RequiredArgsConstructor
public class AppDetailsService implements UserDetailsService {
    private final UserRepository userRepository;
    private final String USER_NOT_FOUND = "user with username %s not found";
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optional = userRepository.findByUsername(username);
        if(optional.isEmpty()){
            throw new UsernameNotFoundException(String.format(USER_NOT_FOUND, username));
        }
        return new AppUserDetails(optional.get());
    }
}
