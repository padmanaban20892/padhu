/**
 * 
 */
package com.padhu.rest.webservices.restfulwebservice.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.padhu.rest.webservices.restfulwebservice.user.Post;

/**
 * 
 */
public interface PostRepository extends JpaRepository<Post, Integer> {

}
