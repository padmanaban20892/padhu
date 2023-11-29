package com.padhu.rest.webservices.restfulwebservice.user;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

@Entity(name = "users_details")
public class User {

	 protected User() {}
	
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(name = "name")
	@Size(min=2, message = "Name should altest 2 characters")
	//@JsonProperty("user_name")
	private String name;
	
	@Column(name = "dob")
	@Past(message = "DataBirth should be is past")
	//@JsonIgnore
	private LocalDate dob;
	
	private String area;
	
	@OneToMany(mappedBy = "user")
	@JsonIgnore
	private List<Post> posts;
	
	public String getArea() {
		return area;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public User(Integer userId, String name, LocalDate dob,String area) {
		super();
		this.id = userId;
		this.name = name;
		this.dob = dob;
		this.area=area;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer userId) {
		this.id = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", dob=" + dob + ", area=" + area + "]";
	}

	
}
