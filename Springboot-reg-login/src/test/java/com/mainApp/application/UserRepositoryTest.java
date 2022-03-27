package com.mainApp.application;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.mainApp.application.entity.User;
import com.mainApp.application.repository.UserRepository;


@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepositoryTest {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Test
	public void printNewUser() {
		User user = new User();
		user.setFirstName("Adarsh");
		user.setLastname("Monga"); 
		user.setEmail("asdarsh@gmail.com");
		user.setPassword("1234567");
		
		User newUser = userRepository.save(user);
		System.out.println("New user details are: " + newUser);
		
		User entity = entityManager.find(User.class, newUser.getUserId());
		System.out.println("Entity : " + entity);
		
		assertThat(entity.getEmail()).isEqualTo(user.getEmail());
	}
	
	@Test
	public void testFindingUserByEmail() {
		String email = "Shivangichaurasia@gmail.com";
		User user = userRepository.findByEmail(email);
		System.out.println("User status: " + user);
		assertThat(user).isNotNull();
	}

}
