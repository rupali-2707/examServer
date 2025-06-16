package com.exam;

import com.exam.entity.Role;
import com.exam.entity.User;
import com.exam.entity.UserRole;
import com.exam.service.UserService;
import com.exam.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class ExamServerApplication implements CommandLineRunner {

	@Autowired
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(ExamServerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

//		Role role =  new Role(3L,"student");
//
//		UserRole userRole = new UserRole();
//		userRole.setRole(role);
//
//		Set<UserRole> userRoleSet = new HashSet<>();
//		userRoleSet.add(userRole);
//
//		User user1 = new User(
//				"r123gupta",
//				"r1123",
//				"r1upali",
//				"gupta",
//				"rgupta123@gmail.com",
//				"7676767676",
//				userRoleSet);
//		userRole.setUser(user1);
//
//		userService.createUser(user1,userRoleSet);
	}
}
