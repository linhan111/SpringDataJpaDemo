package com.example.SpringDataJpaDemo.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Setter
@Getter
@Accessors(chain = true)
public class User {
    /**
     * name
     */
    private String name;

    /**
     * account
     */
    private String accout;
}
