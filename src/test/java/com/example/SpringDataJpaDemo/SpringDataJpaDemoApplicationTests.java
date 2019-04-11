package com.example.SpringDataJpaDemo;

import com.example.SpringDataJpaDemo.domain.User;
import com.example.SpringDataJpaDemo.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringDataJpaDemoApplicationTests {

	@Autowired
	private UserRepository userRepository;

	/**
	 * 新增用户
	 */
	@Test
	public void testAddUser() {
		User user = new User().setName("caleb")
				.setPhone("0123456789");
		userRepository.save(user);
	}

	/**
	 * 根据名称查询用户
	 */
	@Test
	public void testFindByName() {
		User result = userRepository.findByName("caleb");
		System.out.println(result);
	}
}
