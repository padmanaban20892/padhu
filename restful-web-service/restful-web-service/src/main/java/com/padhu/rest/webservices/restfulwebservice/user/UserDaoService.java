package com.padhu.rest.webservices.restfulwebservice.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
		//JPA/Hibernate => Database
	private static List<User> users=new ArrayList<>();
	private static int userCount=0;
	
	static {
		users.add(new User(++userCount, "admin", LocalDate.now().minusYears(25),"TN"));
		users.add(new User(++userCount, "Padhu", LocalDate.now().minusYears(30),"BN"));
		users.add(new User(++userCount, "Mohan", LocalDate.now().minusYears(30),"TN"));
		users.add(new User(++userCount, "Subha", LocalDate.now().minusYears(27),"CHN"));
		users.add(new User(++userCount, "Mani", LocalDate.now().minusYears(26),"CHN"));
		users.add(new User(++userCount, "", LocalDate.now().minusYears(20),"CMB"));
	}
	
	public List<User> findAll(){
		Predicate<? super User> predicate= user -> user.getName().equals("");
		users.removeIf(predicate);
		return users;
	}
	
	
	public User save(User user) {
		users.add(user);
		return user;
	}
	
	public User findOne(int id) {
		Predicate<? super User> predicate= user -> user.getId().equals(id);
		
		return users.stream().filter(predicate).findFirst().orElse(null);
	}
	
	public void deletebyId(int id) {
		Predicate<? super User> predicate= user -> user.getId().equals(id);
		users.removeIf(predicate); // delete particlar id 
	}
}
