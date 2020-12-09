package it.unipd.tos.model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class UserTest {

	private User user;

	@Before
	public void setup() {
		user = new User("Francesco","Pantaleoni",21);
	}

	@Test
	public void getNameTest() {
		assertEquals("Francesco", user.getName());
	}

	@Test
	public void getSurnameTest() {
		assertEquals("Pantaleoni", user.getSurname());
	}

	@Test
	public void getAgeTest() {
		assertEquals(21, user.getAge());
	}

	@Test
	public void invalidAgeTest() {
		boolean b = true;
		if(user.getAge()<0)
			b = false;
		assertEquals(true, b);
	}
} 