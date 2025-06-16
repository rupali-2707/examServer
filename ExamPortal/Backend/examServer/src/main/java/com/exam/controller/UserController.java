package com.exam.controller;


import com.exam.entity.Role;
import com.exam.entity.User;
import com.exam.entity.UserRole;
import com.exam.repository.RoleRepository;
import com.exam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleRepository roleRepository;

    @GetMapping("/welcome")
    public String get(){
        return "Welcome to UserController";
    }

    @PostMapping("/createUser")
    public ResponseEntity<User> createUser(@RequestBody User user) throws Exception {

        Set<UserRole> userRoles = new HashSet<>();
        Role role = new Role(2L,"learner");
        UserRole userRole = new UserRole();
        userRole.setRole(role);
        userRole.setUser(user);
        userRoles.add(userRole);
        userService.createUser(user,userRoles);

        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }


    @GetMapping("/{username}")
    public ResponseEntity<User> getUser(@PathVariable String username) throws Exception{
        User user = userService.getUser(username);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) throws Exception{
        userService.deleteUser(id);
        return new ResponseEntity<>("User Deleted", HttpStatus.OK);
    }

    @DeleteMapping("/role/{id}")
    public ResponseEntity<String> deleteRole(@PathVariable Long id) throws Exception{
        roleRepository.deleteById(id);
        return new ResponseEntity<>("Role Deleted", HttpStatus.OK);
    }


}
