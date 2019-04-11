package com.example.SpringDataJpaDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author lhan
 */
@SpringBootApplication
@EntityScan(basePackages = {"com.example.SpringDataJpaDemo.domain"}) // 不添加会扫描@Entity注解的类
@EnableJpaRepositories(basePackages = {"com.example.SpringDataJpaDemo.repository"}) // 不添加会扫描@Repository的类
@EnableJpaAuditing // 开启jpa中的auditing特性
public class SpringDataJpaDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataJpaDemoApplication.class, args);
    }
}