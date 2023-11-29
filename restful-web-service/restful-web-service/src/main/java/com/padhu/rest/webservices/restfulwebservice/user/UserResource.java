/**
 * 
 */
package com.padhu.rest.webservices.restfulwebservice.user;

import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;

/**
 * 
 */
@RestController
public class UserResource {
	
	@Autowired
	private UserDaoService userService;
	
	
	@GetMapping("/users")
	public List<User> retrieveAllUsers(){
		
		/*
		 * Map<String, Set<User>> map=userService.findAll() .stream().
		 * collect(Collectors.groupingBy( User::getArea, );
		 * 
		 * map=userService.findAll() .stream(). collect(Collectors.toMap(User::getArea,
		 * u->u ));
		 */
				
				Map<String, Set<User>> employeeListByDepartment=
						userService.findAll().stream().
						collect(Collectors.groupingBy(User::getArea,Collectors.toSet()));
				
				
				
		
		
		
		return userService.findAll();
	}
	
	@GetMapping("/users/{id}")
	public User retrieveUser(@PathVariable int id){
		User findOne = userService.findOne(id);
		
		if(findOne == null)
			throw new UserNotFoundException("id:"+id);
		return findOne;
	}
	
	@PostMapping("/users")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user){
		 User savedUser=userService.save(user);
		 ///users/{id} -> /users, user.getUserId
		 URI location = ServletUriComponentsBuilder
				 .fromCurrentRequest().path("/{id}")
				 .buildAndExpand(savedUser.getId()).toUri();
		 
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id){
		userService.deletebyId(id);
		
	}
}
