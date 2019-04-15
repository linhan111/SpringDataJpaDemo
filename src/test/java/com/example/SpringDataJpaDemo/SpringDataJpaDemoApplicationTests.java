package com.example.SpringDataJpaDemo;

import com.example.SpringDataJpaDemo.domain.User;
import com.example.SpringDataJpaDemo.domain.UserDemo;
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
     * QueryByExample and return Page, several limitations:
     * a.No support for nested or grouped property constraints, such as firstname = ?0 or (firstname = ?1 and lastname = ?2)
     * b.Only supports starts/contains/ends/regex matching for strings and exact matching for other property types
     */
    @Test
    public void testFindByExample() {
        // 默认情况Entity中的空字段不会加入查询条件
        ExampleMatcher exampleMatcher = ExampleMatcher.matchingAll()
                                                      .withMatcher("name", matcher -> matcher.startsWith().ignoreCase())
                                                      // 忽略Entity中的某些字段
                                                      .withIgnorePaths("phone", "address")
                                                      // 包括其他字段的null值
                                                      .withIncludeNullValues();

        Example<User> example = Example.of(new User().setName("caleb")
                                                     .setAddress("123")
                                                     .setPhone("110"), exampleMatcher);

        Page<User> result = userRepository.findAll(example, PageRequest.of(0, 10, Sort.by("id").descending()));
    }

    @Test
    public void testQueryUserDemoByNameAndAddress() {
        // 自定义查询并使用自定义对象作为返回值
        List<UserDemo> result = userRepository.queryUserDemoByNameAndAddress("caleb", "222");
        System.out.println(result.toString());
    }
}
