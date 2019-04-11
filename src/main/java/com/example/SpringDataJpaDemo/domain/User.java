package com.example.SpringDataJpaDemo.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Setter
@Getter
@Accessors(chain = true)
@ToString
@Entity
@Table(name = "user")
public class User {

    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * name
     */
    @Column(name = "name", length = 50)
    private String name;

    /**
     * phone
     */
    @Column(name = "phone", length = 50)
    private String phone;

    /**
     * address
     */
    @Column // 省略默认列名就是属性名
    private String address;
}
