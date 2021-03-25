package com.example.Authentication;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.example.Authentication.entities.User;
import com.example.Authentication.services.UserService;

public class UserServiceTests {

	@Autowired
	private TestEntityManager entityManager;
	@Autowired
    private UserService userService;
	
	private User dummy = new User();
	
	@BeforeEach
	public void init() {		   
	         dummy.setName("Dummy");
	         dummy.setEmail("test@test.com");
	         dummy.setPassword("password");
	         entityManager.persist(dummy);
	         entityManager.flush();
	   }
	
	@Test
	public void testGetAllUsers() {
		User user = userService.GetUserByName("Dummy");
		assertEquals(user.getName(), "Dummy");
	}
	
	@Test
	public void testAuthenticatePassword() {
		boolean testusername = userService.authenticatePassword(dummy.getName(), dummy.getPassword(), dummy);
		assertEquals(testusername, true);
	}
	
}
