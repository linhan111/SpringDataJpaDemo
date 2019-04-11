package com.example.SpringDataJpaDemo.repository;

import com.example.SpringDataJpaDemo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    /**
     * 根据姓名查询用户
     *
     * @param name 姓名
     * @return User
     */
    User findByName(String name);
}
