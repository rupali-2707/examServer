package com.exam.service.impl;

import com.exam.entity.User;
import com.exam.entity.UserRole;
import com.exam.repository.RoleRepository;
import com.exam.repository.UserRepository;
import com.exam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public User createUser(User user, Set<UserRole> userRoles) throws Exception {

        Optional<User> checkUser = Optional.ofNullable(userRepository.findByUsername(user.getUsername()));
        if(checkUser.isPresent())
            throw new Exception("User already exist !!");

        for(UserRole roles : userRoles){
            roleRepository.save(roles.getRole());
        }

        user.setUserRoles(userRoles);
        userRepository.save(user);
        return user;
    }

    @Override
    public User getUser(String username) throws Exception{
        Optional<User> user = Optional.ofNullable(userRepository.findByUsername(username));
        if(user.isEmpty())
            throw new Exception("User doesn't exist !!");

        return user.get();
    }

    @Override
    public void deleteUser(Long id) throws Exception{
        userRepository.deleteById(id);
    }
}
