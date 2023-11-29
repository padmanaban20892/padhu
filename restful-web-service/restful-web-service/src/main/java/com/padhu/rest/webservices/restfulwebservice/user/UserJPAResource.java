/**
 * 
 */
package com.padhu.rest.webservices.restfulwebservice.user;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.padhu.rest.webservices.restfulwebservice.jpa.PostRepository;
import com.padhu.rest.webservices.restfulwebservice.jpa.UserRepository;

import jakarta.validation.Valid;

/**
 * 
 */
@RestController
public class UserJPAResource {
	
	
	@Autowired
	private UserRepository repository;
	
	@Autowired
	private PostRepository postRepository;
	
	
	public UserJPAResource( UserRepository repository,PostRepository postRepository) {
		this.repository = repository;
		this.postRepository = postRepository;
	}

	@GetMapping("/jpa/users")
	public List<User> retrieveAllUsers(){
		return repository.findAll();
	}
	
	@GetMapping("/jpa/users/{id}")
	public User retrieveUser(@PathVariable int id){
		Optional<User> findOne = repository.findById(id);
		
		if(findOne.isEmpty())
			throw new UserNotFoundException("id:"+id);
		
		User  userList=findOne.get();
		
		return userList;
	}
	
	@PostMapping("/jpa/users")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user){
		 User savedUser=repository.save(user);
		 ///users/{id} -> /users, user.getUserId
		 URI location = ServletUriComponentsBuilder
				 .fromCurrentRequest().path("/{id}")
				 .buildAndExpand(savedUser.getId()).toUri();
		 
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("/jpa/users/{id}")
	public void deleteUser(@PathVariable int id){
		repository.deleteById(id);
		
	}
	
	@GetMapping("/jpa/users/{id}/posts")
	public List<Post> retrievePostforUsers(@PathVariable int id){
		Optional<User> userList = repository.findById(id);
		
		if(userList.isEmpty())
			throw new UserNotFoundException("id:"+id);
		
		
		
		return userList.get().getPosts();
	}
	
	@PostMapping("/jpa/users/{id}/posts")
	public ResponseEntity<Post> createPost(@PathVariable int id,@Valid @RequestBody Post post){
		Post savedPost=postRepository.save(post);
		 ///users/{id} -> /users, user.getUserId
		 URI location = ServletUriComponentsBuilder
				 .fromCurrentRequest().path("/{id}")
				 .buildAndExpand(savedPost.getId()).toUri();
		 
		return ResponseEntity.created(location).build();
	}
}
