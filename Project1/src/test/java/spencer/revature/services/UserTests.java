package spencer.revature.services;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;

import org.junit.jupiter.api.Test;

import spencer.revature.beans.Pitch;
import spencer.revature.beans.StoryType;
import spencer.revature.beans.Users;

class UserTests {
	UserService us = new UserServiceImpl();
	
	@Test
	void testUserByUsername() {
		Users userr = us.getUserByUsername("S");
		assertEquals("S", userr.getUsername());
	}
	@Test
	void testGetStoryTypeByID() {
		Users userr = us.getUserById(1);
		assertEquals("S", userr.getUsername());
	}
	@Test
	void testUserGetAll() {
		Set<Users> p = us.getAll();
		assertTrue(p.size()>0);
	}

}
