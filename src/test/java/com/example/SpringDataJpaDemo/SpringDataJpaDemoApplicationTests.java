package com.example.SpringDataJpaDemo;

import com.example.SpringDataJpaDemo.domain.User;
import com.example.SpringDataJpaDemo.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

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
        User result = userRepository.findByName("caleb111");
        System.out.println(result);
    }


    /**
     * 无条件分页查询
     */
    @Test
    public void testQueryByPage() {
        Page<User> result = userRepository.findAll(PageRequest.of(0, 10,
                                                                  Sort.by("id").descending()));
        System.out.println("====" + result.toString());
    }

    /**
     * 查询满足条件或排序结果的top条，缺省则为1
     */
    @Test
    public void testFindFirst2User() {
        List<User> result = userRepository.findTop10ByOrderByIdDesc();
        System.out.println("====" + result.toString());
    }

    /**
     * 条件查询
     */
    @Test
    public void testFindByExample() {
        ExampleMatcher exampleMatcher = ExampleMatcher.matching()
                                                      .withMatcher("name", matcher -> matcher.startsWith().ignoreCase())
                                                      .withIgnorePaths("id")
                                                      .withIncludeNullValues();
        Example<User> example = Example.of(new User().setName("caleb"), exampleMatcher);
        List<User> result = userRepository.findAll(example);
    }
}
