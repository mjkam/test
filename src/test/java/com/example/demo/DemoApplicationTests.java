package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class DemoApplicationTests {
	@Autowired
	UserRepository userRepository;

	@Test
	void contextLoads() {
	}

	String message = "Robert";
	MessageUtil messageUtil = new MessageUtil(message);

	@Test
	public void testPrintMessage() {
		System.out.println("Inside testPrintMessage()");
		assertEquals(message,messageUtil.printMessage());
	}

	@Test
	public void testSalutationMessage() {
		System.out.println("Inside testSalutationMessage()");
		message = "Hi!" + "Robert";
		assertEquals(message,messageUtil.salutationMessage());
	}

	@Test
	public void testUserAddAndGet() {
		User user = new User();
		user.setName("Min");
		user.setAge(100);

		userRepository.save(user);

		User user2 = userRepository.findById("Min").get();

		assertEquals(user.getName(), user2.getName());
	}

}
