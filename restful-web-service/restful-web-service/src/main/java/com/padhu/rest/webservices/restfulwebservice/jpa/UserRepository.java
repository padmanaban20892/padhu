/**
 * 
 */
package com.padhu.rest.webservices.restfulwebservice.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.padhu.rest.webservices.restfulwebservice.user.User;

/**
 * 
 */
public interface UserRepository extends JpaRepository<User, Integer> {

}
