package it.unipd.tos.model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class UserTest {

	private User us;

	@Before
	public void setup() {
		us = new User("Francesco","Pantaleoni",21);
	}

	@Test
	public void getNameTest() {
		assertEquals("Francesco", us.getName());
	}

	@Test
	public void getSurnameTest() {
		assertEquals("Pantaleoni", us.getSurname());
	}

	@Test
	public void getAgeTest() {
		assertEquals(21, us.getAge());
	}

	@Test
	public void invalidAgeTest() {
		boolean age = true;
		if(us.getAge()<0)
			age = false;
		assertEquals(true, age);
	}
}