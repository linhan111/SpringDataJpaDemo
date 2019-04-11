package com.example.SpringDataJpaDemo.controller;

import com.example.SpringDataJpaDemo.domain.User;
import com.example.SpringDataJpaDemo.repository.UserRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/user")
@Api(tags = "UserController", value = "用户相关操作接口")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @ApiOperation(value = "创建用户", notes = "创建用户接口，注意实体中的非空字段")
    @PostMapping(value = "/create")
    public User saveUser(@RequestBody User user) {
        return userRepository.save(user);
    }
}
